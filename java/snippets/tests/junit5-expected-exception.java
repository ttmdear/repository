/**
 * Przykład testów sprawdzających czy zostały wyrzucone wyjątki.
 */

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import static org.hamcrest.Matchers.*

class NoticeDataValidatorImplTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none()

    @Test
    void "test missing required 'data' field"() {
        def templateServiceMock = Mockito.mock(FreemarkerTemplateService)
        def validator = new NoticeDataValidatorImpl(templateServiceMock)

        Mockito.when(templateServiceMock.isTemplateExists(NOTICE_TYPE)).thenReturn(true)

        def notice = new NoticeData()
        notice.type = NOTICE_TYPE

        expectedException.expect(allOf(
            instanceOf(ValidationException.class),
            hasProperty("errorCode", equalTo(ErrorCodes.MISSING_DATA.code))
        ))

        validator.validate(notice)
    }

    @Test
    void "test missing required 'type' field"() {
        def templateServiceMock = Mockito.mock(FreemarkerTemplateService)
        def validator = new NoticeDataValidatorImpl(templateServiceMock)

        Mockito.when(templateServiceMock.isTemplateExists(NOTICE_TYPE)).thenReturn(true)

        def notice = new NoticeData()
        notice.data = new ArrayList<>()
        notice.data << new Data(id: 'BT-08', value: 'val1')

        expectedException.expect(allOf(
            instanceOf(ValidationException.class),
            hasProperty("errorCode", equalTo(ErrorCodes.MISSING_TYPE.code))
        ))

        validator.validate(notice)
    }
}
