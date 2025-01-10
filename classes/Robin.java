package classes;

import SetEnum.*;
import SetInterface.*;

public class Robin extends Characters implements Dialog {
    public Robin(String Name, Nature Nature, Situasion Situasion, Status Status) {
        super(Name, Nature, Situasion, Status);
    }

    @Override
    public void Pronoun(){
        System.out.print(" мне ");
    }

    @Override
    public void Say(String Words) throws CustomException {
        if (Words.equals("")){
            throw new CustomException("необходимо что-то сказать");
        }
        System.out.print("Робинзон говорит " + Words);
    }
    @Override
    public void Answer(String Words)  throws CustomException{
        if (Words.equals(" ")){
            throw new CustomException("необходимо что-то ответить");
        }
        System.out.print("Робинзон отвечает " + Words);
    }

}