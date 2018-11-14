package run;

import data.model.*;
import data.model.impl.*;

import java.util.HashMap;

//TODO - implement setters
//TODO - unit test
public class App implements Model {

    private HashMap<String, ComputePair> computeEngine = new HashMap<>();

    public void run() {
        computeEngine.put(Node.AVAILABLE_BUDGET, new ComputePair(new NodeValue(new Node("Annual onboarding budget", Direction.DOWN, 1000000, Unit.DOLLARS), 16000000),
                new FunctionAvailableBudget(this)));
        computeEngine.put(Node.DAYS_A_YEAR, new ComputePair(new NodeValue(new Node("Number of work days a year", Direction.UP, 1, Unit.DAYS), 262),
                new FunctionDaysAYear(this)));
        computeEngine.put(Node.HOURS_A_DAY, new ComputePair(new NodeValue(new Node("Number of work hours a day", Direction.UP, 1, Unit.Hours), 8),
                new FunctionHoursADay(this)));
        computeEngine.put(Node.HOURLY_RATE, new ComputePair(new NodeValue(new Node("Analyst hourly rate", Direction.DOWN, 10, Unit.DOLLARS), 40),
                new FunctionHourlyRate(this)));
        computeEngine.put(Node.HEADCOUNT, new ComputePair(new NodeValue(new Node("Number of analysts we can afford", Direction.DOWN, 1, Unit.PEOPLE)),
                new FunctionHeadcount(this)));
    }

   @Override 
   public float compute (String nodeName)
   {
        return this.computeEngine.get(nodeName).compute();        
   }
   
    @Override
    public void reset()
    {
        System.out.println ("Resetting the model...");
        this.computeEngine.values().stream().forEach(v->v.reset());
        System.out.println ("Resetting complete.");
    }
    
    @Override
    public float getValue (String nodeName)
    {
        return this.computeEngine.get(nodeName).getValue();
    }
    
    @Override
    public void setValue (String nodeName, float value)
    {
         this.computeEngine.get(nodeName).set(value);
    }
    
    @Override
    public void increase (String nodeName)
    {
        this.computeEngine.get(nodeName).increase();
    }
    
    @Override
    public void decrease (String nodeName)
    {
        this.computeEngine.get(nodeName).decrease();
    }
    
    //TODO proper toString
    public void print()
    {
        computeEngine.keySet().stream().forEach(s -> System.out.println(computeEngine.get(s).toString()));
    }
}

