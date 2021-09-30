import java.util.Objects;

public abstract class Product  implements Estimatable{
    protected String code;
    protected String name;
    protected double price;
    protected Unit unit;
    protected String factory;
    protected int sumEstim;
    protected int cntEstim;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Product(String code, String name, double price, Unit unit, String factory) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.factory = factory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
    // hashCode
    @Override
    public int hashCode(){
        return Objects.hash(this.code);
    }
    // equals
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Product other = (Product) obj;
        return this.code.equals(other.code);
    }
    @Override
    public String toString() {
        return "Продукт:" +
                "код товара ='" + code + '\'' +
                "наименование ='" + name + '\'' +
                "цена =" + price +
                "ед. =" + unit +
                "производитель ='" + factory + '\'' +
                "рейтинг = " + calcArgEstim();

    }
    @Override
    public void estimate(int estim) {
        sumEstim = sumEstim + estim;
        cntEstim++;
    }

    @Override
    public double calcArgEstim() {
        return (double) sumEstim/cntEstim;
    }
}
