package designpatterns.creational.prototype;

public class PrototypeRunner {
    public static void main(String... args){
        HeavyClass heavyClass = new HeavyClass("my heavy STring");
        System.out.println(heavyClass.getHeavyResource());
        //prototype pattern is used to create new object of same class if it depends on some heavy resources, so rather than create new heavy resources each time you create an object of this class, simply use prototype method and clone those heavy resource for performance benefits.
        HeavyClass heavyClassClone = (HeavyClass) heavyClass.getClone();
        System.out.println(heavyClass.getHeavyResource());
    }

}
