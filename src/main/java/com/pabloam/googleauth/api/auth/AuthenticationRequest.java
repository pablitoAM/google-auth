package com.pabloam.googleauth.api.auth;

import javax.ws.rs.core.UriBuilder;
import java.util.List;

import static java.util.Optional.ofNullable;

public class AuthenticationRequest {

    private final String BASE_URI = "https://accounts.google.com/o/oauth2/v2/auth";

    private String        responseType;
    private String        clientId;
    private String        redirectUri;
    private String[]      scope;
    private String        state;
    private String        prompt;

    private AuthenticationRequest(){
    }

    public static AuthenticationRequest builder(){
        return new AuthenticationRequest();
    }

    public AuthenticationRequest responseType(final String responseType){
        this.responseType = responseType;
        return this;
    }

    public AuthenticationRequest clientId(final String clientId){
        this.clientId = clientId;
        return this;
    }

    public AuthenticationRequest redirectUri(final String redirectUri){
        this.redirectUri = redirectUri;
        return this;
    }

    public AuthenticationRequest scope(final String[] scope){
        this.scope = scope;
        return this;
    }

    public AuthenticationRequest state(final String state){
        this.state = state;
        return this;
    }

    public AuthenticationRequest prompt(final String prompt){
        this.prompt = prompt;
        return this;
    }

    public String uri(){
        return UriBuilder.fromPath(BASE_URI)
                    .queryParam("response_type" ,   ofNullable(responseType).orElse(""))
                    .queryParam("client_id"     ,   ofNullable(clientId).orElse(""))
                    .queryParam("redirect_uri"  ,   ofNullable(redirectUri).orElse(""))
                    .queryParam("scope"         ,   ofNullable(String.join(" ", scope)).orElse(""))
                    .queryParam("state"         ,   ofNullable(state).orElse(""))
                    .queryParam("prompt"        ,   ofNullable(prompt).orElse(""))
                    .build().toString();
    }
}
