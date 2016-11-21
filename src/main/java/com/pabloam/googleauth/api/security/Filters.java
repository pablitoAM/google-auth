package com.pabloam.googleauth.api.security;

import spark.Request;
import spark.Response;

import java.util.Arrays;

public class Filters {

    private static final String   DEFAULT_URL       = "index.html";
    private static final String[] URI_WHITE_LIST    = { "/login" };

    public static spark.Filter secure = (Request req, Response res) -> {
        boolean passes = Arrays.stream(URI_WHITE_LIST).filter(uri -> uri.startsWith(req.uri())).findFirst().isPresent();
        if (!passes) {
            res.redirect(DEFAULT_URL, 401);
        }
    };

    public static spark.Filter gzip = (Request request, Response response) -> response.header("Content-Encoding", "gzip");
}
