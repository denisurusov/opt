package data.model;


public class Parameter extends Node {
    public Parameter(String name, Direction direction, Number value) {
        super(name, direction, SourceType.STATIC, value);
    }
}
