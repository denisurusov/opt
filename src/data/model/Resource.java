package data.model;


public class Resource extends Node {
    public Resource(String name, Direction direction, float value) {
        super(name, direction, SourceType.CALCULATED, value);
    }
} 
