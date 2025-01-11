package Characters.Enums;

public enum Nature {
    HONEST("с большим чистосердечием "), LIER("лукаво ");// честный лжец
    private final String how;

    Nature(String how) {
        this.how = how;
    }

    public String answerHow() {
        return how;
    }

    @Override
    public String toString() {
        return name() + "[" + how + "]";
    }
}