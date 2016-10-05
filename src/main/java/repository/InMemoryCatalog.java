package repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCatalog implements Catalog
{
  private Map<String, String> pricesMap = new HashMap<String, String>();

  public String priceFor(String barcode)
  {
    String price = pricesMap.get(barcode);
    if (price == null)
      throw new PriceNotFoundException();
    return price;
  }

  public void addPrice(String code, String price)
  {
    pricesMap.put(code, price);
  }
}
