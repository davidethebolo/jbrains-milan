import java.util.Scanner;

import display.StdoutDisplay;
import repository.InMemoryCatalog;

public class Application
{

  private final BarcodeScannedCommand barcodeScannedCommand;

  public Application(BarcodeScannedCommand barcodeScannedCommand)
  {

    this.barcodeScannedCommand = barcodeScannedCommand;
  }

  public static void main(String[] args)
  {
    new Application(new Seller(new InMemoryCatalog()
    {
      {
        addPrice("40329574", "EUR 123.50");
      }
    }, new StdoutDisplay())).consumeInput(new Scanner(System.in));
  }

  private void consumeInput(Scanner scanner)
  {
    while (true)
    {
      barcodeScannedCommand.onBarcode(scanner.nextLine());
    }
  }
}
