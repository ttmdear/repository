package repo.java.annotations;

import repo.java.annotations.annotations.AnnotationInherited;
import repo.java.annotations.annotations.AnnotationNotInherited;
import repo.java.annotations.annotations.AnnotationOnMethod;
import repo.java.annotations.annotations.AnnotationOnPackage;
import repo.java.annotations.annotations.AnnotationOnType;
import repo.java.annotations.entities.AdminUser;
import repo.java.annotations.services.UserRepo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class App {

    private static UserRepo userRepo = new UserRepo();

    public static void main(String[] args) throws NoSuchMethodException {
        testAnnotationOnPackage();
        testAnnotationOnType();
        testAnnotationOnMethod();
        testAnnotationInherited();
    }

    private static void testAnnotationInherited() {
        AnnotationInherited annotationInherited = AdminUser.class.getAnnotation(AnnotationInherited.class);
        AnnotationNotInherited annotationNotInherited = AnnotationNotInherited.class.getAnnotation(AnnotationNotInherited.class);

        System.out.printf("\nannotationInherited " + annotationInherited);
        System.out.printf("\nannotationNotInherited " + annotationNotInherited);
    }

    private static void testAnnotationOnPackage() throws NoSuchMethodException {
        Method findByIdMethod = userRepo.getClass().getMethod("findById", String.class);

        AnnotationOnPackage annotation = findByIdMethod.getDeclaringClass().getPackage().getAnnotation(AnnotationOnPackage.class);

        if (annotation.logOnPackage()) {
            System.out.printf("Log on package level");
        }
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
