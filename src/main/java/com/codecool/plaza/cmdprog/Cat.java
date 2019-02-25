package com.codecool.plaza.cmdprog;

public class Cat implements Comparable<Cat>{

    /*
        Class for experimenting with comparators.
     */

    public String name;
    public int catNum;
    public Cat(String name, int catNum) {
        this.name = name;
    }


    public int compareTo(Cat cat) {

        return this.name.compareTo(cat.name);
    }
}
