/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidor_monedas_conappi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class ExchangeRateAPI {
    private static final String API_KEY = "7b94fc81a9c5acc0a3b8c505";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String urlStr = BASE_URL + API_KEY + "/latest/" + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        StringBuilder response;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String inputLine;
            response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        JSONObject jsonObj = new JSONObject(response.toString());
        JSONObject conversionRates = jsonObj.getJSONObject("conversion_rates");
        return conversionRates.getDouble(targetCurrency);
    }
}
