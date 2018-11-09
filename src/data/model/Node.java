package data.model;


//
public class Node {
    private Direction  direction;
    private String     description;
    private SourceType nodeType;

    public Node(String description, Direction direction, SourceType type) {
        this.description = description;
        this.direction = direction;
        this.nodeType = type;
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

}
