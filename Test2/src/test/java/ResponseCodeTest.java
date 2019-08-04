
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class ResponseCodeTest {

    private String actual;
    private String expextedResult;
    private static ResponseCode responseCode;


    public ResponseCodeTest(String actual, String expextedResult) {
        this.actual = actual;
        this.expextedResult = expextedResult;
    }

    @Parameterized.Parameters
    public static Collection responseCodes() throws IOException {
        responseCode = new ResponseCode();
        return Arrays.asList(new Object[][]{
            {responseCode.getSaleResponseCode("https://sandbox-secure.unitedthinkers.com/gates/xurl",0), "responseCode=A01"},
            {responseCode.getSaleResponseCode("https://sandbox-secure.unitedthinkers.com/gates/xurl",1), "responseCode=D03"},
            });
    }

    @Test
    public void getSaleResponseCode(){
        assertEquals(expextedResult, actual);
       }
}