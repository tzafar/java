package designpatterns.creational.factory;

public class FactoryPatternRunner {
    public static void main(String... args){
        PlanFactory planFactory = new PlanFactory();
        Plan plan = planFactory.getPlan("domestic");
        System.out.println(plan.getRate());

    }

}
class PlanFactory{
    public Plan getPlan(String type){
        if(type.equals("domestic")){
            return new DomesticPlan();
        }
        if(type.equals("commercial")){
            return new CommercialPlan();
        }
        return null;
    }
}
abstract class Plan{
    abstract double getRate();

}
class DomesticPlan extends Plan{
    public double getRate(){
        return 1.5;
    }
    public String sayWhoYouAre(){
        return "domestic plan";
    }
}
class CommercialPlan extends Plan{
    public double getRate(){
        return 2.5;
    }
}

