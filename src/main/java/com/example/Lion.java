package com.example;

import java.util.List;

public class Lion {

    // Поле для хранения информации о том, что у льва есть грива
    boolean hasMane;

    // Поле класс Lion для зависимости от класса Feline
    private final Feline feline;

    // Конструктор класса, который принимает параметр sex и feline (пол животного) и проверяет его
    public Lion(String sex, Feline feline) throws Exception {
        // Устанавливаем зависимость через конструктор, теперь вместо создания Feline в классе Lion мы будем получать Feline извне в конструктор Lion, как параметр
         this.feline = feline;

        // Если пол "Самец", то устанавливаем hasMane как true (самцы имеют гриву)
        if ("Самец".equals(sex)) {
            hasMane = true;
        // Если пол "Самка", то устанавливаем hasMane как false (самки не имеют гривы)
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        }
        // Если пол не "Самец" и не "Самка", выбрасывается исключение
        else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    //Feline feline = new Feline(); после инъекции создавать Feline в классе Lion стало не нужно

    // Метод возвращает количество детёнышей (котят), вызывая метод из класса Feline
    public int getKittens() {
        return feline.getKittens();
    }

    // Метод возвращает true или false в зависимости от того, есть ли у льва грива
    public boolean doesHaveMane() {
        return hasMane;
    }

    // Метод возвращает список пищи льва (для хищника), вызывая метод из класса Feline
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник"); // Вызов метода getFood() из Feline, в который передаётся тип "Хищник"
    }
}
