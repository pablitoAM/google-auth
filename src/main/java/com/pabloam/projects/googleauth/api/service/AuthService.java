package com.pabloam.projects.googleauth.api.service;

import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    CheckedFunctions.CheckedBiConsumer<String, HttpServletResponse> redirect = (redirectUri, response) -> response.sendRedirect(redirectUri);

    //SecurityService mustSecure(HttpServletRequest request, List<String> uriWhiteList);



    void apply();

}
