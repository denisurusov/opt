package data.model;

public class ComputePair {
    private NodeValue value;
    private Function function;

    public ComputePair(NodeValue runtime, Function function) {
        this.value = runtime;
        this.function = function;
    }

    public float compute() {
        return this.value.compute(this.function);
    }

    public void increase() {
        this.value.increase();
        this.function.propagate();
    }

    public float getValue() {
        return this.value.getCurrentValue();
    }

    @Override
    public String toString() {
        return "ComputePair{" +
                "value=" + value +
                ", function=" + function +
                '}';
    }
}
