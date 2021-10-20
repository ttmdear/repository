/**
 * Do konwertera możliwe jest wstrzyknięcie komponentu Springa.
 */
public class MyAttributeConverter implements AttributeConverter<X,Y> {
    private final MySpringBean bean;

    public MyAttributeConverter(MySpringBean bean) {
        this.bean = bean;
    }

    public Y convertToDatabaseColumn(X attribute) {
        // ...
    }

    public X convertToEntityAttribute(Y dbData) {
        // ...
    }
}

/**
 * Użycie @Autowired do wstrzyknięcia zależności.
 */
@Component
@Converter
@Configurable
public class MyAttributeConverter implements AttributeConverter<X,Y> {
    //Where: X = the type of the entity attribute and Y = the type of the database column

    private static MyRepository myRepository;

    @Autowired
    public void initMyRepository(MyRepository myRepository){
        MyAttributeConverter.myRepository = myRepository;
    }

    Y convertToDatabaseColumn(X attribute){//TODO implement method}
    X convertToEntityAttribute(Y dbData){//TODO implement method}
}

import javax.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class MyConverter implements AttributeConverter<String, String> {
    @Autowired
    private MyBean mybean;

    public String convertToDatabaseColumn(String value) {
        return myBean.changeValue(value);
    }

    public String convertToEntityAttribute(String dbValue) {
        return myBean.undoChange(dbValue);
    }
}
