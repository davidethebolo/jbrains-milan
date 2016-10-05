import display.Display;
import repository.PriceNotFoundException;
import repository.Catalog;

public class Seller implements BarcodeScannedCommand
{
  private Catalog catalog;
  private Display display;

  public Seller(Catalog catalog, Display display)
  {
    this.catalog = catalog;
    this.display = display;
  }

  public void onBarcode(String barCode)
  {
    String message = null;
    try
    {
      message = catalog.priceFor(barCode);
    }
    catch (PriceNotFoundException e)
    {
      message = "Price not found";
    }
    finally
    {
      display.show(message);
    }
  }
}
