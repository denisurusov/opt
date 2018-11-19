import run.Model;
import run.ModelLoader;
import run.ModelLoadingException;
import run.SimpleModel;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Model initialization start...");
            Model model = new ModelLoader().load(SimpleModel.class.getClassLoader().getResourceAsStream("model.runs.json5"));
            System.out.println(model);
            System.out.println("Model initialization complete.");
        } catch (ModelLoadingException e) {
            System.out.println(e.toString());
        }

    }
}
