package run;

import com.sun.org.apache.xpath.internal.functions.FunctionOneArg;
import data.model.*;
import data.model.impl.CalculateHeadcountFunction;

public class App {

    interface SimpleComputeFunction extends Function {
        public float eee (NodeRuntime budget,  NodeRuntime daysAYear, NodeRuntime hoursADay,  NodeRuntime rate);
    }

    public static void main(String[] args) {
        SimpleComputeFunction scf = (a,b,c, d) -> a.getCurrentValue()/b.getCurrentValue()/c.getCurrentValue()/d.getCurrentValue();
        // write your code here
        NodeRuntime hoursADay = new NodeRuntime(new Node("Number of work hours a day", Direction.UP, 1, Unit.Hours, scf), 8);
        NodeRuntime daysAYear = new NodeRuntime(new Node("Number of work days a year", Direction.UP, 1, Unit.DAYS), 262);
        NodeRuntime budget = new NodeRuntime(new Node("Annual onboarding budget", Direction.DOWN, 1000000, Unit.DOLLARS), 16000000);
        NodeRuntime hourlyRate = new NodeRuntime(new Node("Analyst hourly rate", Direction.DOWN, 10, Unit.DOLLARS), 40);
        NodeRuntime headCount = new NodeRuntime(new Node("Number of analysts we can afford", Direction.DOWN, 1, Unit.PEOPLE));
        //
        CalculateHeadcountFunction headcountFunction = new CalculateHeadcountFunction(hoursADay, daysAYear, budget, hourlyRate);



        //NodeRuntime headCountNode = new NodeRuntime("Number of analysts affordable under the budget", Direction.DOWN, headcountFunction);

        System.out.println(headCountNode.compute());
        hoursADay.increase();
        System.out.println(headCountNode.compute());
        hoursADay.increase();
        System.out.println(headCountNode.compute());
    }
}
