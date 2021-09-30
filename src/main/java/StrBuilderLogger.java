// Dependency inversion principle
// зависимость от обстракции, а не от имплементации
public class StrBuilderLogger implements ILogger{
    protected StringBuilder log;

    public StrBuilderLogger() {
        this.log = new StringBuilder();
    }

    @Override
    public void log(String msg) {
        log.append(msg);
    }
}
