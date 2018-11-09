package data.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//
public class Node {
    private Direction direction;
    private String description;
    private SourceType nodeType;
    private float baseline;
    //
    public Node(String description, Direction direction, SourceType type, float value) {
        this.description = description;
        this.direction = direction;
        this.nodeType = type;
        this.baseline = value;
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

    public float getBaseline() {
        return baseline;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Node{" +
                "direction=" + direction +
                ", description='" + description + '\'' +
                ", nodeType=" + nodeType +
                ", baseline=" + baseline +
                '}';
    }

}
