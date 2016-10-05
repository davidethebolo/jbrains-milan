package display;

public class StdoutDisplay implements Display
{
  public void show(String message)
  {
    System.out.println(message);
  }
}
