import com.github.javafaker.Faker;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AddBook{
    Faker faker = new Faker();
    String aisle = faker.number().digits(6);
    String isbn = faker.number().digits(6);
    String bookDetails = "{\n" +
            "\"name\":\"Oop Concepts\",\n" +
            "\"isbn\":" + isbn + ",\n" +
            "\"aisle\":" + aisle + ",\n" +
            "\"author\":\"John\"\n" +
            "}";

    public Response addBook(){
        Response response = given().header("Content-type", "application/json").body(bookDetails).post("http://216.10.245.166/Library/Addbook.php").then()
                .log().all().extract().response();
        return response;
    }

}
