package git.validators;

import retrofit2.Response;

import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_BAD_METHOD;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_CONFLICT;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_GONE;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_NOT_ACCEPTABLE;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_PRECON_FAILED;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ResponseValidator {
    /**
     * Can use this class to check all the most common errors
     */

    private ResponseValidator() {
    }

    public static void assertOk(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_OK, response.code()), response.code(), is(HTTP_OK));
    }

    public static void assertCreated(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_CREATED, response.code()), response.code(), is(HTTP_CREATED));
    }

    public static void assertAccepted(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_ACCEPTED, response.code()), response.code(), is(HTTP_ACCEPTED));
    }

    public static void assertNotAcceptable(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_NOT_ACCEPTABLE, response.code()), response.code(), is(HTTP_NOT_ACCEPTABLE));
    }

    public static void assertNoContent(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_NO_CONTENT, response.code()), response.code(), is(HTTP_NO_CONTENT));
    }

    public static void assertBadRequest(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_BAD_REQUEST, response.code()), response.code(), is(HTTP_BAD_REQUEST));
    }

    public static void assertUnauthorized(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_UNAUTHORIZED, response.code()), response.code(), is(HTTP_UNAUTHORIZED));
    }

    public static void assertForbidden(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_FORBIDDEN, response.code()), response.code(), is(HTTP_FORBIDDEN));
    }

    public static void assertNotFound(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_NOT_FOUND, response.code()), response.code(), is(HTTP_NOT_FOUND));
    }

    public static void assertMethodNotAllowed(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_BAD_METHOD, response.code()), response.code(), is(HTTP_BAD_METHOD));
    }

    public static void assertConflict(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_CONFLICT, response.code()), response.code(), is(HTTP_CONFLICT));
    }

    public static void assertGone(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_GONE, response.code()), response.code(), is(HTTP_GONE));
    }

    public static void assertPreconditionFailed(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_PRECON_FAILED, response.code()), response.code(), is(HTTP_PRECON_FAILED));
    }

    public static void assertInternalServerError(Response response) {
        assertThat(String.format("Expected response code to be [%s] but was [%s]", HTTP_INTERNAL_ERROR, response.code()), response.code(), is(HTTP_INTERNAL_ERROR));
    }
}