import java.util.List;
import java.util.Scanner;

public class Main {
    // DRY
    static String scanStrvalue(String sign){
        Scanner scanner = new Scanner(System.in);
        System.out.println(sign);
        return scanner.nextLine();
    }
    // DRY
    static int scanIntvalue(String sign){
        Scanner scanner = new Scanner(System.in);
        System.out.println(sign);
        return scanner.nextInt();
    }
    // DRY
    static void printProducts(List<Product> productList) {
        productList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Product curProduct = null;
        Scanner scanner = new Scanner(System.in);
        String input;
        int choise;
        int estim;
        Shop shop = new Shop();
        shop.addProduct(new Food("1","milk", 10, Unit.LITER, "Vilage", 10));
        shop.addProduct(new Food("2","meat", 100, Unit.KG, "Vilage", 5));
        shop.addProduct(new Food("3","aggs", 30, Unit.PACK, "Vilage", 30));

        String menu = "Выберите действие:"
                + "\n1. Оценить товар"
                + "\n2. Поиск товара по коду"
                + "\n3. Вывести список товаров"
                + "\n0. Выход";
        // основной цикл программы
        while(true){
            System.out.println(menu);
            // считываем выбор операции
            try {
                choise = scanner.nextInt();
            } catch (NumberFormatException ex) {
                System.out.println("Введено некорректное значение!");
                continue;
            }
            // проверка на выход
            if (choise == 0) {
                break;
            }
            // обработка
            switch(choise){
                // Оценить товар
                case 1:{
                    if(curProduct != null) {
                        try {
                            estim = scanIntvalue( "Ваша оценка:");
                            curProduct.estimate(estim);
                        } catch (NumberFormatException ex) {
                            System.out.println("Введено некорректное значение!");
                        }
                    }
                    break;
                }
                // Поиск товара
                case 2:{
                    input = scanStrvalue( "Введите код товара:");
                    curProduct = shop.searchByCode(input);
                    System.out.println(curProduct);
                    break;
                }
                // Вывести список товаров
                case 3:{
                    printProducts(shop.getProdList());
                    break;
                }

            }
        }
    }
}
