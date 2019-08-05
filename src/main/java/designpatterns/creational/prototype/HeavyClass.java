package designpatterns.creational.prototype;

public class HeavyClass implements ProtoType {
    private String heavyResource;

    public HeavyClass(String heavyResource){
        this.heavyResource = heavyResource;
    }

    public String getHeavyResource() {
        return heavyResource;
    }

    public void setHeavyResource(String heavyResource) {
        this.heavyResource = heavyResource;
    }

    public ProtoType getClone(){
        return new HeavyClass(this.heavyResource);
    }
}
