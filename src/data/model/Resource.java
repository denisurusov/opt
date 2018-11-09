package data.model;


public class Resource extends Node{
        public Resource (String name, Direction direction)
    {
        super (name, direction, SourceType.CALCULATED);
    }
    
} 
