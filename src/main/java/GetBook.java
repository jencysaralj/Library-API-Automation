import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBook extends AddBook {



    public Response getBookByID(String id) {
        Response response = given().get("http://216.10.245.166/Library/GetBook.php?ID="+id).then()
                .log().all().extract().response();
        return response;
    }


    public Response getBookByAuthor(String authorName){
        Response response = given().get("http://216.10.245.166/Library/GetBook.php?AuthorName="+authorName).then()
                .log().all().extract().response();
        return response;
    }
}
