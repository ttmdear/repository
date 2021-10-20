/**
 * Przykład walidatora pliku
 */

package pl.dto.validators;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import pl.dto.validators.annotations.MultipartPropertiesValidation;
import pl.domain.bn.IdentityProvider;
import pl.domain.bn.ServiceProvider;
import pl.domain.enums.IdentityProviderType;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

import static java.util.Objects.nonNull;
import static pl.controllers.IdentityProvidersController.LOGO_SESSION_ATTR;
import static pl.dto.validators.common.CommonProviderValidatorHelper.buildErrorMessage;
import static pl.dto.validators.common.CommonProviderValidatorHelper.getUniqueSessionId;

@Slf4j
public class MultipartPropertiesValidator implements ConstraintValidator<MultipartPropertiesValidation, Object> {
    private static final String MULTIPART_REQUIRED = "{validator_multipart_required}";

    private String message;
    private String logo;
    private String uuidField;
    private static final long MAX_SIZE = 131072;
    private static final String LOG_EXTENSIONS = "png";
    private Class<?> entityClass;
    private String identityProviderTypeField;
    private String proxyIdentityProviderIdField;

    @Override
    public void initialize(MultipartPropertiesValidation constraintAnnotation) {
        this.message = constraintAnnotation.message();
        logo = constraintAnnotation.logo();
        uuidField = constraintAnnotation.uuid();
        entityClass = constraintAnnotation.forEntity();
        identityProviderTypeField = constraintAnnotation.identityProviderType();
        proxyIdentityProviderIdField = constraintAnnotation.proxyIdentityProviderId();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean isValid = true;
        try {
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession();

            MultipartFile multipartFile = (MultipartFile) PropertyUtils.getProperty(value, logo);
            String uuid = (String) PropertyUtils.getProperty(value, uuidField);
            byte[] validLogoFileFromSession = (byte[]) getSessionObject(session, getUniqueSessionId(LOGO_SESSION_ATTR, uuid));

            if (newFileUploaded(multipartFile)) {
                isValid = checkFile(multipartFile, context);
            } else if (ArrayUtils.isEmpty(validLogoFileFromSession) && isValidationRequired(value)) {
                isValid = false;
                buildErrorMessage(context, MULTIPART_REQUIRED, logo);
            }
        } catch (final Exception e) {
            log.error("Cant access getters in MultipartPropertiesValidator in Entity with class: "
                    + value.getClass().getName(), e);
            isValid = false;
        }
        return isValid;
    }

    private Object getSessionObject(HttpSession session, String attributeName) {
        return session.getAttribute(attributeName);
    }

    private boolean newFileUploaded(MultipartFile file) {
        return nonNull(file) && !file.isEmpty();
    }

    private boolean checkFile(MultipartFile file, ConstraintValidatorContext context) {
        boolean isValid = true;
        if (file.getSize() > MAX_SIZE || !file.getContentType().contains(LOG_EXTENSIONS)) {
            isValid = false;
            buildErrorMessage(context, message, logo);
        }
        return isValid;
    }

    private boolean isValidationRequired(Object value) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (entityClass.equals(IdentityProvider.class) && !isSimpleIdpWithNoProxy(value)) {
            return false;
        }
        return !entityClass.equals(ServiceProvider.class);
    }

    private boolean isSimpleIdpWithNoProxy(Object value) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (entityClass.equals(IdentityProvider.class)) {
            IdentityProviderType identityProviderType = (IdentityProviderType) PropertyUtils.getProperty(value, identityProviderTypeField);
            Long proxyIdentityProviderId = (Long) PropertyUtils.getProperty(value, proxyIdentityProviderIdField);
            return IdentityProviderType.SIMPLE == identityProviderType && proxyIdentityProviderId == null;
        }
        return false;
    }
}

/**
 * Zastosowanie
 */
@MultipartPropertiesValidation(logo = "logo", uuid = "uuid", forEntity = ProviderGroupLogo.class)
@Builder
@AllArgsConstructor
public class ProviderGroupFormDto {
    // ...
}
