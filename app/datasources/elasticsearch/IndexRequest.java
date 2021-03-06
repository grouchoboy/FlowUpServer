package datasources.elasticsearch;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class IndexRequest {

    private final IndexAction action;
    private JsonNode source;

    public IndexRequest(String index, String type) {
        this.action = new IndexAction(index, type);
    }

    public IndexRequest(IndexAction action) {
        this.action = action;
    }

    static IndexRequestSerializable toIndexRequestSerializable(IndexRequest indexRequest) {
        IndexRequestSerializable indexRequestSerializable = new IndexRequestSerializable();
        indexRequestSerializable.setAction(indexRequest.getAction());
        indexRequestSerializable.setSource(indexRequest.getSource());
        return indexRequestSerializable;
    }
}

