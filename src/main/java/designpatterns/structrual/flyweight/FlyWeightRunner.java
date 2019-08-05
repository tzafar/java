package designpatterns.structrual.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightRunner {
    public static void main(String... args){
        VehicleFactory vehicleFactory = new VehicleFactory();
        vehicleFactory.getVehicle("cycle",10);
        vehicleFactory.getVehicle("cycle",11);
        vehicleFactory.getVehicle("cycle",12);
        vehicleFactory.getVehicle("cycle",13);
        vehicleFactory.getVehicle("cycle",13);
        vehicleFactory.getVehicle("cycle",12);
        vehicleFactory.getVehicle("cycle",10);
        vehicleFactory.getVehicle("cycle",12);
        vehicleFactory.getVehicle("cycle",10);
        vehicleFactory.howManyObjectsCreated();
    }
}



class VehicleFactory{
    private Map<Integer, Vehicle> vehicleMap;
    public static Integer objectRequests = 0;
    public static Integer reusedObject = 0;

    public VehicleFactory(){
        vehicleMap = new HashMap<>();
    }

    public Vehicle getVehicle(String type, Object... obj){
        objectRequests++;
        Vehicle vehicle = null;
        if(type.equals("cycle")){
            Integer height = (Integer) obj[0];
            if(vehicleMap.containsKey(height)){
                reusedObject++;
                vehicle = vehicleMap.get(height);
            } else {
                vehicle  = new Cycle(height);
                vehicleMap.put(height,vehicle);
            }
        }
        return vehicle;
    }

    public void howManyObjectsCreated(){
        System.out.println("Total requests for objects received " + objectRequests);
        System.out.println("Total created objects are: " + vehicleMap.size());
        System.out.println("Total reused objects: " + reusedObject);
    }
}


interface Vehicle{
    public void vehicleName();
}

class Cycle implements Vehicle{
    private int height;

    public Cycle(int height){
        this.height = height;
    }

    @Override
    public void vehicleName() {
        System.out.println("This is a cycle of height " + this.height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
