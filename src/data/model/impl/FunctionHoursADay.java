package data.model.impl;

import data.model.Function;
import data.model.NodeValue;


public class FunctionHoursADay extends Function {

    private NodeValue budget;
    private NodeValue daysAYear;
    private NodeValue hourlyRate;
    private NodeValue headCount;

    @FunctionalInterface
    interface Formula {
        public float compute(float budget, float daysAYear, float rate, float headCount);
    }

    private Formula formula;

    public FunctionHoursADay(NodeValue budget, NodeValue daysAYear, NodeValue hourlyRate, NodeValue headCount) {
        this.hourlyRate = hourlyRate;
        this.headCount = headCount;
        this.daysAYear = daysAYear;
        this.budget = budget;

        this.formula = (a, b, c, d) -> a / b / c / d;
    }

    public float compute() {
        return this.formula.compute(this.budget.getCurrentValue(), this.daysAYear.getCurrentValue(), this.hourlyRate.getCurrentValue(), this.headCount.getCurrentValue());
    }
}
