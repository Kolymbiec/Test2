import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ResponseCodeTest.class , AVSVerificationTest.class})
public class TestSuitClass {
    public static void main(String[] args) throws Exception {
        JUnitCore.main(
                "");
    }
}
