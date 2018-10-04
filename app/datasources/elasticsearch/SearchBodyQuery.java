package datasources.elasticsearch;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SearchBodyQuery {

    private SearchBodyQueryFiltered filtered;
    private SearchRange range;

}