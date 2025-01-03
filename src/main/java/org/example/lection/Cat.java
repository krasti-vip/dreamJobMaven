package org.example.lection;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cat implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
