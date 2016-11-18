package com.pabloam.googleauth.api;

import static spark.Spark.*;

public class RestApi {

    public RestApi() {
        staticFiles.location("/public");
        before( (req, res) -> {} );
        after( (req, res) -> res.type(req.contentType()) );
        after( (req, res) -> res.header("Content-Encoding", "gzip") );
    }




}
