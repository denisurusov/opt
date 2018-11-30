package data.model.function;

import data.model.Function;
import data.model.Node;
import run.Model;

public class FunctionHeadcount extends Function {
    private Formula formula;

    //
    @FunctionalInterface
    interface Formula {
        float compute(float budget, float daysAYear, float hoursADay, float rate);
    }

    public FunctionHeadcount(Model model) {
        super(model);
        this.linkedNames.add(Node.AVAILABLE_BUDGET);
        this.linkedNames.add(Node.DAYS_A_YEAR);
        this.linkedNames.add(Node.HOURS_A_DAY);
        this.linkedNames.add(Node.HOURLY_RATE);
        this.formula = (a, b, c, d) -> a / b / c / d;
    }

    public float compute() {
        return this.formula.compute(
                this.model.getValue(Node.AVAILABLE_BUDGET),
                this.model.compute(Node.DAYS_A_YEAR),
                this.model.compute(Node.HOURS_A_DAY),
                this.model.compute(Node.HOURLY_RATE));
    }
}

