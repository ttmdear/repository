package repo.java.enumeration.methods;

public enum UserTypeEnum {
    ADMIN("A") {
        @Override
        public String toUniCode() {
            return "ADMIN(" + this.toUniCode() + ")";
        }
    },

    USER("U") {
        @Override
        public String toUniCode() {
            return "USER(" + this.toUniCode() + ")";
        }
    };

    private String code;

    UserTypeEnum(String code) {
        this.code = code;
    }

    public abstract String toUniCode();
}