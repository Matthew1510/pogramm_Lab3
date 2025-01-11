package Characters;

import Characters.Enums.Nationality;
import Characters.Enums.Nature;
import Characters.Enums.Situasion;
import Characters.Enums.Status;
import Items.Offer;

public class Friends extends Characters {
    int Count;

    public Friends(String Name, Nature Nature, Situasion Situasion, Status Status, Nationality Nationality, int Count, String alias) {
        super(Name, Nature, Situasion, Status, Nationality, alias);
        this.Count = Count;
    }

    public void agree(Offer Offer) {
        System.out.print(" согласятся на " + Offer.content());
    }

    @Override
    public void pronoun() {
        System.out.print(" они ");
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
                ", Count = " + this.Count +
                '}';
    }
}