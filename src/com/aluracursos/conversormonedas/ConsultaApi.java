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

        String direccionApi = String.format("https://v6.exchangerate-api.com/v6/a558f018878e62018cebc093/pair/%s/%s/%.2f",
                monedaOrigen, monedaCambio, monto);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Creando cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(direccionApi))
                .GET()
                .build();

            // Enviando solicitud y recibiendo respuesta
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            String json = respuesta.body();

            //Mapeo del Json
            ResultadoConversion conversion = gson.fromJson(json, ResultadoConversion.class);

            if (conversion == null) {
                throw new RuntimeException("Error al procesar datos obtenidos");
            }

            if (conversion.result() != null && conversion.result().equalsIgnoreCase("error")) {
                throw new RuntimeException("Error de la API: La solicitud fue rechazada");
            }

            if (conversion.conversion_result() == null) {
                throw new RuntimeException("Error de datos");
            }

            return conversion;
        //return gson.fromJson(json, ResultadoConversion.class);



    }
}