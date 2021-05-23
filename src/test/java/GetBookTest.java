import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookTest extends AddBook{

    @Test
    public void AddBookAndGetBookByID() {
        Response response = addBook();
        Assert.assertEquals("successfully added", response.jsonPath().getString("Msg"));
        String id = response.jsonPath().getString("ID");
        GetBook findBook = new GetBook();
        findBook.getBookByID(id);
    }

    @Test
    public void GetBookByAuthorName(){
        GetBook book = new GetBook();
        Response response = book.getBookByAuthor("Jency");
        Assert.assertEquals(response.jsonPath().getString("book_name[0]"),"OOP Concepts");

    }

    @Test
    public void DeleteBookByID(){
        Response add = addBook();
        String bookId = add.jsonPath().getString("ID");
        DeleteBook delete = new DeleteBook();
        Response deleteBook = delete.deleteBookByID(bookId);
        Assert.assertEquals(deleteBook.jsonPath().getString("msg"),"book is successfully deleted");
    }


}
