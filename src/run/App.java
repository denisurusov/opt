package run;

import data.model.*;
import data.model.impl.FunctionHeadcount;
import data.model.impl.FunctionHoursADay;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        //
        HashMap<String, ComputePair> computeEngine = new HashMap<>();

        // write your code here
        NodeValue hoursADay = new NodeValue(new Node("Number of work hours a day", Direction.UP, 1, Unit.Hours), 8);
        NodeValue daysAYear = new NodeValue(new Node("Number of work days a year", Direction.UP, 1, Unit.DAYS), 262);
        NodeValue budget = new NodeValue(new Node("Annual onboarding budget", Direction.DOWN, 1000000, Unit.DOLLARS), 16000000);
        NodeValue hourlyRate = new NodeValue(new Node("Analyst hourly rate", Direction.DOWN, 10, Unit.DOLLARS), 40);
        NodeValue headCount = new NodeValue(new Node("Number of analysts we can afford", Direction.DOWN, 1, Unit.PEOPLE));


        computeEngine.put("headcount", new ComputePair(headCount, new FunctionHeadcount(budget, daysAYear, hoursADay, hourlyRate)));
        computeEngine.put("hoursADay", new ComputePair(hoursADay, new FunctionHoursADay(budget, daysAYear, hourlyRate, headCount)));

        System.out.println(computeEngine.get("headcount").compute());
        System.out.println(computeEngine.get("headcount").getValue());
        //
        System.out.println(computeEngine.get("hoursADay").compute());
    }
}

class ComputePair {
    private NodeValue value;
    private Function function;

    public ComputePair(NodeValue runtime, Function function) {
        this.value = runtime;
        this.function = function;
    }

    public float compute() {
        return this.value.compute(this.function);
    }

    public float increase() {
        return this.value.increase();
    }

    public float getValue() {
        return this.value.getCurrentValue();
    }
}