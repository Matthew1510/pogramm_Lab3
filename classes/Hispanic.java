package classes;

import SetEnum.*;
import SetInterface.*;

public class Hispanic extends Characters implements Dialog, Oath {
    public Hispanic(String Name, Nature Nature, Situasion Situasion, Status Status) {
        super(Name, Nature, Situasion, Status);
    }

    @Override
    public void Pronoun(){
        System.out.print(" он ");
    }

    @Override
    public void Say(String Words) throws CustomException{
        if (Words.equals(" ")){
            throw new CustomException("необходимо что-то сказать");
        }
        System.out.print(" Испанец говорит " + Words);
    }
    @Override
    public void Answer(String Words) throws CustomException{
        if (Words.equals(" ")){
            throw new CustomException("необходимо что-то ответить");
        }
        System.out.print(" Испанец отвечал " + Words);
    }


    @Override
    public void TakeOath(Characters Who, Characters ToWhom) {
        System.out.print(" возьмет c " + Who.Name + " торжественную клятву верности ");ToWhom.Pronoun(); System.out.print(" ");
        if (!Who.Status.equals(Status.SERVANT)){
            Status.upCount();
        }
        Who.Status = SetEnum.Status.SERVANT;
        ToWhom.Status = SetEnum.Status.MASTER;

    }
    @Override
    public void ForceOath(Characters Who, Characters ToWhom, Items Item) {
        if (this.Item.contains(Item)) {
            System.out.print(" заставит поклясться ");
            Who.getName();
            System.out.print(" над " + Item.Content() + " в своей верности");
            ToWhom.Pronoun();
            System.out.print("и готовности ");
            System.out.print(" ");
            if (!Who.Status.equals(Status.SERVANT)){
                Status.upCount();
            }
            Who.Status = SetEnum.Status.SERVANT;
            ToWhom.Status = SetEnum.Status.MASTER;
        }
        else {
            System.out.print(" пытается заставить ");
            Who.getName();
            System.out.print("поклясться над " + Item.Content() + " в своей верности ");
            ToWhom.Pronoun();
            System.out.print(" но " + Item.Name() + " отсутсвуют ");
        }
    }
    @Override
    public void GiveOath(Characters Who, Characters ToWhom) {
        System.out.print(" поклясться в верности ") ;ToWhom.Pronoun(); System.out.print(" ");
        if (!Who.Status.equals(Status.SERVANT)){
            Status.upCount();
        }
        Status = SetEnum.Status.SERVANT;
        ToWhom.Status = SetEnum.Status.MASTER;
    }

    @Override
    public void ProtectMaster(Characters Master){
        if (Master.Situasion.equals(SetEnum.Situasion.DANGER)){
            this.Situasion = Situasion.DANGER;
            this.Pronoun(); System.out.print(" встанет на мою сторону и " + this.Situasion.Action());
        }
        else {
            System.out.print(Master.Name + " в безопастности ");
        }
    }
}