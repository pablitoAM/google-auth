package com.pabloam.googleauth.api;

import com.pabloam.googleauth.api.auth.AuthenticationRequest;
import com.pabloam.googleauth.api.security.Filters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.pabloam.googleauth.api.auth.Constants.*;
import static spark.Spark.*;

public class RestApi {

    private static final Logger logger = LoggerFactory.getLogger(RestApi.class);

    private static final String LOGIN_URI           = "/login";
    private static final String RESOURCE_URI        = "/callback";

    public RestApi() {
        staticFiles.location("/public");
        before("*", Filters.secure);
        get(LOGIN_URI,      this::handleLogin);
        get(RESOURCE_URI,   (req,res) -> "http://www.google.com");
        after("*", Filters.gzip);

        exception(Exception.class, (exception, request, response) -> logger.error(exception.getMessage(), exception));

    }

    private Route handleLogin(Request request, Response response){
        response.redirect(
                AuthenticationRequest.builder()
                        .responseType(RESPONSE_TYPE)
                        .clientId(CLIENT_ID)
                        .redirectUri(String.format("%s://%s%s", request.scheme(),request.host(), RESOURCE_URI))
                        .scope(SCOPE)
                        .state(STATE)
                        .prompt(PROMPT)
                        .uri());
        return null;
    }

}
