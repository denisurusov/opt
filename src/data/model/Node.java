package data.model;


//
public class Node {
    private Direction direction;
    private String description;
    private float step;
    private Unit unit;
    private Function function;
    //
    public Node(String description, Direction direction, float step, Unit unit, Function function) {
        this.description = description;
        this.direction = direction;
        this.step = step;
        this.unit=unit;
        this.function=function;
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

    public float compute()
    {
        return this.function.compute();
    }
}
