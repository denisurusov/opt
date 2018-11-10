package run;

import data.model.Direction;
import data.model.Resource;
import data.model.impl.HeadCount;
import data.model.Parameter;
import data.model.impl.CalculateHeadcountFunction;

public class App {


    public static void main(String[] args) {
        // write your code here
        Parameter hoursADay = new Parameter("Number of work hours a day", Direction.UP, 8, 1);
        Parameter daysAYear = new Parameter("Number of work days a year", Direction.UP, 262, 1);
        Parameter budget = new Parameter("Annual onboarding budget", Direction.DOWN, 16000000, 100000);
        Parameter hourlyRate = new Parameter("Analyst hourly rate", Direction.DOWN, 41, 5);
        //
        CalculateHeadcountFunction headcountFunction = new CalculateHeadcountFunction(hoursADay,daysAYear,budget,hourlyRate);
        Resource headCountNode = new HeadCount("Number of analysts affordable under the budget", Direction.DOWN, headcountFunction);

        System.out.println(headCountNode.compute());
        hoursADay.increase();
        System.out.println(headCountNode.compute());
        hoursADay.increase();
        System.out.println(headCountNode.compute());
    }
}
