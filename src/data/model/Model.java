package data.model;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public abstract class Model {
    protected HashMap<String, ComputePair> computeEngine = new HashMap<>();
    protected SortedSet<String> targets = new TreeSet<>();

    //FIXME - Model is in a wrong package.
    public void addNode(String key, ComputePair pair) {
        computeEngine.put(key, pair);
    }

    Stream<String> getTargets() {
        return this.targets.stream();
    }

    public abstract void reset();

    public abstract float getValue(String nodeName);

    public abstract void setValue(String nodeName, float value);

    public abstract float compute(String nodeName);

    public abstract void setTarget(String nodeName);

    public abstract void clearTarget(String nodeName);


}
