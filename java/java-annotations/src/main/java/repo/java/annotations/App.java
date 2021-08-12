package repo.java.annotations;

import repo.java.annotations.annotations.AnnotationOnMethod;
import repo.java.annotations.annotations.AnnotationOnType;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class App {

    private static UserRepo userRepo = new UserRepo();

    public static void main(String[] args) throws NoSuchMethodException {
        testAnnotationOnType();
        testAnnotationOnMethod();
    }

    private static void testAnnotationOnType() {
        userRepo.getClass().getGenericInterfaces();

        Type[] parameterizedType = ((ParameterizedType) userRepo.getClass().getGenericSuperclass()).getActualTypeArguments();

        Class typeEntity = (Class) parameterizedType[0];
        Class typeId = (Class) parameterizedType[1];

        AnnotationOnType annotation = (AnnotationOnType) typeEntity.getAnnotation(AnnotationOnType.class);

        System.out.printf("\nEntity is " + typeEntity.getName());
        System.out.printf("\nID is " + typeId.getName());
        System.out.printf("\nFetch data from " + annotation.table());
    }

    private static void testAnnotationOnMethod() throws NoSuchMethodException {
        Method findByIdMethod = userRepo.getClass().getMethod("findById", String.class);

        AnnotationOnMethod annotation = findByIdMethod.getAnnotation(AnnotationOnMethod.class);

        if (annotation.logCall()) {
            System.out.printf("\nLog call");
        }
    }
}
