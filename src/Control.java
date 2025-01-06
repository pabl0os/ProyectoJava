import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Control {
    private final Map<String, Double> values;

    public Control() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b75e3bb55fab7369d504d647/latest/USD");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            values = (new Gson().fromJson(response.body(), valoresMonedas.class))
                    .conversion_rates();
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error");
        }
    }

    public void converter(String unidadesSinConvertir, String unidadesAConvertir, double cantidad) {
        double convertir;
        if (unidadesSinConvertir.equals("USD")) {
            convertir = cantidad * values.get(unidadesAConvertir);
        } else convertir = cantidad / values.get(unidadesSinConvertir);
        System.out.println("El valor " +cantidad+" "+ unidadesSinConvertir + " corresponde al valor final de =>> " + convertir + " " + unidadesAConvertir);
    }
}
