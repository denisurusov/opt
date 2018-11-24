import run.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Model initialization start...");
            Model model = new ModelLoader().load(ModelLoader.class.getClassLoader().getResourceAsStream("model.runs.json5"));
            List<ModelRun> runs = new RunLoader().load(RunLoader.class.getClassLoader().getResourceAsStream("model.runs.json5"));
            //TODO for each run - pass the  model and have it execute
            //TODO reset model between the runs

            System.out.println(model);
            System.out.println("Model initialization complete.");
        } catch (ModelLoadingException e) {
            e.printStackTrace();
        }

    }
}
