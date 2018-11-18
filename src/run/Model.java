package run;

import data.model.ComputePair;

import java.util.HashMap;

public abstract class Model {
    protected HashMap<String, ComputePair> computeEngine = new HashMap<>();

    protected void addNode(String key, ComputePair pair) {
        computeEngine.put(key, pair);
    }

    public abstract void reset();

    public abstract float getValue(String nodeName);

    public abstract void setValue(String nodeName, float value);

    public abstract void increase(String nodeName);

    public abstract void decrease(String nodeName);

    public abstract float compute(String nodeName);

}
