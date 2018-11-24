package run;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RunLoader {


    public List<ModelRun> load(InputStream is) throws ModelLoadingException {

        List<ModelRun> returnList = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(JsonParser.Feature.ALLOW_COMMENTS);
            JsonNode root = mapper.readTree(is);
            //FIXME too many fail points
            //TODO - might want to cross-check the nodes used as sources and targets
            Iterator<JsonNode> jsonRunNodes = root.get("runs").elements();

            while (jsonRunNodes != null && jsonRunNodes.hasNext()) {
                JsonNode nextRun = jsonRunNodes.next();
                RunnerType type = RunnerType.valueOf(nextRun.get("type").asText());
                switch (type) {
                    case NODE_TO_NODE: {
                        returnList.add(new ModelRunNodeToNode(nextRun.get("id").asText(),
                                type,
                                nextRun.get("description").asText(),
                                nextRun.get("source").get("id").asText(),
                                nextRun.get("target").get("id").asText()));
                        break;
                    }
                    case MODEL_WALK: {

                    }
                }
            }
        } catch (Exception e) {
            throw new ModelLoadingException("Model loading failure - could not load model runs", e);
        }
        return returnList;
    }
}
