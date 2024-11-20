import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {

    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/YOUR_API/pair";

    /**
     * Obtiene la tasa de cambio entre dos monedas específicas.
     *
     * @param fromCurrency La moneda base (por ejemplo, "USD").
     * @param toCurrency   La moneda de destino (por ejemplo, "ARS").
     * @return La tasa de cambio entre las dos monedas.
     * @throws Exception Si hay un error al conectar con la API.
     */
    public static double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        String url = String.format("%s/%s/%s", API_BASE_URL, fromCurrency, toCurrency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject responseBody = JsonParser.parseString(response.body()).getAsJsonObject();

        if (!responseBody.has("conversion_rate")) {
            throw new Exception("Error al obtener la tasa de cambio para " + fromCurrency + " a " + toCurrency);
        }
        return responseBody.get("conversion_rate").getAsDouble();
    }
}
