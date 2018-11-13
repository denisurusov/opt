package data.model.impl;

import data.model.Function;
import data.model.NodeValue;

public class FunctionHeadcount extends Function {
    private NodeValue budget;
    private NodeValue hoursADay;
    private NodeValue daysAYear;
    private NodeValue hourlyRate;

    //
    @FunctionalInterface
    interface Formula {
        public float compute(float budget, float daysAYear, float hoursADay, float rate);
    }

    private Formula formula;

    public FunctionHeadcount(NodeValue budget, NodeValue daysAYear, NodeValue hoursADay, NodeValue hourlyRate) {
        this.hourlyRate = hourlyRate;
        this.hoursADay = hoursADay;
        this.daysAYear = daysAYear;
        this.budget = budget;

        this.formula = (a, b, c, d) -> a / b / c / d;
    }

    public float compute() {
        return this.formula.compute(this.budget.getCurrentValue(), this.daysAYear.getCurrentValue(), this.hoursADay.getCurrentValue(), this.hourlyRate.getCurrentValue());
    }
}

