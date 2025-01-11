package Characters.Locasion;

public class ChristianLand extends Locasion {
    public ChristianLand(String alias) {
        super(alias);
    }

    @Override
    public String getLand() {
        return alias + "христианскую землю";
    }
}