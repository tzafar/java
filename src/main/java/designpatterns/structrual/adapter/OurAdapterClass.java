package designpatterns.structrual.adapter;

public class OurAdapterClass extends ThirdPartyRectangleClass {
    @Override
    public void display(int x1, int y1, int x2, int y2){
        System.out.println("displaying rectangle with x1, y1, x2, y2");

    }
}
