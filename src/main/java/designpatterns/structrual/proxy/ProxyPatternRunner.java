package designpatterns.structrual.proxy;

public class ProxyPatternRunner {
    public static void main(String... args){
        ProxyPrinter proxyPrinter = new ProxyPrinter();
        proxyPrinter.printPappers();
    }
}

interface PrinterAccess{
    public void printPappers();
}


class RealPrinter implements PrinterAccess{

    public void initialization(){
        System.out.println("Some heavy initialization for real pritner");
    }

    @Override
    public void printPappers(){
        initialization();
        System.out.println("Actual printer printing pappers");
    }
}

class ProxyPrinter implements PrinterAccess {
    RealPrinter realPrinter;

    @Override
    public void printPappers() {
        boolean doesThisUserCanPrint = true;
        boolean isPagesLessThan10 = true;
        boolean isPrintinPolicyMet = true;
        boolean someOtherCheckIsTrue = true;

        //check all the pre conditions before instantiating the heavy object
        // real heavy object is only created when its absolutely clear that we are good to create it.
        if(doesThisUserCanPrint == true &&
            isPagesLessThan10 == true &&
            isPagesLessThan10 == true &&
            someOtherCheckIsTrue == true){
            realPrinter = new RealPrinter();
            realPrinter.printPappers();
        }
    }
}