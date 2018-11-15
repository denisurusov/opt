import data.model.Node;
import run.App;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

public class Main {

    public static void main(String[] args) {


        System.out.println("Initializing model.....");
        App app = new App();
        javax.json.JsonReader jsonReader = Json.createReader(App.class.getClassLoader().getResourceAsStream("mode.run.json5"));
        JsonObject personObject = jsonReader.readObject();

        JsonArray runs = personObject.getJsonArray("runs");

        app.run();
        System.out.println(app);
        
        app.compute(Node.HEADCOUNT);
        app.setValue(Node.HEADCOUNT, 500);
        System.out.println(app);
        
        app.reset();
        System.out.println("Model run complete.");
    }
}
