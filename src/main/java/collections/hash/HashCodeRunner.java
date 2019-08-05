package collections.hash;

import java.util.Objects;

public class HashCodeRunner {
    public static void main(String... args){
        System.out.println("abc".hashCode());
        System.out.println("abc".hashCode());

        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Toseef");



        Person p2 = new Person();
        p2.setId(1);
        p2.setName("Toseef");

        //the hashCode method should return the same value as p1.hasCode because actually both objects are same
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        //comment out equals method in Person to see before after
        //this will return false but effectively objects are same.
        System.out.println(p1.equals(p2));
    }
}

class Person{
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //comment this function out to see before and after
    @Override
    public boolean equals(Object p){
        return (this.getId() == ((Person)p).getId() && this.getName().equals(((Person)p).getName()));
    }

    //comment this function out to see before and after
    @Override
    public int hashCode() {
        return this.getId();
    }
}
