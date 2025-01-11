package Characters.Oath;

import Characters.Characters;
import Items.Items;

public interface Oath {
    ;

    public void takeOath(Characters Who, Characters ToWhom);

    public void giveOath(Characters ToWhom);

    public void forceOath(Characters Who, Characters ToWhom, Items Item);

    public void protectMaster();
}