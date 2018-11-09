package run;

import data.model.Direction;
import data.model.Parameter;
import data.model.Resource;

public class App {

    @FunctionalInterface
    interface NumberOfAnalysts{
        float compute (Parameter hoursADay, Parameter daysAYear, Parameter budget, Parameter hourlyRate);
    }

    public static void main(String[] args) {
        // write your code here
        Parameter hoursADay = new Parameter("Number of work hours a day", Direction.UP, 8, 1 );
        Parameter daysAYear = new Parameter("Number of work days a year", Direction.UP, 262, 1);
        Parameter budget = new Parameter("Annual onboarding budget", Direction.DOWN, 16000000, 100000);
        Parameter hourlyRate = new Parameter("Analyst hourly rate", Direction.DOWN, 41, 5 );
        //
        NumberOfAnalysts num = (h,d, b, r)->b.getBaseline()/h.getBaseline()/d.getBaseline()/r.getBaseline();

        Resource numberOfAnalysts = new Resource("Number of analysts affordable under the budget", Direction.DOWN, num.compute(hoursADay,daysAYear,budget,hourlyRate));
        System.out.println(numberOfAnalysts);
        hoursADay.increase();
        num.compute(hoursADay,daysAYear,budget,hourlyRate);
        System.out.println(numberOfAnalysts);
    }
}
