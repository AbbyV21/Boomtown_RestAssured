package com.boomtown.tests;

import com.boomtown.utilities.BoomtownBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoomtownAPI extends BoomtownBase {

    @Test
    public void test1(){

       // baseURI = "https://api.preprod.goboomtown.com/sdk/v1/kb/search";

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("query", "customer")
                .and().header("X-Boomtown-Integration", "TBYS9Q")
                .and().header("X-Boomtown-Key","f7LrK5AfEfVyX8vmClqtrtYGCzrcUBk8CYVU2PMzfNm5")
                .log().all().when().get(baseURI);
        assertEquals(200, response.statusCode());
        assertEquals("application/json; charset=utf-8", response.header("Content-Type"));
         response.prettyPrint();


    }

    /**2. Use a query parameter of “query” with a search term such as “customer” or “test” to search (e.g. https://api.preprod.goboomtown.com/sdk/v1/kb/search?query=customer)
     * 3. Use query parameters of “start” and “limit” to control paging where:
     a. ‘start’ is the pagination starting result number (e.g. page 0, 1, 2, etc)
     b. ‘limit’ is the max number of results returned in the response
     4. Assert that the API and pagination is working correctly (or not), and the responses are consistent (or not)

     * */
    @Test
    public void test2(){

      //  baseURI = "https://api.preprod.goboomtown.com/sdk/v1/kb/search";

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("query", "customer")
                .and().header("X-Boomtown-Integration", "TBYS9Q")
                .and().header("X-Boomtown-Key","f7LrK5AfEfVyX8vmClqtrtYGCzrcUBk8CYVU2PMzfNm5")
                .log().all().when().get(baseURI);

        given().queryParam("start", "0")
                        .and().queryParam("limit", "100");

        assertEquals(200, response.statusCode());
        assertEquals("application/json; charset=utf-8", response.header("Content-Type"));
        assertTrue(response.body().asString().contains("100"));
        response.prettyPrint();
    }


}
