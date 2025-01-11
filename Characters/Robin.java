package Characters;

import Characters.Enums.Nationality;
import Characters.Enums.Nature;
import Characters.Enums.Situasion;
import Characters.Enums.Status;

public class Robin extends Characters implements Dialog {
    public Robin(String name, Nature nature, Situasion situasion, Status status, Nationality nationality, int height, int weight, String alias) {
        super(name, nature, situasion, status, nationality, alias);
        this.weight = weight;
        this.height = height;
    }

    @Override
    public void pronoun() {
        System.out.print(" мне ");
    }

    @Override
    public void say(String Words) throws CustomException {
        if (Words.equals("")) {
            throw new CustomException("необходимо что-то сказать");
        }
        System.out.print(this.name + " говорит " + Words);
    }

    @Override
    public void answer(String Words) throws CustomException {
        if (Words.equals(" ")) {
            throw new CustomException("необходимо что-то ответить");
        }
        System.out.print(this.name + " отвечает " + Words);
    }

    @Override
    public String toString() {
        return "Characters{" +
                ", Name = '" + this.name + '\'' +
                "Nature = " + this.nature +
                ", Situasion = " + this.situasion +
                ", Status = " + this.status +
                ", Item = " + this.item +
                ", Alive = " + this.alive +
                ", Height = " + this.height +
                ", Weight = " + this.weight +
                '}';
    }
}