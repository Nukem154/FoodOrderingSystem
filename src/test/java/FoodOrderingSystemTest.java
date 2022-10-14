import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FoodOrderingSystemTest {

    @Test
    void createDrinkTest() {
        ByteArrayInputStream in = new ByteArrayInputStream(("1").getBytes());
        Scanner scanner = new Scanner(in);
        Drink actualDrink = FoodOrderingSystem.createDrink(scanner);

        Drink expectedDrink = new Drink();
        expectedDrink.setWithLemon(true);
        expectedDrink.setWithIceCubes(true);

        assertEquals(expectedDrink, actualDrink);

        expectedDrink.setWithIceCubes(false);

        assertNotEquals(expectedDrink, actualDrink);
    }

    @Test
    void createLunchTest() {
        ByteArrayInputStream in = new ByteArrayInputStream(("mexican").getBytes());
        Scanner scanner = new Scanner(in);

        Lunch lunch = FoodOrderingSystem.createLunch(scanner);

        assertEquals(CuisineTypeEnum.MEXICAN, lunch.getCuisineType());
    }

    @Test
    void takeOrderTest() {
        ByteArrayInputStream in = new ByteArrayInputStream(("" + System.lineSeparator() + "1" + System.lineSeparator()
                + "3" + System.lineSeparator() + "italIaN").getBytes());
        Scanner scanner = new Scanner(in);

        Order actualOrder = FoodOrderingSystem.takeOrder(scanner);

        Order expectedOrder = new Order();

        Drink drink = new Drink();
        drink.setWithLemon(true);
        expectedOrder.setDrink(drink);

        MainCourse mainCourse = new MainCourse();
        Desert desert = new Desert();
        Lunch lunch = new Lunch(CuisineTypeEnum.ITALIAN, mainCourse, desert);
        expectedOrder.setLunch(lunch);

        assertEquals(expectedOrder, actualOrder);
    }
}
