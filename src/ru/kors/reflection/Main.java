package ru.kors.reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        Class<Author> authorClass = Author.class;
        Main main = new Main();
        Author author = main.newInstanceNoArgs(authorClass);
        System.out.println(author);

        Field age = authorClass.getDeclaredField("age");
        int currentAge = age.getInt(author);
        System.out.println("Current age = " + currentAge);
        age.set(author, 22);
        System.out.println("After set value = " + age.getInt(author));
    }

    private Method getMethod(Class<?> cls, String methodName, List<Class<?>> params) throws NoSuchMethodException {
        Method method = cls.getMethod(methodName, params.toArray(Class[]::new));
        return method;
    }

    private <T> T newInstanceWithArgs(Class<T> cls,
                                      List<Class<?>> argsClasses,
                                      Object... args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = cls.getDeclaredConstructor(argsClasses.toArray(Class[]::new));
        List<Object> objects = Arrays.asList(args);
        T object = constructor.newInstance(objects.toArray(Object[]::new));
        return object;
    }

    private <T> T newInstanceNoArgs(Class<T> cls) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> noArgsConstr = cls.getDeclaredConstructor();
        T object = noArgsConstr.newInstance();
        return object;
    }

    private List<String> getMethodsList(Class<?> cls) {
        Method[] methods = cls.getMethods();
        return Arrays.stream(methods).map(Method::toString).toList();
    }

    private List<String> getConstructorsList(Class<?> cls) {
        Constructor<?>[] constructors = cls.getConstructors();
        return Arrays.stream(constructors).map(Constructor::toString).toList();
    }

    private List<String> getDeclaredConstructorsList(Class<?> cls) {
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        return Arrays.stream(constructors).map(Constructor::toString).toList();
    }

    private List<String> getFieldsList(Class<?> cls) {
        Field[] fields = cls.getFields();
        return Arrays.stream(fields).map(field -> {
            int modifiers = field.getModifiers() & Modifier.fieldModifiers();
            String mod = Modifier.toString(modifiers);
            String typeName = field.getType().getSimpleName();
            String fieldName = field.getName();
            return "%s %s %s".formatted(mod, typeName, fieldName);
        }).toList();
    }

    private List<String> getDeclaredFieldsList(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        return Arrays.stream(fields).map(field -> {
            int modifiers = field.getModifiers() & Modifier.fieldModifiers();
            String mod = Modifier.toString(modifiers);
            String typeName = field.getType().getSimpleName();
            String fieldName = field.getName();
            return "%s %s %s".formatted(mod, typeName, fieldName);
        }).toList();
    }

    private void classSignature(Main main) throws Exception{
        Class<?> authorClass = Class.forName("ru.kors.reflection.Author");
        System.out.printf("%s %s %s%n",
                main.getModifiers(authorClass),
                authorClass.getSimpleName(),
                main.getClassInterfaces(authorClass));

        Class<?> cls = Class.class;
        System.out.printf("%s %s %s%s%s %s%n",
                main.getModifiers(cls),
                main.getType(cls),
                cls.getSimpleName(),
                main.getGenericParams(cls),
                main.getExtends(cls),
                main.getClassInterfaces(cls));

        System.out.println(main.getType(Class.forName("ru.kors.reflection.Author$Role")));
    }

    private String getType(Class<?> cls) {
        if (cls.isInterface()) return "interface";
        if (cls.isAnnotation()) return "@interface";
        if (cls.isEnum()) return "enum";
        if (cls.isRecord()) return "record";
        else return "class";
    }

    private String getGenericParams(Class<?> cls) {
        TypeVariable<?>[] typeParams = cls.getTypeParameters();
        if (typeParams.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < typeParams.length; i++) {
            sb.append(typeParams[i].getTypeName());
            if (i < typeParams.length - 1) sb.append(", ");
        }
        return sb.append(">").toString();
    }
    private String getExtends(Class<?> cls) {
        var superclass = cls.getSuperclass();
        return " extends " + superclass.getSimpleName();
    }

    private String getClassInterfaces(Class<?> cls) {
        var interfaces = cls.getInterfaces();
        if (interfaces.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("implements ");
        for (int i = 0; i < interfaces.length; i++) {
            sb.append(interfaces[i].getSimpleName());
            if (i < interfaces.length - 1) sb.append(", ");
        }
        return sb.toString();
    }


    private String getModifiers(Class<?> cls) {
        int modifiers = cls.getModifiers() & Modifier.classModifiers();
        return Modifier.toString(modifiers);
    }
}
