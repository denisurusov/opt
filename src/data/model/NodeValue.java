package data.model;

/*
I hold and manage run-time values of the model node
 */
public class NodeValue {

    private Node node;
    private float currentValue;
    private float baseline = 0;

    public NodeValue(Node node) {
        this.node = node;
    }

    public NodeValue(Node node, float baseline) {
        this(node);
        this.baseline = baseline;
        this.currentValue = baseline;
    }

    /*
    set change the value of this node forcefully, recompute all dependencies
     */
    public float increase() {
        return this.currentValue = this.currentValue + node.getStep();
    }

    /*
       set change the value of this node forcefully, recompute all dependencies
        */
    public float decrease() {
        return this.currentValue = this.currentValue - node.getStep();
    }

    /*
    reset current value to what the model run was seeded with
     */
    public void reset() {
        this.currentValue = this.baseline;
    }

    /*
    compute value of this node  using set values of all dependencies (run the formula with getters)
     */
    public float compute(Function function) {
        return this.currentValue = function.compute();
    }

    public float getCurrentValue() {
        return currentValue;
    }

}
