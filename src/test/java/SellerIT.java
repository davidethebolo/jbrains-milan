import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import display.StdoutDisplay;
import repository.InMemoryCatalog;

public class SellerIT
{

  @Test
  public void printThePrice() throws Exception
  {
    ByteArrayOutputStream standardOut = initializeStdOut();

    InMemoryCatalog catalog = new InMemoryCatalog();
    String code = "123";
    catalog.addPrice(code, "EUR 12.34");

    Seller seller = new Seller(catalog, new StdoutDisplay());
    seller.onBarcode("123");

    assertThat(standardOut.toString(), is("EUR 12.34\n"));

  }

  private ByteArrayOutputStream initializeStdOut()
  {
    ByteArrayOutputStream standardOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(standardOut));
    return standardOut;
  }

}
