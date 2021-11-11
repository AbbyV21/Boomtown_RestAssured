package com.boomtown.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;
public abstract class BoomtownBase {

    @BeforeAll
    public static void setup(){
/**in order to avoid DRY, I store the API in this BoomtownBase class to reuse in future tasks
 * */
        baseURI = "https://api.preprod.goboomtown.com/sdk/v1/kb/search";

    }
}
