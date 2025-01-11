package Characters.Locasion;

import java.util.Objects;

public class Locasion {
    public String alias;
    public double x = 0.0;
    public double y = 0.0;
    public double z = 0.0;

    public Locasion(String alias) {
        this.alias = alias;
    }

    public void setCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void getCoordinates() {
        System.out.print(" координаты:" + x + ", " + y + ", " + z);
    }

    public String getLand() {
        return alias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение ссылок
        if (o == null || getClass() != o.getClass()) return false; // Проверка на null и совпадение классов
        Locasion that = (Locasion) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y) &&
                Objects.equals(z, that.z);
    }

    @Override
    public String toString() {
        return "locasion{" + alias +
                ", coordinats(" +
                x + ", " + y + ", " + z + ")}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(alias, x, y, z); // Генерация хэш-кода
    }
}