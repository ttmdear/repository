import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class FreemarkerTemplateService implements TemplateService {
    private static final String TEMPLATE_EXT = ".ftl";
    private Configuration configuration;

    public FreemarkerTemplateService(@Qualifier("freemarkerTemplate") Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String applyTemplate(String templateName, Map<String, Object> data) {
        Objects.requireNonNull(templateName, "TemplateName must not be null");
        Objects.requireNonNull(data, "Template data must not be null");

        try {
            log.debug("Processing template [{}]", templateName);
            Template template = configuration.getTemplate(templateName);

            Map<String, Object> freemarkerContext = new HashMap<>();
            freemarkerContext.put("countCodes", new CountCodesInList());
            freemarkerContext.putAll(data);

            StringWriter out = new StringWriter();
            template.process(freemarkerContext, out);
            log.debug("Template processed successfully");

            return out.toString();
        } catch (IOException e) {
            throw new GenerationException(String.format("Cannot create template for [%s]", templateName), e);
        } catch (TemplateException e) {
            throw new GenerationException(String.format("Error while processing template [%s]", templateName), e);
        }
    }

    @Override
    public boolean isTemplateExists(String templateType) {
        try {
            String templateName = getTemplateName(templateType);
            configuration.getTemplate(templateName);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String getTemplateName(String noticeType) {
        return noticeType + TEMPLATE_EXT;
    }
}
