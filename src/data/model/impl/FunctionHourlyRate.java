package data.model.impl;

import data.model.Function;
import data.model.Node;
import run.Model;


public class FunctionHourlyRate extends Function {
    private Formula formula;

    @FunctionalInterface
    interface Formula {
        float compute(float budget, float daysAYear, float hoursADay, float headCount);
    }

    public FunctionHourlyRate(Model model) {
        super(model);
        this.linkedNames.add(Node.AVAILABLE_BUDGET);
        this.linkedNames.add(Node.DAYS_A_YEAR);
        this.linkedNames.add(Node.HOURS_A_DAY);
        this.linkedNames.add(Node.HEADCOUNT);
        this.formula = (a, b, c, d) -> a / b / c / d;
    }

    public float compute() {
        return this.formula.compute(this.model.getComputePair(Node.AVAILABLE_BUDGET).getValue(),
                this.model.getComputePair(Node.DAYS_A_YEAR).getValue(),
                this.model.getComputePair(Node.HOURS_A_DAY).getValue(),
                this.model.getComputePair(Node.HEADCOUNT).getValue());
    }
}
