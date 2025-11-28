
import java.util.*;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] drinks = {"Еспресо", "Капучино", "Лате", "Горещ шоколад", "Чай"};
        double[] prices = {1.50, 2.00, 2.20, 2.50, 1.20};
        double sugarPrice = 0.30;

        boolean running = true;

        while (running) {

            double total = 0;

            System.out.println("===== Кафе Машина =====");
            System.out.println("Меню:");

            for (int i = 0; i < drinks.length; i++) {
                System.out.println("- " + drinks[i] + " = " + prices[i] + " лв");
            }

            List<String> orderedDrinks = new ArrayList<>();
            List<Double> orderedPrices = new ArrayList<>();

            boolean addingDrinks = true;

            while (addingDrinks) {

                System.out.print("Изберете напитка: ");
                String input = sc.nextLine().trim();

                // *** ОПРОСТЕНА ПРОВЕРКА ЗА НАПИТКА ***
                int index = -1;
                for (int i = 0; i < drinks.length; i++) {
                    if (drinks[i].equalsIgnoreCase(input)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Невалидна напитка! Опитайте пак.");
                    continue;
                }

                System.out.print("Въведете количество: ");
                int quantity;
                try {
                    quantity = Integer.parseInt(sc.nextLine());
                    if (quantity < 1) {
                        System.out.println("Минимум 1 брой.");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Невалидно количество!");
                    continue;
                }

                System.out.print("Искате ли захар (+0.30 лв)? (да/не): ");
                String sugar = sc.nextLine().toLowerCase();
                boolean sugarAdded = sugar.equals("да");

                double priceForDrink = prices[index] * quantity;
                if (sugarAdded) priceForDrink += sugarPrice * quantity;

                total += priceForDrink;

                orderedDrinks.add(drinks[index] + " x" + quantity + (sugarAdded ? " със захар" : ""));
                orderedPrices.add(priceForDrink);

                System.out.print("Искате ли да добавите още напитки? (да/не): ");
                String more = sc.nextLine().toLowerCase();
                if (!more.equals("да")) addingDrinks = false;
            }

            System.out.println("\n===== Поръчани напитки =====");
            for (int i = 0; i < orderedDrinks.size(); i++) {
                System.out.println(orderedDrinks.get(i) + " – " + String.format("%.2f", orderedPrices.get(i)) + " лв");
            }

            System.out.println("Обща сума: " + String.format("%.2f", total) + " лв");

            System.out.print("Въведете пари: ");
            double money = sc.nextDouble();
            sc.nextLine();

            while (money < total) {
                double need = total - money;
                System.out.println("Недостатъчна сума! Трябват още: " + String.format("%.2f", need) + " лв");
                System.out.print("Добавете още пари: ");
                money += sc.nextDouble();
                sc.nextLine();
            }

            double change = money - total;
            System.out.println("Ресто: " + String.format("%.2f", change) + " лв");
            System.out.println("Поръчката е изпълнена!");

            System.out.print("Искате ли нова поръчка? (да/не): ");
            String again = sc.nextLine().toLowerCase();
            if (!again.equals("да")) running = false;

            System.out.println();
        }

        System.out.println("Благодаря че бяхте при нас, хубав ден!");
    }
}
