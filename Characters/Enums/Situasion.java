package Characters.Enums;

public enum Situasion { // возможные ситуации
    TROUBLE("страшно бедствуют и осознают безнадежность положения ", " не могут дурно поступить с помогающим "),
    GOOD(" пребывают в благополучии ", " поступят исходя из своей выгоды "),
    DANGER(" в опасности ", " будет биться до последней капли крови");

    private final String answer;
    private final String action;

    private Situasion(String answear, String action) {
        this.answer = answear;
        this.action = action;
    }

    public String answer() { // возвращает ответ на вопрос "как дела?"
        return answer;
    }

    public String action() {
        return action;
    }

    @Override
    public String toString() {
        return name() + "[" + answer + ";" + action + "]";
    }
}