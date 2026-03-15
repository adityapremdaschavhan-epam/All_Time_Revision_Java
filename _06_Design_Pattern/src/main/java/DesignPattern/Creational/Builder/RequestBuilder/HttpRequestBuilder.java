package Builder.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestBuilder {

    // =========================
    // HttpRequest Class
    // =========================
    static class HttpRequest {

        private String method;
        private String url;
        private Map<String, String> headers;
        private Map<String, String> queryParams;
        private String body;
        private int timeout;

        // Private constructor
        private HttpRequest() {
            headers = new HashMap<>();
            queryParams = new HashMap<>();
        }

        // =========================
        // Builder Class
        // =========================
        public static class Builder {

            private HttpRequest request;

            public Builder() {
                request = new HttpRequest();
            }

            public Builder method(String method) {
                request.method = method;
                return this;
            }

            public Builder url(String url) {
                request.url = url;
                return this;
            }

            public Builder addHeader(String key, String value) {
                request.headers.put(key, value);
                return this;
            }

            public Builder addQueryParam(String key, String value) {
                request.queryParams.put(key, value);
                return this;
            }

            public Builder body(String body) {
                request.body = body;
                return this;
            }

            public Builder timeout(int timeout) {
                request.timeout = timeout;
                return this;
            }

            public HttpRequest build() {

                if (request.method == null || request.url == null) {
                    throw new IllegalStateException("Method and URL are mandatory");
                }

                return request;
            }
        }

        // =========================
        // Helper Method
        // =========================
        private String buildUrlWithQueryParams() {

            if (queryParams.isEmpty()) {
                return url;
            }

            StringBuilder fullUrl = new StringBuilder(url);
            fullUrl.append("?");

            queryParams.forEach((k, v) ->
                    fullUrl.append(k)
                            .append("=")
                            .append(v)
                            .append("&")
            );

            fullUrl.deleteCharAt(fullUrl.length() - 1);

            return fullUrl.toString();
        }

        // =========================
        // toString() -> HTTP Format
        // =========================
        @Override
        public String toString() {

            StringBuilder requestString = new StringBuilder();

            requestString.append(method)
                    .append(" ")
                    .append(buildUrlWithQueryParams())
                    .append("\n");

            headers.forEach((k, v) ->
                    requestString.append(k)
                            .append(": ")
                            .append(v)
                            .append("\n")
            );

            requestString.append("Timeout: ")
                    .append(timeout)
                    .append(" ms\n");

            if (body != null) {
                requestString.append("\n")
                        .append(body);
            }

            return requestString.toString();
        }
    }

    // =========================
    // Main Method
    // =========================
    public static void main(String[] args) {

        HttpRequest request = new HttpRequest.Builder()
                .method("POST")
                .url("/users")
                .addHeader("Authorization", "Bearer token123")
                .addHeader("Content-Type", "application/json")
                .addQueryParam("page", "1")
                .addQueryParam("size", "10")
                .timeout(5000)
                .body("{\"name\":\"Aditya\"}")
                .build();

        System.out.println(request);
    }
}