import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;
@RunWith(Parameterized.class)
public class AVSVerificationTest {

    private String actual;
    private String expextedResult;
    private static AVSVerification avsVerification;

    public AVSVerificationTest(String actual, String expextedResult) {
        this.actual = actual;
        this.expextedResult = expextedResult;
    }

    @Parameterized.Parameters
    public static Collection responseCodes() throws IOException {
        avsVerification = new AVSVerification();
        return Arrays.asList(new Object[][]{
                {avsVerification.getSaleResponseCode("https://sandbox-secure.unitedthinkers.com/gates/xurl",0), "avsResponseCode=00"},
                {avsVerification.getSaleResponseCode("https://sandbox-secure.unitedthinkers.com/gates/xurl",1), "avsResponseCode=46"},
        });
    }

    @Test
    public void getSaleResponseCode() {
        assertEquals(expextedResult, actual);
    }
}