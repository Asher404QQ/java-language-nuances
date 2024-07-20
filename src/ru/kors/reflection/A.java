package ru.kors.reflection;

public class A {
    private final String aPrivateAndFinal = "aPrivateAndFinal";
    private String aPrivate;
    protected String aProtected;
    public String aPublic;

    public A(String aPrivate, String aProtected, String aPublic) {
        this.aPrivate = aPrivate;
        this.aProtected = aProtected;
        this.aPublic = aPublic;
    }

    private A() {

    }
}

