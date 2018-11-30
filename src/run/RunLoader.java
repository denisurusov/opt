package run;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.model.Direction;

import java.io.InputStream;
import java.util.ArrayList;
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
            root.get("runs").elements().forEachRemaining(nextRun -> {

                RunnerType type = RunnerType.valueOf(nextRun.get("type").asText());
                switch (type) {
                    case NODE_TO_NODE: {
                        returnList.add(new ModelRunNodeToNode(nextRun.get("id").asText(),
                                RunnerType.NODE_TO_NODE,
                                nextRun.get("description").asText(),
                                nextRun.get("source").get("id").asText(),
                                nextRun.get("source").get("newValue").floatValue(),
                                nextRun.get("target").get("id").asText()));
                        break;
                    }
                    case MODEL_WALK: {

                        ModelRunWalk run = new ModelRunWalk(nextRun.get("id").asText(),
                                RunnerType.MODEL_WALK,
                                nextRun.get("description").asText(),
                                nextRun.get("source").get("id").asText());

                        nextRun.get("targets").elements().forEachRemaining(target -> {
                            run.addTarget(run.new Target(target.get("id").asText(), Direction.valueOf(target.get("direction").asText()), target.get("limit").floatValue()));
                        });
                        returnList.add(run);
                    }
                }
            });

        } catch (Exception e) {
            throw new ModelLoadingException("Model loading failure - could not load model runs", e);
        }
        return returnList;
    }
}
