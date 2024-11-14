package com.example;

import java.util.List;

// Класс Feline, который наследует класс Animal и реализует интерфейс Predator
public class Feline extends Animal implements Predator {

    // Переопределение метода eatMeat из интерфейса Predator
    @Override
    public List<String> eatMeat() throws Exception {
        // Метод вызывает getFood() из класса Animal, передавая тип "Хищник"
        // getFood возвращает список еды для хищников (например, "Животные", "Птицы", "Рыба")
        return getFood("Хищник");
    }

    // Переопределение метода getFamily из класса Animal
    // Метод возвращает строку "Кошачьи", которая обозначает семейство
    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    // Метод возвращает количество котят (по умолчанию 1)
    // Вызывает перегруженный метод getKittens(), передавая 1 как количество котят
    public int getKittens() {
        return getKittens(1);
    }

    // Перегруженный метод, который принимает параметр kittensCount
    // Возвращает количество котят, переданное в метод
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
