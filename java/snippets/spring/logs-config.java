/**
 * Przykład konfiguracji logów z określonym schematem oraz dla określonych klas
 * z określonym poziomem.
 */

logging:
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss.SSS}:${info.app.name}:${PID}:${HOSTNAME}:%X{UUID} %-5level %thread --- %logger{36} : %msg%n"
  level:
    com.export.zamowien: DEBUG
