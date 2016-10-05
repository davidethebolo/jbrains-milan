package display;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class DisplayTest
{

  private final Display display = new StdoutDisplay();

  @Test
  public void printMessageOnStdOut() throws Exception
  {
    ByteArrayOutputStream standardOut = initializeStdOut();

    display.show("A message on stdout");

    assertThat(standardOut.toString(), is("A message on stdout\n"));
  }

  private ByteArrayOutputStream initializeStdOut()
  {
    ByteArrayOutputStream standardOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(standardOut));
    return standardOut;
  }

}
