package run;

public class ModelRun {

    private String id;
    private String type;
    private String description;

    public ModelRun(String id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "run.ModelRun{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
