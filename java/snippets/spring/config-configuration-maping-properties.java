/**
 * Przykład mapowania plików właściwości na klasę
 */

generator:
  validation:
    required-notice-data: BT-08,BT-11,BT-10
    required-notice-list-data: BT-500,BT-501,BT-510,BT-513,BT-514,BT-507


@Getter
@Setter
@ConfigurationProperties(prefix = "generator")
@Configuration
public class GeneratorConfig {
    private ValidationConfig validation;

    @Getter
    @Setter
    public static class ValidationConfig {
        private List<String> requiredNoticeData;
        private List<String> requiredNoticeListData;
    }
}
