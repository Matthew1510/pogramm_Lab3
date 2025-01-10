package SetEnum;

public enum Status {
    MASTER("владеет"), SERVANT(" беспроекословно повиноваться, как командиру и капитану "), SIMPLE(" вольный ");
    private static int countServant;
    private final String Will; // воля
    Status(String Will){
        this.Will = Will;
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

    public void Will(){
        System.out.print(Will);
    }
    @Override
    public String toString(){
        return name() + "[" + Will + "]";
    }
}