package data.model.impl;

import data.model.Function;
import data.model.NodeRuntime;

@FunctionalInterface
interface Formula {
    public float compute(float budget, float daysAYear, float hoursADay, float rate);
}

public class CalculateHeadcountFunction extends Function {
    //this is to become a lamda expression
    private NodeRuntime budget;
    private NodeRuntime hoursADay;
    private NodeRuntime daysAYear;
    private NodeRuntime hourlyRate;
    private Formula formula;

    public CalculateHeadcountFunction(NodeRuntime budget, NodeRuntime hoursADay, NodeRuntime daysAYear, NodeRuntime hourlyRate) {
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

