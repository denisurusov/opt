package data.model;

/*
I hold and manage run-time values of the model node
 */
public class NodeValue {

    private Node node;
    private float currentValue;
    private boolean isTarget = false;
    private NodeBoundaries boundaries;

    public NodeValue(Node node) {
        this.node = node;
    }

    public NodeValue(Node node, NodeBoundaries boundaries) {
        this(node);
        this.boundaries = boundaries;
        this.currentValue = this.boundaries.getBaseline();
    }


    public float set(float value) {
        return this.currentValue = value;
    }

    /*
    reset current value to what the model run was seeded with
     */
    public void reset() {
        this.currentValue = this.boundaries.getBaseline();
        this.clearTarget();
    }

    /*
    compute value of this node  using set values of all dependencies (run the formula with getters)
     */
    public float compute(Function function) {
        return this.currentValue = (isTarget ? this.currentValue : function.compute());
    }

    public float getCurrentValue() {
        return currentValue;
    }

    public void setTarget() {
        isTarget = true;
    }

    public void clearTarget() {
        isTarget = false;
    }

    @Override
    public String toString() {
        return "NodeValue{" +
                "node=" + node +
                ", currentValue=" + currentValue +
                '}';
    }

}
