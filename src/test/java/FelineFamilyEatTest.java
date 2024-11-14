import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineFamilyEatTest {
  Feline feline; //переменная

  // Создаем экземпляр класса Feline
  @Before
  public void setUP() {
    feline = new Feline();
  }

  @Test
  public void eatMeatTest() throws Exception {

    // Вызываем метод eatMeat() для получения списка еды
    List<String> food = feline.eatMeat();

    // Проверяем что возвращаемый список совпадает с ожидаемыми значениями
    assertEquals("Вернулся неверный рацион, перепроверьте.",List.of("Животные", "Птицы", "Рыба"), food);
  }

  @Test
  public void getFamilyTest() {

    // Проверяем что метод getFamily() возвращает правильное название семейства
    assertEquals("Что-то с семейством не так. Перепроверьте. Должно быть кошачье ^^","Кошачьи", feline.getFamily());
  }

}
