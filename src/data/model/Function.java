package data.model;

/*
    I calculate the value of a given node when the nodes that are a part of the formula change
 */

import run.Model;

import java.util.HashSet;
import java.util.Set;

public abstract class Function {
    protected Model model;
    protected final Set<String> linkedNames = new HashSet<>();

    protected abstract float compute();

    protected Function(Model model) {
        this.model = model;
    }

    public void propagate() {
        this.linkedNames.stream().forEach(s -> this.model.compute(s));
    }

    @Override
    public String toString() {
        return "Function{" +
                "model=" + model +
                ", linkedNames=" + linkedNames +
                '}';
    }
}
