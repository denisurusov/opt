package data.model;


//
public class Node {
    private Direction  direction;
    private String     description;
    private SourceType nodeType;
    private Number value;

    public Node(String description, Direction direction, SourceType type, Number value) {
        this.description = description;
        this.direction = direction;
        this.nodeType = type;
        this.value=value;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public String getDescription() {
        return this.description;
    }

    public SourceType getType() {
        return this.nodeType;
    }
    
    public Number getValue()
    {
        return this.value;
    }
    

}
