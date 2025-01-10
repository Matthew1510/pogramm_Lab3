package SetInterface;

import classes.CustomException;
public interface Dialog {
    public void Say(String Words) throws CustomException;
    public void Answer(String Words) throws CustomException;
}