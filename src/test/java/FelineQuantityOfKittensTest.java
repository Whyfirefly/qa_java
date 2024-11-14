import com.example.Feline;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import org.junit.Test;

// Указываем, что тест будет параметризован
@RunWith(Parameterized.class)
public class FelineQuantityOfKittensTest {
  // Поле для хранения значения параметра, который мы будем передавать в метод getKittens (может быть null)
  private final Integer kittensSet;

  // Ожидаемое значение, которое метод должен вернуть
  private final int kittensGet;

  // Экземпляр класса Feline, который мы будем тестировать
  private Feline feline;

  // Конструктор, который принимает параметры для теста:
  // kittensSet — значение, передаваемое в метод, kittensGet — ожидаемое значение результата
  public FelineQuantityOfKittensTest (Integer kittensSet, int kittensGet) {
    this.kittensSet = kittensSet;
    this.kittensGet = kittensGet;
  }

  // Параметры для теста. В этом методе задаются наборы данных, которые будут передаваться в тест.
  // Каждый массив {kittensSet, kittensGet} содержит:
  // kittensSet — передаваемое значение в метод, kittensGet — ожидаемое значение результата.
  @Parameterized.Parameters
  public static Object[][] quantityOfKittens() {
    return new Object[][] {
            {null, 1},      // Если не передаём значение (null), ожидаем результат по умолчанию 1
            {0, 0},         // Если передаём 0 котят, ожидаем результат 0
            {1, 1},         // Если передаём 1 котёнка, ожидаем результат 1
            {53, 53}     // Если передаём 500 котят, ожидаем результат 53
    };
  }

  // Метод init будет выполняться перед каждым тестом.
  // В нем мы создаем новый экземпляр класса Feline.
  @Before
  public void setUP() {
    feline = new Feline(); // Инициализация объекта класса Feline перед каждым запуском теста
  }

  // Тест для проверки метода getKittens класса Feline
  @Test
  public void felineKittensTest() throws Exception{
    int actualKittens; // Переменная для хранения фактического результата

    // Если kittensSet равен null (ничего), то вызываем метод getKittens без параметра
    if (kittensSet == null) {
      // Метод без параметра должен вернуть значение по умолчанию (1)
      actualKittens = feline.getKittens();
    } else {
      // Если kittensSet не равен null, вызываем перегруженный метод getKittens с параметром
      // Метод с параметром возвращает переданное значение kittensSet
      actualKittens = feline.getKittens(kittensSet);
    }

    // Проверяем, что фактическое значение совпадает с ожидаемым
    Assert.assertEquals("Ошибка. Неправильное количество котят вернулось методом getKittens", kittensGet, actualKittens);
  }
}