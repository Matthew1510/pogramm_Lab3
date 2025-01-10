package classes;

import SetEnum.*;

public class Friends extends Characters{
    public Friends(String Name, Nature Nature, Situasion Situasion, Status Status) {
        super(Name, Nature, Situasion, Status);
    }

    public void Agree(String Offer){
        System.out.print(" согласятся на " + Offer);
    }

    @Override
    public void Pronoun(){
        System.out.print(" они ");
    }

}