package designpatterns.structrual.adapter;

public class AdapterRunner {
    public static void main(String... args){
        OurAdapterClass ourAdapterClass = new OurAdapterClass();
        //via adapter pattern you can still use the third party class functionality...
        System.out.println(ourAdapterClass.getArea(2,4));
        // and also you can use your own implementation of some functionality
        ourAdapterClass.display(2,3,4,5);
    }
}
