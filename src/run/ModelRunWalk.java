package run;

import data.model.Direction;
import data.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelRunWalk extends ModelRun {
    private List<Target> targets = new ArrayList<>();
    private String sourceId;

    public ModelRunWalk(String id, RunnerType type, String description, String sourceId) {
        super(id, type, description);
        this.sourceId = sourceId;
    }

    @Override
    public void execute(Model model) {

    }

    public void addTarget(Target t) {
        this.targets.add(t);
    }

    public class Target {
        private String targetId;
        private Direction direction;
        private float limit;

        public Target(String targetId, Direction direction, float limit) {
            this.targetId = targetId;
            this.direction = direction;
            this.limit = limit;
        }
    }
}
