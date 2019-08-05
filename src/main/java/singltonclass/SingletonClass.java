package singltonclass;

public class SingletonClass {
    public static SingletonClass singletonClassInstance;
    private String name;
    private SingletonClass(){ }
    public SingletonClass(String name){
        if(singletonClassInstance == null){
            singletonClassInstance = new SingletonClass();
            this.name = name;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Runner{
     public static void main(String... args){
        SingletonClass singletonClass = new SingletonClass("Toseef");
        SingletonClass singletonClass1 = new SingletonClass("zafar");
         System.out.printf(singletonClass.getName());
         System.out.printf(singletonClass1.getName());
         singletonClass.setName("Mijja");
         System.out.printf(singletonClass1.getName());

    }
}
