package SetInterface;

import classes.Characters;
import classes.Items;

public interface Oath { ;
    public void TakeOath(Characters Who, Characters ToWhom);
    public void GiveOath(Characters Who, Characters ToWhom);
    public void ForceOath(Characters Who, Characters ToWhom, Items Item);
    public void ProtectMaster(Characters Master);
}