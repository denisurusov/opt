package data.model;

/*
This silly model computes one node at a time.
 */
//TODO - unit test
public class SimpleModel extends Model {

    @Override
    public float compute(String nodeName) {
        return this.computeEngine.get(nodeName).compute();
    }

    @Override
    public void reset() {
        this.computeEngine.values().stream().forEach(v -> v.reset());
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
    public void setTarget(String nodeName) {
        this.targets.add(nodeName);
    }

    @Override
    public void clearTarget(String nodeName) {
        this.targets.remove(nodeName);
    }

    @Override
    public String toString() {
        return "Model printout:\n" + this.computeEngine.values().stream().map(s -> s.toString() + "\n").reduce("", String::concat);
    }
}

