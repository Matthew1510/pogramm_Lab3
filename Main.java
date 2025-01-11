import Characters.*;
import Characters.Enums.Nationality;
import Characters.Enums.Nature;
import Characters.Enums.Situasion;
import Characters.Enums.Status;
import Characters.Locasion.ChristianLand;
import Characters.Locasion.Locasion;
import Items.Items;
import Items.Offer;

public class Main {

    public static void main(String[] Args) {
        Hispanic Hispan = new Hispanic("Испанец", Nature.HONEST, Situasion.GOOD, Status.SIMPLE, Nationality.SPANISH, 170, 70, "пляж");
        Friends Friends = new Friends("Товарищи", Nature.HONEST, Situasion.TROUBLE, Status.SIMPLE, Nationality.SPANISH, 7, "к ним");
        Friends.locasion.setCoordinate(100.31, 54.43, 7.29);
        Robin Robin = new Robin(" Я ", Nature.HONEST, Situasion.GOOD, Status.MASTER, Nationality.ENGLISH, 175, 80, "пляж");
        OldIndian Indian = new OldIndian("Старик-индеец", Nature.HONEST, Situasion.GOOD, Status.SIMPLE, Nationality.INDIAN, 165, 70, "пляж");

        try {
            Hispan.answer(Hispan.nature.answerHow());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        ;
        Friends.getName();
        System.out.print(Friends.situasion.answer());
        Hispan.think();
        Friends.pronoun();
        System.out.print(Friends.situasion.action());
        Speech.enter();

        try {
            Hispan.say("что, если мне угодно, то ");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Hispan.goTogether(Indian, Friends.locasion);
        Offer Offer = new Offer(" мое предложение ", " мои условия ");
        Hispan.takeItem(Offer);

        Speech.enter();
        Offer.giveOffer(Friends, true);
        Offer Answer = new Offer(" ответ ", " мы согласны ");
        Friends.takeItem(Answer);
        Answer.giveOffer(Hispan, true);
        Hispan.goBackTogether(Indian, Robin.locasion);
        Speech.If();
        Friends.pronoun();
        Friends.agree(Offer);
        Speech.enter();
        if (Answer.content().equals(" мы согласны ")) {
            Hispan.pronoun();
            Hispan.takeOath(Friends, Robin);
            Friends.status.will();
        }
        Items GodsGift = new Items(" религиозные атрибуты ", " святыми дарами и евангелием ");
        Speech.enter();
        Hispan.takeItem(GodsGift);
        Speech.enter();
        Hispan.pronoun();
        Hispan.forceOath(Friends, Robin, GodsGift);
        Locasion ChristianLand = new ChristianLand(" ту ");
        Robin.follow(Friends, ChristianLand);
        Speech.enter();
        try {
            Hispan.say(" что хочет сам ");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Hispan.giveOath(Robin);
        if (Robin.getAlive() || Hispan.status.equals(Status.SIMPLE)) {
            Hispan.pronoun();
            System.out.print("не покинет меня, пока жив, или пока я сам не прогоню его");
            Speech.And();
            Friends.betray();
            if (Friends.token == null) {
                System.out.print(" при малейшем поползновении со стороны " + Friends.name + " нарушить данную мне клятву ");
                Speech.enter();
                Hispan.protectMaster();
            }
        } else if (!Robin.getAlive()) {
            System.out.print(Robin.name + " умер и теперь " + Hispan.name + " - Джанго освобожденный ");
            Hispan.betray();
        } else {
            System.out.print(Robin.name + " прогнал " + Hispan.name + ", теперь он - Джанго освобожденный ");
            Hispan.betray();
        }
    }
}