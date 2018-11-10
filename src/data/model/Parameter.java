package data.model;


public class Parameter extends Node {
    private float delta;

    public Parameter(String name, Direction direction, float value, float delta) {
        super(name, direction, SourceType.STATIC, value);
        this.delta = delta;
    }

    public float increase() {
        return this.currentValue=this.currentValue + this.delta;
    }

    public float decrease() {
        return this.currentValue=this.currentValue - this.delta;
    }

}
