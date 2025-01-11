package Characters.Enums;

public enum Status {
    MASTER("владеет"), SERVANT(" беспроекословно повиноваться, как командиру и капитану "), SIMPLE(" вольный ");
    private static int countServant;
    private final String will; // воля

    Status(String will) {
        this.will = will;
    }

    public static void upCount() {
        countServant += 1;
    }

    public static void downCount() {
        countServant -= 1;
    }

    public static int getCount() {
        return countServant;
    }

    public void will() {
        System.out.print(will);
    }

    @Override
    public String toString() {
        return name() + "[" + will + "]";
    }
}