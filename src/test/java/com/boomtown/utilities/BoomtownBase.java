package com.boomtown.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;
public abstract class BoomtownBase {

    @BeforeAll
    public static void setup(){


        RestAssured.authentication = RestAssured
                .preemptive().basic("X-Boomtown-Integration", "TBYS9Q" );

        baseURI = "https://api.preprod.goboomtown.com/sdk/v1/kb/search";

    }
}
