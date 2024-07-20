package ru.kors.reflection;

public class B extends A{
    private final String bPrivateAndFinal = "bPrivateAndFinal";
    private String bPrivate;
    protected String bProtected;
    public String bPublic;

    public B(String aPrivate, String aProtected, String aPublic, String bPrivate, String bProtected, String bPublic) {
        super(aPrivate, aProtected, aPublic);
        this.bPrivate = bPrivate;
        this.bProtected = bProtected;
        this.bPublic = bPublic;
    }
}
