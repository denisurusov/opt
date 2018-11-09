package data.model;


public class Parameter<V> extends Node {
    public Parameter(String name, Direction direction) {
        super(name, direction, SourceType.STATIC);
    }
}
