import com.example.AlexLion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

// Указываем, что будем использовать MockitoJUnitRunner для работы с моками
@RunWith(MockitoJUnitRunner.class)
public class AlexLionLionTest {

  //объявляем переменные для класов Feline и Alex
  private Feline felineMock;
  private AlexLion alexLion;

  @Before
  public void setUp() throws Exception {
    felineMock = Mockito.mock(Feline.class); // Создали мок объекта Feline
    alexLion = new AlexLion(felineMock); // Создали экземпляр Alex с мок объектом Feline
  }

  // Тест для метода getKittens() класса Alex
  @Test
  public void alexKittensTest() throws Exception {
    // Проверяем, что метод getKittens() возвращает правильное количество котят (0, так как Алекс не имеет котят)
    Assert.assertEquals("Ошибка - у Алекса нет котят!", 0, alexLion.getKittens());
  }

  // Тест для метода getPlaceOfLiving() класса Alex
  @Test
  public void alexPlaceTest() throws Exception {

    // Проверяем, что метод getPlaceOfLiving() возвращает правильное место обитания (Нью-Йоркский зоопарк)
    Assert.assertEquals("Ошибка - Алекс живёт в Нью-Йоркском зоопарке!", "Нью-Йоркский зоопарк", alexLion.getPlaceOfLiving());
  }

  // Тест для метода getFriends() класса Alex
  @Test
  public void alexFriendsTest() throws Exception {

    // Проверяем, что метод getFriends() возвращает правильный список друзей (зебра Марти, бегемотиха Глория, жираф Мелман)
    Assert.assertEquals("Ошибка - вернулся неправильный список друзей Алекса!", List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман"), alexLion.getFriends());
  }

  // Тест для метода doesHaveMane()
  @Test
  public void alexDoesHaveManeTest() {
    // Проверяем что у Алекса есть грива
    assertTrue("Грива - это обязательный атрибут льва! Что-то пошло не так.", alexLion.doesHaveMane());
  }

}
