package org.shivam;

public class Alien {

    private int age;
    private Computer comp;

    public Alien(){
        System.out.println("Object created");
    }

    /*
    public Alien(int age, Computer comp){
        System.out.println("Parameterized constructor called");
        this.age = age;
        this.comp = comp;
    }
     */

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void code(){
        System.out.println("Coding...");
        comp.compile();
    }

}
