package springrestapi.domain.user.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat
public enum Gender {
    MEN("m"), FAMALE("f");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    @JsonCreator
    public Gender createFromValue(String value) {
        switch (value) {
            case "m":
                return MEN;
            case "f":
                return FAMALE;
        }

        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

