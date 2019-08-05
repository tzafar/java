package designpatterns.creational.singlton;

public class SingletonRunner {
    public static void main(String... args){
        MySingletonClass mySingletonClass = MySingletonClass.getInstance();
        //the object is not null
        System.out.println(mySingletonClass);

        MySingletonClass mySingletonClass1 = MySingletonClass.getInstance();
        //the object is not null
        System.out.println(mySingletonClass1);
    }

}

class MySingletonClass{
    private static MySingletonClass mySingletonClass;
    private MySingletonClass(){}

    public static MySingletonClass getInstance(){
        if(mySingletonClass == null){
           mySingletonClass = new MySingletonClass();
        }
        return mySingletonClass;
    }
}
