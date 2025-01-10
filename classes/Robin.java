package classes;

import SetEnum.*;
import SetInterface.*;

public class Robin extends Characters implements Dialog {
    public Robin(String Name, Nature Nature, Situasion Situasion, Status Status, Nationality Nationality,int Height, int Weight) {
        super(Name, Nature, Situasion, Status, Nationality);
        this.Weight = Weight;
        this.Height = Height;
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
        System.out.print(this.Name+ " говорит " + Words);
    }
    @Override
    public void Answer(String Words)  throws CustomException{
        if (Words.equals(" ")){
            throw new CustomException("необходимо что-то ответить");
        }
        System.out.print(this.Name+ " отвечает " + Words);
    }
    @Override
    public String toString() {
        return "Characters{" +
                ", Name = '" + this.Name + '\'' +
                "Nature = " + this.Nature +
                ", Situasion = " + this.Situasion +
                ", Status = " + this.Status +
                ", Item = " + this.Item +
                ", Alive = " + this.Alive +
                ", Height = " + this.Height +
                ", Weight = " + this.Weight +
                '}';
    }
}
