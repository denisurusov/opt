import run.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            //TODO mebbe there needs to be two configs - one for nodes, one for runs
            //pros - cleaner
            //cons - harder to cross-reference while authoring
            //perhaps there has to be a DSL syntax for this.

            Model model = new ModelLoader().load(ModelLoader.class.getClassLoader().getResourceAsStream("model.runs.json5"));
            System.out.println(model.toString());

            List<ModelRun> runs = new RunLoader().load(RunLoader.class.getClassLoader().getResourceAsStream("model.runs.json5"));

            runs.forEach(r -> {
                System.out.println(r.toString());
                r.execute(model);
                System.out.println(model);
                model.reset();
            });
        } catch (ModelLoadingException e) {
            e.printStackTrace();
        }

    }
}
