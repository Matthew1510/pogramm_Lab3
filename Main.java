import classes.*;
import SetEnum.*;

public class Main{

    public static void main(String[] Args) {
        Hispanic Hispan = new Hispanic("Испанец", Nature.HONEST, Situasion.GOOD, Status.SIMPLE, Nationality.SPANISH, 170, 70);
        Friends Friends = new Friends("Товарищи", Nature.HONEST, Situasion.TROUBLE, Status.SIMPLE, Nationality.SPANISH, 7);
        Robin Robin = new Robin(" Я ", Nature.HONEST, Situasion.GOOD, Status.MASTER, Nationality.ENGLISH,175, 80);

        try {
            Hispan.Answer(Hispan.Nature.AnswerHow());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        ;
        Friends.getName(); System.out.print(Friends.Situasion.Answer());
        Hispan.Think(); Friends.Pronoun(); System.out.print(Friends.Situasion.Action());Speech.Enter();

        try {
            Hispan.Say("что, если мне угодно, то ");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Hispan.GoTogether("Старым индейцем ", " к ним ");
        Items Offer = new Items(" мое предложение ", " мои условия ");
        Hispan.TakeItem(Offer);
        Speech.Enter();
        Hispan.GiveItem(Offer, Friends);
        Items Answer = new Items(" ответ ", " мы согласны ");
        Hispan.TakeItem(Answer);
        Speech.If();; Friends.Pronoun(); Friends.Agree(Offer.Content());
        Speech.Enter();
        if (Answer.Content().equals(" мы согласны ")){
            Hispan.Pronoun();
            Hispan.TakeOath(Friends, Robin); Friends.Status.Will();
        }
        Items GodsGift = new Items(" религиозные атрибуты "," святыми дарами и евангелием ");
        Speech.Enter();
        Hispan.TakeItem(GodsGift);
        Speech.Enter();
        Hispan.Pronoun(); Hispan.ForceOath(Friends, Robin, GodsGift); Robin.Follow(Friends, "в ту христианскую землю");
        Speech.Enter();
        try {
            Hispan.Say(" что хочет сам ");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Hispan.GiveOath(Hispan, Robin);
        if(Robin.getAlive() || Hispan.Status.equals(Status.SIMPLE)){
            Hispan.Pronoun();
            System.out.print("не покинет меня, пока жив, или пока я сам не прогоню его");
            Speech.And();
            Friends.Betray(Robin);
            if(Friends.Status.equals(Status.SIMPLE)){
                Robin.Situasion = Situasion.DANGER;
                System.out.print(" при малейшем поползновении со стороны " + Friends.Name + " нарушить данную мне клятву ");
                Speech.Enter();
                Hispan.ProtectMaster(Robin);
            }
        }
        else if(!Robin.getAlive()){
            System.out.print(Robin.Name + " умер и теперь " + Hispan.Name + " - Джанго освобожденный ");
            Hispan.Betray(Robin);
        }
        else {
            System.out.print(Robin.Name + " прогнал " + Hispan.Name + ", теперь он - Джанго освобожденный ");
            Hispan.Betray(Robin);
        }
   }
}
