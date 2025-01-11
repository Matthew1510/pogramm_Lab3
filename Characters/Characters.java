package Characters;

import Characters.Enums.Nationality;
import Characters.Enums.Nature;
import Characters.Enums.Situasion;
import Characters.Enums.Status;
import Characters.Locasion.Locasion;
import Characters.Oath.OathToken;
import Items.Items;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Characters {
    public Nature nature;
    public Situasion situasion;
    public String name;
    public Status status;
    public ArrayList<Items> item;
    public int height;
    public int weight;
    public Nationality nationality;
    public Locasion locasion;
    public OathToken token = null;
    protected Boolean alive = true;

    public Characters(String name, Nature nature, Situasion situasion, Status status, Nationality nationality, String alias) throws RuntimeException { //, ArrayList<Characters> ArrServants
        this.name = name;
        this.situasion = situasion;
        this.nature = nature;
        this.nationality = nationality;
        this.status = status;
        this.item = new ArrayList<Items>();
        this.locasion = new Locasion(alias);
        if (name.equals(null)) {
            throw new NullPointerException();
        }
    }

    public final void die() throws CustomException {
        if (this.alive == false) {
            throw new CustomException(" нельзя умереть дважды ");
        }
        this.alive = false;
        System.out.print(this.name + " умер ");
    }

    public final Boolean getAlive() {
        return alive;
    }

    public abstract void pronoun();// местоимение

    public final void getName() {// вывести имя
        System.out.print(name + " ");
    }

    public final ArrayList<Items> getItem() { // возвращает предметы
        return item;
    }

    public final void takeItem(Items Item) {
        this.item.add(Item);
        System.out.print("(" + this.name + " берет " + Item.name() + ")");
    }

    public final void giveItem(Items Item, Characters Who) {
        if (this.item.contains(Item) == true) {
            this.item.remove(Item);
            Who.item.add(Item);
            System.out.print(" " + this.name + " передает " + Item.name() + " " + Who.name + " ");
        } else {
            System.out.print(" " + this.name + " очень хочет отдать " + Item.name() + ", но его у него нет ");
        }
    }

    public final void think() {
        this.pronoun();
        System.out.print(" думает, что ");
    }

    public final void totThink() {
        this.pronoun();
        System.out.print(" не думает, что ");
    }

    public final void go(Locasion when) {
        System.out.print(" поедет " + when.alias);
        this.locasion.setCoordinate(when.x, when.y, when.z);
    }

    public final void goBack(Locasion when) {
        System.out.print(" возвращается " + when.alias);
        this.locasion.setCoordinate(when.x, when.y, when.z);
    }

    public final void goTogether(Characters who, Locasion when) {
        this.locasion.setCoordinate(when.x, when.y, when.z);
        who.locasion.setCoordinate(when.x, when.y, when.z);
    }

    public final void goBackTogether(Characters who, Locasion when) {
        System.out.print(" Возвращаются вместе с " + who.name + " " + when.alias);
        this.locasion.setCoordinate(when.x, when.y, when.z);
        who.locasion.setCoordinate(when.x, when.y, when.z);
    }

    public final void follow(Characters Who, Locasion Where) {
        System.out.print(" следовать");
        Who.pronoun();
        System.out.print(" за мной в " + Where.getLand() + " куда я скажу");
    }

    public final void betray() {
        this.token.toWhom().situasion = Situasion.DANGER;
        this.status = Status.SIMPLE;
        Status.downCount();
        if (Status.getCount() == 0) {
            this.token.toWhom().status = Status.SIMPLE;
        }
        this.token = null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение ссылок
        if (o == null || getClass() != o.getClass()) return false; // Проверка на null и совпадение классов
        Characters that = (Characters) o;
        return Objects.equals(nature, that.nature) &&
                Objects.equals(situasion, that.situasion) &&
                Objects.equals(name, that.name) &&
                Objects.equals(status, that.status) &&
                Objects.equals(alive, that.alive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nature, situasion, name, status, item, alive); // Генерация хэш-кода
    }

    @Override
    public String toString() {
        return "Characters{" +
                "Name = '" + name + '\'' +
                ", Nature = " + nature +
                ", Situasion = " + situasion +
                ", Status = " + status +
                ", Item = " + item +
                ", Alive = " + alive +
                '}';
    }
}