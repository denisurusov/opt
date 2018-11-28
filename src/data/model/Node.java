package data.model;


import java.util.Objects;

/*
    I hold the meta data about this particular model node
 */
public class Node {
    //Node IDs
    public static final String AVAILABLE_BUDGET = "available budget";
    public static final String DAYS_A_YEAR = "days a year";
    public static final String HOURS_A_DAY = "hours a day";
    public static final String HEADCOUNT = "headcount";
    public static final String HOURLY_RATE = "hourly rate";
    //
    private String description;
    private Unit unit;
    //TODO perhaps this is the default (natural?) direction. Each model run could override it the direction based on the model logic and purpose
    private Direction direction;
    private float step;

    //
    public Node(String description, Direction direction, float step, Unit unit) {
        this.description = description;
        this.direction = direction;
        this.step = step;
        this.unit = unit;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public String getDescription() {
        return this.description;
    }

    public float getStep() {
        return step;
    }

    @Override
    public String toString() {
        return "Node{" +
                "direction=" + direction +
                ", description='" + description + '\'' +
                ", step=" + step +
                ", unit=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Float.compare(node.step, step) == 0 &&
                direction == node.direction &&
                Objects.equals(description, node.description) &&
                unit == node.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, description, step, unit);
    }

}
