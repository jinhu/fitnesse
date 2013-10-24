package fitnesse.slim;

import fitnesse.components.CommandRunner;
import org.junit.Test;

public class RubySlimTest extends SlimServiceTest {
  private CommandRunner runner;

  @Override
  protected void createSlimService()  {
    runner = new CommandRunner("ruby /Users/unclebob/projects/RubySlim/lib/run_ruby_slim.rb 8099", "");
      try {
          runner.asynchronousStart();
      } catch (Exception e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
  }

  protected void teardown() throws Exception {
    super.teardown();
    runner.join();
  }

  @Override
  protected String getImport() {
    return "TestModule";
  }

  @Test
  public void junk() throws Exception {

  }
}
