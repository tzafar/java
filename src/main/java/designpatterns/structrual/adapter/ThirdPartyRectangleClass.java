package designpatterns.structrual.adapter;

public class ThirdPartyRectangleClass {

    public double getArea(int width, int height){
        return width * height;
    }

    public void display(int x1, int y1, int width, int height){
        System.out.println("dispalying string with x1, y1, height and width");
    }
}
