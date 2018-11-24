package run;

public class ModelRunNodeToNode extends ModelRun {
    private String sourceId;
    private String targetId;

    public ModelRunNodeToNode(String id, RunnerType type, String description, String sourceId, String targetId) {
        super(id, type, description);
        this.sourceId = sourceId;
        this.targetId = targetId;
    }

    @Override
    public void execute(Model model) {
        System.out.println("node to node from " + this.sourceId + " to " + this.targetId);
    }
}
