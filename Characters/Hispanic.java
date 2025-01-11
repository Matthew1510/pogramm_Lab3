package Characters;

import Characters.Enums.Nationality;
import Characters.Enums.Nature;
import Characters.Enums.Situasion;
import Characters.Enums.Status;
import Characters.Oath.Oath;
import Characters.Oath.OathToken;
import Items.Items;

public class Hispanic extends Characters implements Dialog, Oath {
    public Hispanic(String name, Nature nature, Situasion situasion, Status status, Nationality nationality, int height, int weight, String alias) {
        super(name, nature, situasion, status, nationality, alias);
        this.weight = weight;
        this.height = height;
    }

    @Override
    public void pronoun() {
        System.out.print(" он ");
    }

    @Override
    public void say(String words) throws CustomException {
        if (words.equals(" ")) {
            throw new CustomException("необходимо что-то сказать");
        }
        System.out.print(this.name + " говорит " + words);
    }

    @Override
    public void answer(String words) throws CustomException {
        if (words.equals(" ")) {
            throw new CustomException("необходимо что-то ответить");
        }
        System.out.print(this.name + " отвечал " + words);
    }


    @Override
    public void takeOath(Characters who, Characters toWhom) {
        who.token = new OathToken(who, toWhom);
        System.out.print(" возьмет c " + who.name + " торжественную клятву верности ");
        toWhom.pronoun();
        System.out.print(" ");
        if (!who.status.equals(Status.SERVANT)) {
            Status.upCount();
        }
        who.status = Status.SERVANT;
        toWhom.status = Status.MASTER;

    }

    @Override
    public void forceOath(Characters who, Characters toWhom, Items item) {
        if (this.item.contains(item)) {
            who.token = new OathToken(who, toWhom);
            System.out.print(" заставит поклясться ");
            who.getName();
            System.out.print(" над " + item.content() + " в своей верности");
            toWhom.pronoun();
            System.out.print("и готовности ");
            System.out.print(" ");
            if (!who.status.equals(Status.SERVANT)) {
                Status.upCount();
            }
            who.status = Status.SERVANT;
            toWhom.status = Status.MASTER;
        } else {
            System.out.print(" пытается заставить ");
            who.getName();
            System.out.print("поклясться над " + item.content() + " в своей верности ");
            toWhom.pronoun();
            System.out.print(" но " + item.name() + " отсутсвуют ");
        }
    }

    @Override
    public void giveOath(Characters toWhom) {

        System.out.print(" поклясться в верности ");
        this.token = new OathToken(this, toWhom);
        toWhom.pronoun();
        System.out.print(" ");
        if (!this.status.equals(Status.SERVANT)) {
            Status.upCount();
        }
        status = Status.SERVANT;
        toWhom.status = Status.MASTER;
    }

    @Override
    public void protectMaster() {
        if (this.token.toWhom().situasion.equals(Situasion.DANGER)) {
            this.situasion = Situasion.DANGER;
            this.pronoun();
            System.out.print(" встанет на мою сторону и " + this.situasion.action());
        } else {
            System.out.print(this.token.toWhom().name + " в безопастности ");
        }
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