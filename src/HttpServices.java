import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpServices {
    private String url = "";
    private final String apiKey = "4bbd1ff7f58ca4dd8d71df9d";

    public ExchangeRate fetchPairExchangeRate(String currencyA, String currencyB) {
        url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + currencyA + "/" + currencyB;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to fetch exchange rate.");
            throw new RuntimeException(e.getMessage());

        }
    }

    public ExchangeRateList fetchFullExchangesRates(String currencyA) {
        url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currencyA;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRateList.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to fetch exchange rates.");
            throw new RuntimeException(e.getMessage());

        }
    }


}
