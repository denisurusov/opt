package data.model;


public class Resource extends Node {
    protected Function function;

    public Resource(String name, Direction direction, float value, Function function) {
        super(name, direction, SourceType.CALCULATED, value);
        this.function = function;
    }

    public float compute() {
        return this.currentValue = this.function.compute();
    }
} 
