import java.util.Arrays;
import java.util.Scanner;

public class FoodOrderingSystem {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("To place an order press enter");
        scanner.nextLine();

        Order order = takeOrder(scanner);

        System.out.println("Your order: " + order);

    }

    public static Order takeOrder(Scanner scanner) {
        System.out.println("""
                Please, choose a number of an order you would like:\s
                1 - Lunch and drink
                2 - Lunch
                3 - Drink""");

        final Order order = new Order();

        switch (scanner.nextInt()) {
            case 1 -> {
                order.setDrink(createDrink(scanner));
                order.setLunch(createLunch(scanner));
            }
            case 2 -> {
                order.setLunch(createLunch(scanner));
            }
            case 3 -> {
                order.setDrink(createDrink(scanner));
            }
            default -> {
                System.out.println("Wrong number");
                return takeOrder(scanner);
            }
        }
        return order;
    }

    public static Drink createDrink(Scanner scanner) {
        System.out.println("""
                Would you like ice cubes/lemon to a drink\s
                1 - ice cubes with a lemon
                2 - ice cubes
                3 - lemon
                other - no, thank you""");

        final Drink drink = new Drink();

        switch (scanner.nextInt()) {
            case 1 -> {
                drink.setWithIceCubes(true);
                drink.setWithLemon(true);
            }
            case 2 -> drink.setWithIceCubes(true);
            case 3 -> drink.setWithLemon(true);
        }

        return drink;
    }

    public static Lunch createLunch(Scanner scanner) {
        System.out.println("Please, choose you cuisine: " + Arrays.toString(CuisineTypeEnum.values()));

        String cuisine = scanner.next();
        CuisineTypeEnum cuisineType = null;

        try {
            cuisineType = CuisineTypeEnum.valueOf(cuisine.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("There's no cuisine with type " + cuisine);
            createLunch(scanner);
        }

        final MainCourse mainCourse = new MainCourse();
        final Desert desert = new Desert();
        return new Lunch(cuisineType, mainCourse, desert);
    }
}
