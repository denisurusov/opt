package run;

public abstract class ModelRun {

    private String id;
    private RunnerType type;
    private String description;

    public ModelRun(String id, RunnerType type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public abstract void execute(Model model);

    @Override
    public String toString() {
        return "run.ModelRun{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
