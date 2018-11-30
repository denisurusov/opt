package data.model;

public class NodeBoundaries {
    private float baseline = 0;
    private float minimum = Float.MIN_VALUE;
    private float maximum = Float.MAX_VALUE;

    public NodeBoundaries(float baseline) {
        this.baseline = baseline;
    }

    public NodeBoundaries(float baseline, float target) {
        this.baseline = baseline;
        if (target > baseline)
            this.maximum = target;
        else
            this.minimum = target;
    }

    public NodeBoundaries(float baseline, float minimum, float maximum) {
        this.baseline = baseline;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public float getBaseline() {
        return baseline;
    }

    public float getMinimum() {
        return minimum;
    }

    public float getMaximum() {
        return maximum;
    }
}
