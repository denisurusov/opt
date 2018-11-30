package data.model.function;

import data.model.Function;
import data.model.Node;
import run.Model;


public class FunctionAvailableBudget extends Function {
    private Formula formula;

    @FunctionalInterface
    interface Formula {
        float compute(float days, float hours, float rate, float headCount);
    }

    public FunctionAvailableBudget(Model model) {
        super(model);
        this.linkedNames.add(Node.DAYS_A_YEAR);
        this.linkedNames.add(Node.HOURS_A_DAY);
        this.linkedNames.add(Node.HOURLY_RATE);
        this.linkedNames.add(Node.HEADCOUNT);
        this.formula = (a, b, c, d) -> a * b * c * d;
    }

    public float compute() {
        return this.formula.compute(
                this.model.compute(Node.DAYS_A_YEAR),
                this.model.compute(Node.HOURS_A_DAY),
                this.model.compute(Node.HOURLY_RATE),
                this.model.compute(Node.HEADCOUNT));
    }
}
