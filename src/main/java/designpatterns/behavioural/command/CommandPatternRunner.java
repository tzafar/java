package designpatterns.behavioural.command;

import java.util.ArrayList;
import java.util.List;

public class CommandPatternRunner {
    public static void main(String... args){
        Ingredient boiledWater = new BoiledWater();
        Ingredient salt = new Salt();
        Ingredient rice = new Rice();

        BrokerCookAnty brokerCookAnty = new BrokerCookAnty();
        brokerCookAnty.addIngredient(boiledWater);
        brokerCookAnty.addIngredient(salt);
        brokerCookAnty.addIngredient(rice);

        //we have deferred the execution to this point below i.e. executing COMMANDs of cooking something
        brokerCookAnty.cook();
    }
}

class BrokerCookAnty{
    private List<Ingredient> ingredients;

    public BrokerCookAnty(){
        ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void cook(){
        this.ingredients.stream().forEach(Ingredient::add);
    }
}

interface Ingredient{
    public void add();
}

class Salt implements Ingredient{
    public void add(){
        System.out.println("Added salt");
    }
}

class Rice implements Ingredient{
    public void add(){
        System.out.println("Added rice");
    }
}

class BoiledWater implements Ingredient{
    public void add(){
        System.out.println("Added boiled water");
    }
}
