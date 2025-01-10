package SetEnum;

public enum Situasion { // возможные ситуации
    TROUBLE("страшно бедствуют и осознают безнадежность положения ", " не могут дурно поступить с помогающим "),
    GOOD(" пребывают в благополучии "," поступят исходя из своей выгоды "),
    DANGER(" в опасности ", " будет биться до последней капли крови");

    private final String Otvet;
    private final String Action;

    private Situasion (String Otvet, String Action){
        this.Otvet = Otvet;
        this.Action = Action;
    }
    public String Otvet(){ // возвращает ответ на вопрос "как дела?"
        return Otvet;
    }
    public String Action(){
        return Action;
    }
    @Override
    public String toString(){
        return name() + "[" + Otvet + ";" + Action + "]";
    }
}