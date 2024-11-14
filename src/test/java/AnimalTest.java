import com.example.Animal; // Импорт класса Animal, который мы будем тестировать.
import org.junit.Test; // Импорт аннотации @Test из JUnit, которая обозначает метод как тест.
import java.util.List; // Импорт класса List, так как метод getFood возвращает список.
import static org.junit.Assert.assertEquals; // Импорт метода assertEquals, который используется для проверки равенства ожидаемого и фактического результата.
import static org.junit.Assert.assertThrows; // Импорт метода assertThrows, который проверяет, что метод выбрасывает исключение.

public class AnimalTest {

  @Test
  public void getFoodHerbTest() throws Exception {
    // Создаем экземпляр Animal
    Animal animal = new Animal();
    // Запрашиваем еду для травоядного животного
    List<String> food = animal.getFood("Травоядное");
    // Проверяем что полученный список еды соответствует ожидаемому
    assertEquals(List.of("Травы"), food);
  }

  @Test
  public void getFoodPredatorTest() throws Exception {
    // Создаем экземпляр Animal
    Animal animal = new Animal();
    // Запрашиваем еду для хищного животного
    List<String> food = animal.getFood("Хищник");
    // Проверяем что полученный список еды соответствует ожидаемому
    assertEquals(List.of("Мяско"), food);
  }

  @Test
  public void getFoodUnknownTypeTest() {
    // Создаем экземпляр Animal
    Animal animal = new Animal();
    // Проверяем что при запросе еды для неизвестного типа животного выдается исключение
    Exception exception = assertThrows(Exception.class, () -> {
      animal.getFood("Животное неопределено.");
    });
    // Проверяем что сообщение об ошибке соответствует ожидаемому
    assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
  }

  @Test
  public void getFamilyTest() {
    // Создаем экземпляр Animal
    Animal animal = new Animal();
    // Проверяем что метод getFamily возвращает ожидаемое значение
    assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
  }
}