import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import display.Display;
import repository.PriceNotFoundException;
import repository.Catalog;

public class SellerTest
{

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  private Catalog catalog;

  @Mock
  private Display display;

  private Seller seller;

  @Before
  public void setup() throws Exception
  {
    seller = new Seller(catalog, display);
  }

  @Test
  public void printThePrice() throws Exception
  {
    context.checking(new Expectations()
    {
      {
        allowing(catalog).priceFor("aValidCode");
        will(returnValue("EUR 25.00"));
        oneOf(display).show("EUR 25.00");
      }
    });
    seller.onBarcode("aValidCode");
  }

  @Test
  public void priceNotFound() throws Exception
  {
    context.checking(new Expectations()
    {
      {
        allowing(catalog).priceFor("anInvalidCode");
        will(throwException(new PriceNotFoundException()));
        oneOf(display).show("Price not found");
      }
    });
    seller.onBarcode("anInvalidCode");
  }

}
