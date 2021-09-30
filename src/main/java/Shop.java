import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Single-responsibility principle
// класс Shop содержит методы характерные для магазина, но не для товара

public class Shop {
    protected Map<String, Product> products = new HashMap<>();
    protected ILogger logger;
    // конструктор
    public Shop() {
        logger = new StrBuilderLogger();
    }
    // получить список продуктов
    public List<Product> getProdList() {
        return new ArrayList<>(products.values());
    }
    // добавить продукт
    public boolean addProduct(Product product) {
        if(products.containsKey(product.code)) return false;
        products.put(product.code, product);
        logger.log("Добавлен продукт " + product);
        return true;
    }
    // удалить продукт
    public boolean delProduct(Product product) {
        if(!products.containsKey(product.code)) return false;
        products.remove(product.code);
        logger.log("Удален продукт " + product);
        return true;
    }
    // проверить существование продукта по коду
    public boolean isExists(String code) {
        return products.containsKey(code);
    }
    // поиск продукта по коду
    public Product searchByCode(String code) {
        if(products.containsKey(code))
            return products.get(code);
        return null;
    }
}
