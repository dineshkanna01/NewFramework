package restAPI;

import okhttp3.*;
import org.testng.annotations.Test;

import javax.net.ssl.*;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class OkHttpClientTest {

    @Test
    public void test() throws IOException {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient client = builder.build();
            MediaType mediaType = MediaType.parse("text/xml; charset=utf-8");
            File input = new File("src/test/resources/requestXml.xml");

            RequestBody body = RequestBody.create(input, mediaType);
          //  RequestBody body = RequestBody.create(mediaType, "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n    <soap:Header/>\n    <soap:Body>\n        <OTA_HotelRateAmountNotifRQ Version=\"1\" EchoToken=\"1019173874\" TimeStamp=\"2020-08-18T12:52:20.0Z\" xmlns:schemalocation=\"http://www.opentravel.org/OTA/2003/05 OTA_HotelRateAmountNotifRQ.xsd\" xmlns=\"http://www.opentravel.org/OTA/2003/05\">\n            <UniqueID ID=\"1590555868\" Type=\"16\"/>\n            <RateAmountMessages ChainCode=\"UI\" HotelCode=\"qtest1\">\n                <RateAmountMessage>\n                    <StatusApplicationControl InvTypeCode=\"SRK\" IsRoom=\"1\" RatePlanCode=\"FRP2\"/>\n                    <Rates>\n                        <Rate Start=\"2021-12-25\" End=\"2021-12-26\" CurrencyCode=\"USD\" RateTimeUnit=\"Day\" UnitMultiplier=\"1\" Mon=\"1\" Tue=\"1\" Weds=\"1\" Thur=\"1\" Fri=\"1\" Sat=\"1\" Sun=\"1\">\n                            <BaseByGuestAmts>\n                                <BaseByGuestAmt AmountAfterTax=\"200.00\" CurrencyCode=\"USD\" NumberOfGuests=\"2\"/>\n                            </BaseByGuestAmts>\n                        </Rate>\n                    </Rates>\n                </RateAmountMessage>\n            </RateAmountMessages>\n        </OTA_HotelRateAmountNotifRQ>\n    </soap:Body>\n</soap:Envelope>");
            Request request = new Request.Builder()
                    .url("https://qa-igt-ttconnect.ttaws.com/services/soap/ota/2008a/HotelService/clid/availpro")
                    .method("POST", body)
                    .addHeader("Content-Type", "text/xml; charset=utf-8")
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();


    }
}
