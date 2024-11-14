package com.example;
import java.util.List;

//Класс Алекса наследует класс Lion
public class AlexLion extends Lion {
  public AlexLion(Feline feline) throws Exception {
    // Передаем "Самец" в конструктор родительского класса Lion
    super("Самец", feline); // Передаем "Самец" в конструктор родительского класса Lion
  }

  // Возвращаем список друзей Алекса
  public List<String> getFriends() {
    return List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
  }

  // Возвращаем место жительства Алекса
  public String getPlaceOfLiving() {
    return "Нью-Йоркский зоопарк";
  }

  // Переопределяем метод, так как у Алекса нет львят
  @Override
  public int getKittens() {
    return 0;
  }
}
