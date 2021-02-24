package git.mappings.generic;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private String documentation_url;
}
