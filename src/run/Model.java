package run;

public interface Model {
    public void reset();
    public float getValue (String nodeName);
    public void setValue (String nodeName, float value);
    public void increase (String nodeName);
    public void decrease (String nodeName);
    public float compute (String nodeName);
}
