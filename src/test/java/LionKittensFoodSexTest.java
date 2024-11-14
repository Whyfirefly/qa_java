import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionKittensFoodSexTest {
  private Feline felineMock;
  private Lion lion;

  @Before
  public void setUp() throws Exception {
    // Создаём мок Feline для того чтобы разорвать зависимость от Lion
    felineMock = Mockito.mock(Feline.class);

    // Передаём мок в конструктор Lion
    // создаём льва Самца c моком
    lion = new Lion("Самец", felineMock);
  }

  @Test
  public void getKittensTest() {
    // Мок объекта: когда вызывается метод getKittens(), возвращать 2
    Mockito.when(felineMock.getKittens()).thenReturn(2);

    // Проверяем что метод getKittens() класса Lion возвращает 2
    assertEquals("Ожидаем два котёнка. Где они?",2, lion.getKittens());
  }

  @Test
  public void getFoodTest() throws Exception {

    // Определяем поведение мока felineMock
    // Когда выполняется метод getFood мока felineMock с параметром Хищник", то этот метод должен вернуть Мясо
    Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо"));

    List<String> food = lion.getFood(); //еда для льва

    // Тестируем методы Lion, они будут использовать мок Feline
    // getFood() - не используем параметризацию, так как только один вариант
    // проверка, что список еды льва это еда хищника
    assertEquals("Львы питаются мясом!", List.of("Мясо"), food);
  }

  @Test
  public void shouldThrowExceptionForInvalidSexTest() {
    Feline feline = new Feline();
    // Проверяем, что при передаче некорректного значения пола будет выброшено исключение
    Exception exception = assertThrows(Exception.class, () -> {
      new Lion("Неизвестно", feline);
    });
    // Проверяем, что сообщение исключения соответствует ожидаемому
    assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
  }
}
