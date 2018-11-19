package run;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Iterator;

public class RunLoader {

    public void load(InputStream is) throws ModelLoadingException {
        SimpleModel model = new SimpleModel();

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(JsonParser.Feature.ALLOW_COMMENTS);
            JsonNode root = mapper.readTree(is);
            //
            Iterator<JsonNode> jsonRunNodes = root.get("runs").elements();

            while (jsonRunNodes != null && jsonRunNodes.hasNext()) {
                JsonNode nextRun = jsonRunNodes.next();
                //
                String runId = nextRun.get("id").asText();
                String description = nextRun.get("description").asText();
                String type = nextRun.get("description").asText();
                //
//                Direction.valueOf(nextRun.get("direction").asText()),
//                        nextRun.get("step").floatValue(),
//                        Unit.valueOf(nextRun.get("unit").asText()));
//                float baseline = nextRun.has("baseline") ? nextRun.get("baseline").floatValue() : 0;
//                //
//                Class<?> c = Class.forName(nextRun.get("functionClassName").asText());
//                model.addNode(nextRun.get("id").asText(), new ComputePair(new NodeValue(node, baseline), (Function) (c.getConstructor(Model.class).newInstance(model))));
            }
        } catch (Exception e) {
            throw new ModelLoadingException("Model loading failure", e);
        }
    }
}
