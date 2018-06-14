//package helpers;
//
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.ResponseSpecification;
//import org.apache.http.HttpStatus;
//
//import java.util.ArrayList;
//
//import static org.testng.Assert.assertEquals;
//
//public class TestHelper {
//    public void CheckStatus200(Response res) {
//        assertEquals(res.getStatusCode(), HttpStatus.SC_OK);
//    }
//
//    //Get Clients
//    public ArrayList GetClients(JsonPath jp) {
//        ArrayList clientList = jp.get();
//        return clientList;
//    }
//
//    public ResponseSpecification CheckStatusCodeAndContentType(ContentType type) {
//        ResponseSpecification checkStatusCodeAndContentType =
//                new ResponseSpecBuilder().
//                        expectStatusCode(200).
//                        expectContentType(type).
//                        build();
//        return checkStatusCodeAndContentType;
//    }
//
//}
