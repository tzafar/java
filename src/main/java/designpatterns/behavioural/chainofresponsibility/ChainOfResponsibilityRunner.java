package designpatterns.behavioural.chainofresponsibility;

public class ChainOfResponsibilityRunner {


    public static Communicator getCommunicator(){
        PharmacyCommunicator pharmacyCommunicator = new PharmacyCommunicator();
        DoctorCommunicator doctorCommunicator = new DoctorCommunicator();
        PatiendCommunicator patiendCommunicator = new PatiendCommunicator();
        HostpitalCommunicator hostpitalCommunicator = new HostpitalCommunicator();

        doctorCommunicator.setNextCommunicator(patiendCommunicator);
        patiendCommunicator.setNextCommunicator(pharmacyCommunicator);
        pharmacyCommunicator.setNextCommunicator(hostpitalCommunicator);
        return doctorCommunicator;
    }
    public static void main(String... args){
        Communicator mainCommunicator = getCommunicator();
        mainCommunicator.sendCommunication("Toseef was given paracetamol");
    }
}

abstract class Communicator{

    protected Communicator nextCommunicator;

    public void setNextCommunicator(Communicator nextCommunicator){
        this.nextCommunicator = nextCommunicator;
    }

    public void sendCommunication(String message){
        sendComms(message);
        if(this.nextCommunicator != null){
            this.nextCommunicator.sendCommunication(message);
        }

    }

    protected abstract void sendComms(String message);
}

class PharmacyCommunicator extends Communicator{
    @Override
    public void sendComms(String message){
        System.out.println("Pharmacy communicator: " + message);
    }
}

class PatiendCommunicator extends Communicator{
    @Override
    public void sendComms(String message){
        System.out.println("Patient communicator: " + message);
    }
}
class HostpitalCommunicator extends Communicator{
    @Override
    public void sendComms(String message){
        System.out.println("Hostpital communicator: " + message);
    }
}

class DoctorCommunicator extends Communicator{
    @Override
    public void sendComms(String message){
        System.out.println("Doctor communicator: " + message);
    }
}


