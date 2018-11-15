package run;

public interface Model {
    void reset();

    float getValue(String nodeName);

    void setValue(String nodeName, float value);

    void increase(String nodeName);

    void decrease(String nodeName);

    float compute(String nodeName);
}
