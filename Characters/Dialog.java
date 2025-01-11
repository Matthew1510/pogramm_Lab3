package Characters;

public interface Dialog {
    public void say(String Words) throws CustomException;

    public void answer(String Words) throws CustomException;
}