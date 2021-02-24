package git.mappings.generic;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Topics {
        @JsonProperty("names")
        public List<String> getNames() {
            return this.names; }
        public void setNames(List<String> names) {
            this.names = names; }
        List<String> names;

}
