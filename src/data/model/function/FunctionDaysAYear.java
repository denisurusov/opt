package data.model.function;

import data.model.Function;
import data.model.Node;
import run.Model;


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
        return this.formula.compute(this.model.getValue(Node.AVAILABLE_BUDGET),
                this.model.getValue(Node.HOURS_A_DAY),
                this.model.getValue(Node.HOURLY_RATE),
                this.model.getValue(Node.HEADCOUNT));
    }
}
