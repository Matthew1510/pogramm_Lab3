package Items;

import java.util.Objects;

public class Items {
    public String name;
    public String content;

    public Items(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String name() {
        return name;
    }

    public String content() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение ссылок
        if (o == null || getClass() != o.getClass()) return false; // Проверка на null и совпадение классов
        Items that = (Items) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, content); // Генерация хэш-кода
    }

    @Override
    public String toString() {
        return "Item{" +
                "Name = '" + name + '\'' +
                ", content = " + content +
                '}';
    }
}