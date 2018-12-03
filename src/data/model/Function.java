package data.model;

/*
    I calculate the value of a given node when the nodes that are a part of the formula change
 */

import java.util.HashSet;
import java.util.Set;

public abstract class Function {
    protected Model model;
    protected final Set<String> linkedNames = new HashSet<>();

    protected abstract float compute();

    public Function(Model model) {
        this.model = model;
    }

    boolean computable() {
        return this.model.getTargets().noneMatch(this.linkedNames::contains);
    }

    @Override
    public String toString() {
        return "Function{" +
                "class=" + this.getClass().getCanonicalName() +
                ", linkedNames=" + linkedNames +
                '}';
    }
}
