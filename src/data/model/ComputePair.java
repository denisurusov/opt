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

    public void setTarget() {
        this.value.setTarget();
    }

    public void clearTarget() {
        this.value.clearTarget();
    }

    public void set(float value)
    {
        this.value.set(value);
    }
    
    public void reset()
    {
        this.value.reset();
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
