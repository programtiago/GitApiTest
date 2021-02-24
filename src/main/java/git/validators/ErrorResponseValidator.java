package git.validators;

import git.mappings.generic.ErrorResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponseValidator {

    public static void assertErrorResponse(ErrorResponse errorResponse, String message, String documentation_url) {
        //TODO: update this with the parameters you want to validate on error responses
        assertThat(String.format("Message should be %s", message), errorResponse.getMessage(), is(message));
        assertThat(String.format("Documentation url should be %s", documentation_url), errorResponse.getDocumentation_url(), is(documentation_url));
    }
}
