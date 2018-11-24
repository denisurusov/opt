package run;

public enum RunnerType {
    NODE_TO_NODE("node-to-node", "change the value of one node (source) and recompute the value of another node (target). All other nodes' value are frozen"),
    MODEL_WALK("model walk", "change one node and recompute other (specified) nodes according to priority (order), direction and limits");


    private String name;
    private String description;

    //
    RunnerType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
