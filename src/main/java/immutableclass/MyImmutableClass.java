package immutableclass;

import java.util.HashMap;
import java.util.Map;

public final class MyImmutableClass {
    private final int i;
    private final String name;
    private final Map<String,String> myMap;

    public MyImmutableClass(int i, String name, Map<String,String> myMap){
        this.i = i; //primitive deep copy
        this.name = name; //string are alway immutable to it will be a deep copy
        this.myMap = new HashMap<>();
        myMap.keySet().stream().map(e -> this.myMap.put(e, myMap.get(e)));
    }

    public int getI() {
        return i;
    }

    public String getName(){
        return this.name;
    }

    public Map<String, String> getMyMap(){
        return new HashMap<>(this.myMap);
    }
}

//class Runner extends MyImmutableClass{
  //this is compilation error because we cant
//}

class MainClass{
    public static void main(String... args){
        MyImmutableClass myImmutableClass = new MyImmutableClass(1,"asdf",new HashMap<>());
        MyImmutableClass myImmutableClass1 = myImmutableClass;
        System.out.println(myImmutableClass.getName());
        System.out.println(myImmutableClass1.getName());
    }
}