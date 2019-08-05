package designpatterns.creational.abstractfactory;

public class AbstractFactoryRunner {
    public static void main(String... args){
        AbstractFactory loanFactory = FactoryCreator.getFactory("loan");
        Loan homeLoad = loanFactory.getLoan("h");
        System.out.println(homeLoad.getRate());
    }

}
class FactoryCreator{
    public static AbstractFactory getFactory(String type){
        if(type.equals("loan")){
            return new LoanFactory();
        }
        return null;
    }
}
 abstract class AbstractFactory {
     abstract Loan getLoan(String type);
}
class LoanFactory extends AbstractFactory {
    public Loan getLoan(String type){
        if(type.equals("h")){
            return new HomeLoad();
        }
        if(type.equals("b")){
            return new BusinessLoad();
        }
        return null;
    }
}
abstract class Loan{
    public abstract double getRate();
}
class HomeLoad extends Loan{
    public double getRate(){
        return 1.1;
    }
}
class BusinessLoad extends Loan{
    public double getRate(){
        return 2.2;
    }
}

