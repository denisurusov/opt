package data.model;

public class NodeRuntime {

    private Node node;
    private float currentValue;
    private float baseline = 0;

    public NodeRuntime(Node node) {
        this.node = node;
    }

    public NodeRuntime(Node node, float baseline) {
        this(node);
        this.baseline = baseline;
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
    compute value of this node  using set values of all dependencies
     */
    public float compute() {
        return this.currentValue = this.node.compute();
    }

    public float getCurrentValue() {
        return currentValue;
    }
}
