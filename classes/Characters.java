package classes;

import SetEnum.*;
import java.util.*;

public abstract class Characters {
    public Nature Nature;
    public Situasion Situasion;
    public String Name;
    public Status Status;
    public ArrayList<Items> Item;
    protected Boolean Alive = true;
    public int Height;
    public int Weight;
    Nationality Nationality;

    public Characters(String Name, Nature Nature, Situasion Situasion, Status Status, Nationality Nationality) throws RuntimeException{ //, ArrayList<Characters> ArrServants
        this.Name = Name;
        this.Situasion = Situasion;
        this.Nature = Nature;
        this.Nationality = Nationality;
        this.Status = Status;
        this.Item = new ArrayList<Items>();
        if(Name.equals(null)){
            throw new NullPointerException();
        }
    }

    public final void Die() throws CustomException {
        if (this.Alive == false){
            throw new CustomException(" нельзя умереть дважды ");
        }
        this.Alive = false;
        System.out.print(this.Name + " умер ");
    }

    public Boolean getAlive() {
        return Alive;
    }

    public abstract void Pronoun();// местоимение

    public void getName(){// вывести имя
        System.out.print(Name + " ");
    }

    public ArrayList<Items> getItem(){ // возвращает предметы
        return Item;
    }

    public void TakeItem(Items Item){
        this.Item.add(Item);
        System.out.print("(" + this.Name + " берет " + Item.Name() + ")");
    }
    public void GiveItem(Items Item, Characters Who){
        if (this.Item.contains(Item) == true){
            this.Item.remove(Item);
            Who.Item.add(Item);
            System.out.print(" " + this.Name + " передает " + Item.Name() + " " + Who.Name +" ");
        }
        else {
            System.out.print(" " + this.Name + " очень хочет отдать " + Item.Name() +" но его у него нет ");
        }
    }

    public final void Think(){
        this.Pronoun(); System.out.print(" думает, что ");
    }
    public final void NotThink(){
        this.Pronoun(); System.out.print(" не думает, что ");
    }

    public final void Go(String When){
        System.out.print(" поедет " + When);
    }
    public final void GoTogether(String Name, String When){
        System.out.print(" поедет вместе с " + Name + When);
    }
    public final void Follow(Characters Who, String Where){
        System.out.print(" следовать"); Who.Pronoun(); System.out.print(" за мной " + Where + " куда я скажу");
    }

    public final void Betray(Characters Who){
        this.Status = Status.SIMPLE;
        Status.downCount();
        if(Status.getCount() == 0){
            Who.Status = Status.SIMPLE;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение ссылок
        if (o == null || getClass() != o.getClass()) return false; // Проверка на null и совпадение классов
        Characters that = (Characters) o;
        return Objects.equals(Nature, that.Nature) &&
                Objects.equals(Situasion, that.Situasion) &&
                Objects.equals(Name, that.Name) &&
                Objects.equals(Status, that.Status) &&
                Objects.equals(Item, that.Item) &&
                Objects.equals(Alive, that.Alive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nature, Situasion, Name, Status, Item, Alive); // Генерация хэш-кода
    }

    @Override
    public String toString() {
        return "Characters{" +
                ", Name = '" + Name + '\'' +
                "Nature = " + Nature +
                ", Situasion = " + Situasion +
                ", Status = " + Status +
                ", Item = " + Item +
                ", Alive = " + Alive +
                '}';
    }
}
