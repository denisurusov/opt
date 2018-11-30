package run;

public class ModelRunNodeToNode extends ModelRun {
    private String sourceId;
    private String targetId;
    private float newValue;

    public ModelRunNodeToNode(String id, RunnerType type, String description, String sourceId, float newValue, String targetId) {
        super(id, type, description);
        this.sourceId = sourceId;
        this.newValue = newValue;
        this.targetId = targetId;
    }

    @Override
    public void execute(Model model) {
        model.setValue(this.sourceId, this.newValue);
        model.setTarget(this.targetId);
        System.out.println("Computed value:\t" + model.compute(this.targetId));
        model.clearTarget(this.targetId);
    }

    @Override
    public String toString() {
        return "ModelRunNodeToNode{" +
                "sourceId='" + sourceId + '\'' +
                ", targetId='" + targetId + '\'' +
                ", newValue=" + newValue +
                ", type=" + type +
                '}';
    }
}
