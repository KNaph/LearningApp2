package com.example.kylephan.learningapp2.Person;

import java.io.Serializable;

/**
 * Created by Kyle Phan on 3/19/2018.
 */

public class PersonContent implements Serializable {
    public final String id;
    public final int index;
    public final String balance;
    public final String name;
    public final String info;
    public final String bio;

    public PersonContent(String id, int index, String balance, String name, String info, String bio) {
        this.id = id;
        this.index = index;
        this.balance = balance;
        this.name = name;
        this.info = info;
        this.bio = bio;
    }

    @Override
    public String toString() {
        return name;
    }
}
