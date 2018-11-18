import data.model.Node;
import run.Model;
import run.ModelLoader;
import run.SimpleModel;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Model initialization start...");
            Model model = new ModelLoader().load(SimpleModel.class.getClassLoader().getResourceAsStream("model.runs.json5"));
            System.out.println(model);
            System.out.println("Model initialization complete.");
            model.compute(Node.HEADCOUNT);
            model.setValue(Node.HEADCOUNT, 500);


            model.reset();
            System.out.println("Model run complete.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
