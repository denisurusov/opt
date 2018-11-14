package data.model.impl;

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
        System.out.println ("Computing with " + this.model.getValue(Node.HEADCOUNT));
        System.out.println ("Computing with " + this.model.getValue(Node.DAYS_A_YEAR));
        System.out.println ("Computing with " + this.model.getValue(Node.HOURS_A_DAY));
        System.out.println ("Computing with " + this.model.getValue(Node.HOURLY_RATE));
        //
        return this.formula.compute(this.model.getValue(Node.DAYS_A_YEAR),
                this.model.getValue(Node.HOURS_A_DAY),
                this.model.getValue(Node.HOURLY_RATE),
                this.model.getValue(Node.HEADCOUNT));
    }
}
