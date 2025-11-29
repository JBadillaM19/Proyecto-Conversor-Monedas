package com.aluracursos.conversormonedas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public ResultadoConversion buscarConversion(String monedaOrigen, String monedaCambio, Double monto)
    throws IOException, InterruptedException {

        String direccionApi = String.format("https://v6.exchangerate-api.com/v6/a558f018870e62018cebc093/pair/%s/%s/%.2f",
                monedaOrigen, monedaCambio, monto);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Creando cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(direccionApi))//Añadir dirección de la API
                .GET()
                .build();

            // Enviando solicitud y recibiendo respuesta
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            String json = respuesta.body();

        return gson.fromJson(json, ResultadoConversion.class);

    }
}