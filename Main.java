import classes.*;
import SetEnum.*;

public class Main{
    public static void Enter(){
        System.out.println();
    }

    public static void main(String[] Args){
        Hispanic Hispan = new Hispanic("Испанец", Nature.HONEST, Situasion.GOOD, Status.SIMPLE);
        Friends Friends = new Friends("Товарищи", Nature.HONEST, Situasion.TROUBLE, Status.SIMPLE);
        Robin Robin = new Robin(" Я ", Nature.HONEST, Situasion.GOOD, Status.MASTER);

        try {
            Hispan.Answer(Hispan.Nature.AnswerHow());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        ;
        Friends.getName(); System.out.print(Friends.Situasion.Otvet());
        Hispan.Think(); Friends.Pronoun(); System.out.print(Friends.Situasion.Action());Enter();

        try {
            Hispan.Say("что, если мне угодно, то ");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Hispan.GoTogether("Старым индейцем ", " к ним ");
        Items Offer = new Items(" мое предложение ", " мои условия ");
        Hispan.TakeItem(Offer);Enter();
        Hispan.GiveItem(Offer, Friends);
        Items Answer = new Items(" ответ ", " мы согласны ");
        Hispan.TakeItem(Answer);
        System.out.print(" если "); Friends.Pronoun(); Friends.Agree(Offer.Content());
        Enter();
        if (Answer.Content().equals(" мы согласны ")){
            Hispan.Pronoun();
            Hispan.TakeOath(Friends, Robin); Friends.Status.Will();
        }
        Items GodsGift = new Items(" религиозные атрибуты "," святыми дарами и евангелием ");
        Enter();
        Hispan.TakeItem(GodsGift);Enter();
        Hispan.Pronoun(); Hispan.ForceOath(Friends, Robin, GodsGift); Robin.Follow(Friends, "в ту христианскую землю");
        Enter();
        try {
            Hispan.Say(" что хочет сам ");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Hispan.GiveOath(Hispan, Robin);
        if(Robin.getAlive() || Hispan.Status.equals(Status.SIMPLE)){
            Hispan.Pronoun();
            System.out.print("не покинет меня, пока жив, или пока я сам не прогоню его");
            System.out.print(" и ");
            Friends.Betray(Robin);
            if(Friends.Status.equals(Status.SIMPLE)){
                Robin.Situasion = Situasion.DANGER;
                System.out.print(" при малейшем поползновении со стороны " + Friends.Name + " нарушить данную мне клятву ");
                Enter();
                Hispan.ProtectMaster(Robin);
            }
        }
        else if(!Robin.getAlive()){
            System.out.print(Robin.Name + " умер и теперь " + Hispan.Name + " - Джанго освобожденный ");
            Hispan.Betray(Robin);
        }
        else {
            System.out.print(Robin.Name + " прогнал " + Hispan.Name + " и теперь он - Джанго освобожденный ");
            Hispan.Betray(Robin);
        }
   }
}