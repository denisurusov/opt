package run;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.model.*;

import java.io.InputStream;
import java.util.Iterator;

public class ModelLoader {

    public Model load(InputStream is) throws ModelLoadingException {
        SimpleModel model = new SimpleModel();

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(JsonParser.Feature.ALLOW_COMMENTS);
            //
            JsonNode root = mapper.readTree(is);
            Iterator<JsonNode> jsonNodes = root.get("nodes").elements();

            while (jsonNodes != null && jsonNodes.hasNext()) {
                JsonNode nextNode = jsonNodes.next();
                //
                Node node = new Node(
                        nextNode.get("description").asText(),
                        Direction.valueOf(nextNode.get("direction").asText()),
                        nextNode.get("step").floatValue(),
                        Unit.valueOf(nextNode.get("unit").asText()));
                float baseline = nextNode.has("baseline") ? nextNode.get("baseline").floatValue() : 0;
                //
                Class<?> c = Class.forName(nextNode.get("functionClassName").asText());
                model.addNode(nextNode.get("id").asText(), new ComputePair(new NodeValue(node, baseline), (Function) (c.getConstructor(Model.class).newInstance(model))));
            }
        } catch (Exception e) {
            throw new ModelLoadingException("Model loading failure - could not load model nodes", e);
        }
        return model;
    }
}