/**
 * Wykorzystanie assertThrows
 */
package com.pe.ezamowienia.mo.noticegen.service.impl

import com.pe.ezamowienia.mo.noticegen.config.GeneratorConfig
import com.pe.ezamowienia.mo.noticegen.model.NoticeData
import com.pe.ezamowienia.mo.noticegen.service.impl.VersionServiceImpl
import org.junit.Test

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertThrows

class VersionServiceImplTest {
    VersionServiceImpl versionService

    @Test
    void "test resolve for type"() {
        assertEquals("3.1.0", versionService.matchVersion(NoticeData.TypeEnum.OGL_O_ZAM))

        assertThrows(RuntimeException.class, new Executable() {
            @Override
            void execute() throws Throwable {
                versionService.matchVersion(NoticeData.TypeEnum.OGL_O_WYK_UM)
            }
        })
    }
}
