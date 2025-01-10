package SetEnum;

public enum Nature {
    HONEST("с большим чистосердечием "), LIER("лукаво ");// честный лжец
    private final String How;
    Nature (String How){
        this.How = How;
    }

    public String AnswerHow(){
        return How;
    }
    @Override
    public String toString(){
        return name() + "[" + How + "]";
    }
}