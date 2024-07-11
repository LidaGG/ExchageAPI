/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidor_monedas_conappi;


public class CurrencyConverter {
     private final ExchangeRateAPI api;

    public CurrencyConverter() {
        this.api = new ExchangeRateAPI();
    }

    public void convert(String baseCurrency, String targetCurrency, double amount) {
        try {
            double rate = api.getExchangeRate(baseCurrency, targetCurrency);
            double result = amount * rate;
            System.out.printf("%.2f %s son %.2f %s%n", amount, baseCurrency, result, targetCurrency);
        } catch (Exception e) {
            System.out.println("Error en la conversión: " + e.getMessage());
        }
    }
    
}
