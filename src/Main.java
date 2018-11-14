import data.model.Node;
import run.App;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing model.....");
        App app = new App();
        
        app.run();
        app.print();      
        
        app.compute(Node.HEADCOUNT);
        app.setValue(Node.HEADCOUNT, 500);
        app.print();
        
        app.reset();
        System.out.println("Model run complete.");
    }
}
