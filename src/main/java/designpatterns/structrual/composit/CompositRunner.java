package designpatterns.structrual.composit;

import java.util.ArrayList;
import java.util.List;

public class CompositRunner {
    public static void main(String...args){
        Employee ceo = new Employee("John the CEO");
        Employee subordinate1 = new Employee("Bob the subordinate");
        ceo.add(subordinate1);
        Employee subordinate2 = new Employee("Rob the subordinate");
        subordinate1.add(subordinate2);
        ceo.print();

    }
}

class Employee{
    private String name;
    private List<Employee> subordinates;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Employee employee){
        if(this.subordinates == null){
            this.subordinates = new ArrayList<>();
        }
        this.subordinates.add(employee);
    }

    public void print(){
        System.out.println("Name: " + this.name);
        for(Employee employee : this.subordinates){
            employee.print();
        }
    }

}
