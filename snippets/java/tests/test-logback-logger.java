/**
 * Jednym ze sposób na przetestowanie loggera jest utworzenie własnego
 * apendera.
 */

package com.mo.importer.auditlogger.service;

import java.util.List;
import java.util.stream.Collectors;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

public class MemoryAppender extends ListAppender<ILoggingEvent> {
    public int countEventsForLogger(String loggerName) {
        return (int) this.list.stream()
            .filter(event -> event.getLoggerName().contains(loggerName))
            .count();
    }

    public ILoggingEvent getLast() {
        if (list.isEmpty()) {
            return null;
        }

        return list.get(list.size() - 1);
    }

    public int getSize() {
        return this.list.size();
    }

    public void reset() {
        this.list.clear();
    }

    public List<ILoggingEvent> searchByLevel(org.apache.logging.log4j.Level level) {
        return this.list.stream()
            .filter(event -> event.getLevel().levelStr.equals(level.toString()))
            .collect(Collectors.toList());
    }
}

/**
 * Następnie
 */
package com.mo.importer.auditlogger.service

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.LoggerContext
import com.mo.importer.auditlogger.service.config.AuditLoggerConfiguration
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.slf4j.LoggerFactory

import static com.mo.importer.auditlogger.common.Category.INPUT
import static com.mo.importer.auditlogger.common.EventType.RUN_NOTICES_IMPORTER_FROM_TED
import static com.mo.importer.auditlogger.common.Result.SUCCESS
import static org.junit.Assert.assertEquals

class AuditLoggerServiceTest {
    AuditLoggerConfiguration auditLoggerConfiguration
    AuditLoggerService auditLoggerService
    Logger logger
    MemoryAppender memoryAppender

    @Before
    void setUp() {
        auditLoggerConfiguration = Mockito.mock(AuditLoggerConfiguration.class)
        logger = Mockito.mock(Logger.class)

        /**
         * Zwróć uwagę, że mamy mapowanie na Loggera z biblioteki LogBack
         * dlatego, że slf4j nie definiuje taki operacji jak np. addAppender
         * itp.
         */
        memoryAppender = new MemoryAppender()
        memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory())

        Logger logger = (Logger) LoggerFactory.getLogger("audit")
        logger.addAppender(memoryAppender)

        memoryAppender.start()

        Mockito.when(auditLoggerConfiguration.getParameters(AuditLoggerService.resolveEventTypeKey(
            RUN_NOTICES_IMPORTER_FROM_TED, INPUT, SUCCESS))).thenReturn(
            new AuditLoggerConfiguration.Parameters(
                "Pobieranie oferty. Liczba ofert do pobrania: {0}. Liczba ofert pobranych: {1}. " +
                    "Numer ostatniego pobranego ofert: {2}.",

                "WNIOSKI-12/23"
            ),
        )

        auditLoggerService = new AuditLoggerService(auditLoggerConfiguration)
    }

    @Test
    void testGetLogBuilder() {
        Log log = auditLoggerService.getLogBuilder(RUN_NOTICES_IMPORTER_FROM_TED, INPUT, SUCCESS,
            Arrays.asList("10", "20", "30")).build()

        auditLoggerService.info(log)

        assertEquals("Pobieranie oferty. Liczba ofert do pobrania: 10. Liczba ofert pobranych: 20. " +
            "Numer ostatniego pobranego ofert: 30.", memoryAppender.getLast().getMessage())
    }
}
