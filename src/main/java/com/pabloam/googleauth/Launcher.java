package com.pabloam.googleauth;

import com.pabloam.googleauth.api.RestApi;

import static spark.Spark.stop;

public class Launcher {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Stopping al HTTP routes");
            stop();
        }, "Google Auth shutdown hook"));

        RestApi restApi = new RestApi();

    }


}
