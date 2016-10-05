package repository;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CatalogTest
{

  private Catalog catalog;

  @Before
  public void setUp() throws Exception
  {
    catalog = new InMemoryCatalog();
  }

  // ASK better duplication or not
  @Test
  public void priceExist() throws Exception
  {
    insertIntoRepository("12345", "EUR 25.00");
    String price = catalog.priceFor("12345");

    assertThat(price, is("EUR 25.00"));
  }

  @Test(expected = PriceNotFoundException.class)
  public void priceDontExist() throws Exception
  {
    insertIntoRepository("12345", "EUR 25.00");
    catalog.priceFor("1234");
  }

  private void insertIntoRepository(String code, String price)
  {
    ((InMemoryCatalog) this.catalog).addPrice(code, price);
  }

}
