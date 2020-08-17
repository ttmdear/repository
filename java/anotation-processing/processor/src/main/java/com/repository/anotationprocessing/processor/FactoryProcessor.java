package com.repository.anotationprocessing.processor;

import com.repository.anotationprocessing.anotation.CreateFactory;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class FactoryProcessor extends AbstractProcessor {
    private Elements elementUtils;
    private Filer filer;
    private Messager messager;
    private Types typeUtils;

    private String getSetterFor(String classname, VariableElement variableElement) {
        String methodName = variableElement.getSimpleName().toString();

        return format("public %s %s(%s %s) { this.%s = %s; return this;}",
                classname,
                getSetterMethodName(variableElement),
                variableElement.asType(),
                variableElement.getSimpleName(),
                variableElement.getSimpleName(),
                variableElement.getSimpleName()
        );
    }

    private String getSetterMethodName(VariableElement field) {
        String methodName = field.getSimpleName().toString();

        return "set" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotataions = new HashSet<>();

        annotataions.add(CreateFactory.class.getCanonicalName());

        return annotataions;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private boolean hasSetter(VariableElement variableElement, TypeElement typeElement) {
        String methodSetterName = getSetterMethodName(variableElement);

        for (Element element : typeElement.getEnclosedElements()) {
            if (!element.getKind().name().equals("METHOD")) {
                continue;
            }

            if (element.getSimpleName().contentEquals(methodSetterName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(CreateFactory.class);

        if (!elements.isEmpty()) {
            for (Element element : elements) {
                if (element instanceof TypeElement) {
                    try {
                        processCreateFactory((TypeElement) element, roundEnvironment);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return true;
    }

    private void processCreateFactory(TypeElement typeElement, RoundEnvironment roundEnvironment) throws IOException {
        PackageElement packageElement = (PackageElement) typeElement.getEnclosingElement();

        List<? extends Element> childsElement = typeElement.getEnclosedElements();

        final String classname = typeElement.getSimpleName() + "Factory";

        JavaFileObject javaFileObject = filer.createSourceFile(packageElement.getQualifiedName() + "." + classname);

        Writer writer = javaFileObject.openWriter();

        writer.append(format("package %s;", packageElement.getQualifiedName()));
        writer.append(format("public class %s {", classname));

        List<VariableElement> createdSetter = new ArrayList<>();

        for (Element childElement : childsElement) {
            if (childElement instanceof VariableElement) {
                VariableElement field = (VariableElement) childElement;

                if (!hasSetter(field, typeElement)) {
                    continue;
                }

                writer.append(format("private %s %s;\n", field.asType(), field.getSimpleName()));
                writer.append("\n");
                writer.append(getSetterFor(classname, field));

                createdSetter.add(field);
            }

            writer.append("\n");
        }

        // Create creat() method
        writer.append(format("public %s create() {\n", typeElement.getQualifiedName()));
        writer.append(format("%s ob = new %s();\n", typeElement.getQualifiedName(), typeElement.getQualifiedName()));

        for (VariableElement field : createdSetter) {
            writer.append(format("ob.%s(%s);\n", getSetterMethodName(field), field.getSimpleName()));
        }

        writer.append(format("return ob;\n"));
        writer.append("}");

        writer.append("}");
        writer.flush();
        writer.close();
    }
}
