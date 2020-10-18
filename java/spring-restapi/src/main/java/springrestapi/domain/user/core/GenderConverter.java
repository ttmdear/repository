package springrestapi.domain.user.core;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        if (gender.equals(Gender.MEN)) {
            return "m";
        } else if (gender.equals(Gender.FAMALE)) {
            return "f";
        } else {
            return null;
        }
    }

    @Override
    public Gender convertToEntityAttribute(String gender) {
        if (gender.equals("m")) {
            return Gender.MEN;
        } else if (gender.equals("f")) {
            return Gender.FAMALE;
        } else {
            return null;
        }
    }
}
