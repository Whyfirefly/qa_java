import com.example.Feline;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
  // Объявляем переменную для класса Cat
  Cat cat;

  // Создаем мок объект для класса Feline
  @Mock
  Feline felineMock;

  // Инициализируем объект Cat, передавая ему мок объект Feline
  @Before
  public void setUP() {
    cat = new Cat(felineMock);
  }

  // Проверяем что метод getSound() возвращает правильный звук для кошки
  @Test
  public void catSoundTest() throws Exception {
    Assert.assertEquals("Ошибка - кошка издала неправильный звук!", "Мяу", cat.getSound());
  }

  @Test
  public void catFoodTest() throws Exception {
    // Настраиваем мок объект, чтобы метод eatMeat() возвращал список с "Мяско"
    Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Мяско"));

    // Получаем еду для кошки
    List<String> food = cat.getFood();

    // Проверяем что возвращаемый список еды совпадает с ожидаемым значением
    Assert.assertEquals("Ошибка - таким кошка не питается!",List.of("Мяско"), food);

    // Проверяем что метод eatMeat() был вызван один раз на мок объекте feline
    Mockito.verify(felineMock).eatMeat();
  }
}