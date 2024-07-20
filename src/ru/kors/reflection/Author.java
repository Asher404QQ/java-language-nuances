package ru.kors.reflection;

import java.io.Serializable;

public final class Author implements Cloneable, Serializable {
    private final static Role role = new Role("ADMIN");
    public String authorName;
    int age;

    public Author() {
    }

    public Author(String authorName, int age) {
        this.authorName = authorName;
        this.age = age;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getAge() {
        return age;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Author clone() {
        try {
            return (Author) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    record Role(String roleName){}
}

