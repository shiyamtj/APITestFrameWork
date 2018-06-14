package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class BooksISBNSteps {
    private Response response;
    private RequestSpecification request;
    private ValidatableResponse json;

    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";


    @Given("^a book exists with an isbn of (.*)$")
    public void a_book_exists_with_an_isbn_of(String isbn) throws Throwable {
        request = given().param("q", "isbn:" + isbn);
    }

    @When("^a user retrieves the book by isbn$")
    public void a_user_retrieves_the_book_by_isbn() throws Throwable {
        response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
        System.out.println("Response: " + response.prettyPrint());
    }

    @Then("^the status code is (\\d+)$")
    public void the_status_code_is(int statusCode) throws Throwable {
        json = response.then().statusCode(statusCode);
    }

    @Then("^response includes the following$")
    public void response_includes_the_following(Map<String,String> responseFields) throws Throwable {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @Then("^response includes the following in any order$")
    public void response_includes_the_following_in_any_order(Map<String,String> responseFields) throws Throwable {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), containsInAnyOrder(field.getValue()));
            }
        }
    }
}
