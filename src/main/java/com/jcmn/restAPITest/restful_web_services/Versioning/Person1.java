package com.jcmn.restAPITest.restful_web_services.Versioning;

public class Person1 {
    private String fullName;

    public Person1(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "fullName='" + fullName + '\'' +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
