@Slf4j
@Configuration
public class FreemarkerConfig {

    public static final String TEMPLATES_BASE_DIR = "/templates";

    @Bean("freemarkerTemplate")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public freemarker.template.Configuration createConfiguration() {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_28);

        cfg.setClassForTemplateLoading(FreemarkerConfig.class, TEMPLATES_BASE_DIR);

        cfg.setDefaultEncoding(StandardCharsets.UTF_8.name());
        cfg.setOutputEncoding(StandardCharsets.UTF_8.name());
        cfg.setLocale(Locale.getDefault());
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setAPIBuiltinEnabled(true);

        return cfg;
    }
}
