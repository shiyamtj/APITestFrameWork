package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class APIUtils {
    public static String path;
    public static String jsonPath;

    public static void SetBaseURI(){
        RestAssured.baseURI =  "http://generator.swagger.io/";
    }

    public static void SetBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    public static void ResetBaseURI (){
        RestAssured.baseURI = null;
    }

    public static void ResetBasePATH (){
        RestAssured.basePath = null;
    }

    public static void SetContentType (ContentType Type){
        given().contentType(Type);
    }

    public static Response getResponsebyPath(String path) {
        return get(path);
    }

    public static Response getResponse() {
        return get();
    }

    public static JsonPath getJsonPath(Response response){
        String json = response.asString();
        return new JsonPath(json);
    }

}
