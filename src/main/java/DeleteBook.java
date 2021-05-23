import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBook {
    public Response deleteBookByID(String ID) {
        String deleteId = "{\n" +
                "    \"ID\":" + ID + "\n" +
                "}";
        Response response =  given()
                .header("Content-type", "application/json").body(deleteId).and().delete("http://216.10.245.166/Library/DeleteBook.php")
                .then().log().all().extract().response();
        return response;
    }
}
