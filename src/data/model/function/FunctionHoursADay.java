package data.model.function;

import data.model.Function;
import data.model.Node;
import run.Model;


public class FunctionHoursADay extends Function {
    private Formula formula;

    @FunctionalInterface
    interface Formula {
        float compute(float budget, float daysAYear, float rate, float headCount);
    }

    public FunctionHoursADay(Model model) {
        super(model);
        this.linkedNames.add(Node.AVAILABLE_BUDGET);
        this.linkedNames.add(Node.DAYS_A_YEAR);
        this.linkedNames.add(Node.HOURS_A_DAY);
        this.linkedNames.add(Node.HEADCOUNT);
        this.formula = (a, b, c, d) -> a / b / c / d;
    }

    public float compute() {
        return this.formula.compute(this.model.getValue(Node.AVAILABLE_BUDGET),
                this.model.getValue(Node.DAYS_A_YEAR),
                this.model.getValue(Node.HOURLY_RATE),
                this.model.getValue(Node.HEADCOUNT));
    }
}
