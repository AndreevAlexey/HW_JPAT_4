//Liskov substitution principle
// класс Food - наследник класса Product,
// т.к. является частным случаем(имеет свои особенности, например, срок годности)
public class Food extends Product {
    protected int expDays;


    public Food(String code, String name, double price, Unit unit, String factory, int expDays) {
        super(code, name, price, unit, factory);
        this.expDays = expDays;
    }

    @Override
    public String toString() {
        return "Продукт:" +
                "код товара ='" + code + '\'' +
                "наименование ='" + name + '\'' +
                ",цена =" + price +
                ",ед. =" + unit +
                ",срок годности =" + expDays +
                ",производитель ='" + factory + '\'' +
                "рейтинг = " + calcArgEstim();
    }


}
