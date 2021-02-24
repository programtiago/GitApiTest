package git.mappings.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Files {
    @JsonProperty("files")
    private String files;
}
