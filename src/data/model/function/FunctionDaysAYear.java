package data.model.function;

import data.model.Function;
import data.model.Model;
import data.model.Node;


public class FunctionDaysAYear extends Function {
    private Formula formula;

    @FunctionalInterface
    interface Formula {
        float compute(float budget, float hoursADay, float rate, float headCount);
    }

    public FunctionDaysAYear(Model model) {
        super(model);
        this.linkedNames.add(Node.AVAILABLE_BUDGET);
        this.linkedNames.add(Node.HOURS_A_DAY);
        this.linkedNames.add(Node.HOURLY_RATE);
        this.linkedNames.add(Node.HEADCOUNT);
        this.formula = (a, b, c, d) -> a / b / c / d;
    }

    public float compute() {
        return this.formula.compute(
                this.model.compute(Node.AVAILABLE_BUDGET),
                this.model.compute(Node.HOURS_A_DAY),
                this.model.compute(Node.HOURLY_RATE),
                this.model.compute(Node.HEADCOUNT));
    }
}
