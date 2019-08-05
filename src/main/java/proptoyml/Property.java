package proptoyml;


import java.util.*;

public class Property {
    private String key;
    private String value;
    private List<Property> descendant;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Property> getDescendant() {
        if(descendant == null){
            descendant = new ArrayList<>();
        }
        return descendant;
    }

    public void setDescendant(List<Property> descendant) {
        this.descendant = descendant;
    }
}
