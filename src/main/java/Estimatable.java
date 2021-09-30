// Interface segregation principle
// разделение на маленькие интерфейсы: отдельный интерфейс для выставления оценок
public interface Estimatable {
    void estimate(int estim);
    double calcArgEstim();
}
