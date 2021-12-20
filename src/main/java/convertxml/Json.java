package convertxml;

import org.json.*;

public class Json {

	public static String xml= "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
			"    <soap:Header/>\r\n" + 
			"    <soap:Body>\r\n" + 
			"        <OTA_HotelRateAmountNotifRQ Version=\"1\" EchoToken=\"1019173874\" TimeStamp=\"2020-08-18T12:52:20.0Z\" xmlns:schemalocation=\"http://www.opentravel.org/OTA/2003/05 OTA_HotelRateAmountNotifRQ.xsd\" xmlns=\"http://www.opentravel.org/OTA/2003/05\">\r\n" + 
			"            <UniqueID ID=\"1590555868\" Type=\"16\"/>\r\n" + 
			"            <RateAmountMessages ChainCode=\"UI\" HotelCode=\"qtest1\">\r\n" + 
			"                <RateAmountMessage>\r\n" + 
			"                    <StatusApplicationControl InvTypeCode=\"SRK\" IsRoom=\"1\" RatePlanCode=\"FRP2\"/>\r\n" + 
			"                    <Rates>\r\n" + 
			"                        <Rate Start=\"2021-12-22\" End=\"2021-12-25\" CurrencyCode=\"USD\" RateTimeUnit=\"Day\" UnitMultiplier=\"1\" Mon=\"1\" Tue=\"1\" Weds=\"1\" Thur=\"1\" Fri=\"1\" Sat=\"1\" Sun=\"1\">\r\n" + 
			"                            <BaseByGuestAmts>\r\n" + 
			"                                <BaseByGuestAmt AmountAfterTax=\"200.00\" CurrencyCode=\"USD\" NumberOfGuests=\"2\"/>\r\n" + 
			"                            </BaseByGuestAmts>\r\n" + 
			"                        </Rate>\r\n" + 
			"                    </Rates>\r\n" + 
			"                </RateAmountMessage>\r\n" + 
			"            </RateAmountMessages>\r\n" + 
			"        </OTA_HotelRateAmountNotifRQ>\r\n" + 
			"    </soap:Body>\r\n" + 
			"</soap:Envelope>";  

	public static void main(String[] args) {  
		try {  
			JSONObject json = XML.toJSONObject(xml);   
			String jsonString = json.toString(4);  
			System.out.println(jsonString);  

		}catch (JSONException e) {  
			System.out.println(e.toString());  
		}  

	}  

}
