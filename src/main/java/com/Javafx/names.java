package com.Javafx;

public class names {
    public String name;
    public String father;
    public String mother;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public names(String name, String father, String mother) {
        this.name = name;
        this.father = father;
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

}