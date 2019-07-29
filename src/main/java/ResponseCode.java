

    import com.ebay.xcelite.Xcelite;
    import com.ebay.xcelite.reader.SheetReader;
    import com.ebay.xcelite.sheet.XceliteSheet;
    import java.io.*;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.Collection;

    public class ResponseCode {
        private static int CONNECT_TIMEOUT = 10 * 1000;
        private static int READ_TIMEOUT = 1 * 60 * 1000;
        private static String EMPTY = "";
        private static int count = 0;
        private ArrayList<TestData> list;


        public ResponseCode() {
            this.list = new ArrayList<>(testData("TestData.xlsx","Sale Request"));
        }

        public String getSaleResponseCode(String url, int index) throws IOException{

            HttpURLConnection conn = null;
            InputStream stream = null;
            URL urlLink = new URL(url);
            OutputStreamWriter writer = null;

            conn = (HttpURLConnection)urlLink.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");

            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(list.get(index).toString());
            writer.flush();
            writer.close();



            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                stream = conn.getInputStream();
            } else {
                stream = conn.getErrorStream();
            }
            if (stream == null){
                System.out.println("Response code is " + conn.getResponseCode());
                return EMPTY;
            }


            return stream2String(stream);
        }

        private static String stream2String(InputStream is) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine();
            int index = line.indexOf("responseCode");
            String responseCode = line.substring(index, index + 16);
            return responseCode;
        }

        private static Collection<TestData> testData(String patnName, String sheetName){
            Xcelite xcelite = new Xcelite(new File(patnName));
            XceliteSheet sheet = xcelite.getSheet(sheetName);
            SheetReader<TestData> reader = sheet.getBeanReader(TestData.class);
            Collection<TestData> users = reader.read();
            return users;
        }
    }

