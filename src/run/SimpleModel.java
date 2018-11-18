package run;

//TODO - unit test
public class SimpleModel extends Model {

    @Override
    public float compute(String nodeName) {
        return this.computeEngine.get(nodeName).compute();
    }

    @Override
    public void reset() {
        System.out.println("Resetting the model...");
        this.computeEngine.values().stream().forEach(v -> v.reset());
        System.out.println("Resetting complete.");
    }

    @Override
    public float getValue(String nodeName) {
        return this.computeEngine.get(nodeName).getValue();
    }

    @Override
    public void setValue(String nodeName, float value) {
        this.computeEngine.get(nodeName).set(value);
    }

    @Override
    public void increase(String nodeName) {
        this.computeEngine.get(nodeName).increase();
    }

    @Override
    public void decrease(String nodeName) {
        this.computeEngine.get(nodeName).decrease();
    }

    @Override
    public String toString() {
        return this.computeEngine.values().stream().map(s -> s.toString() + "\n").reduce("", String::concat);
    }
}

