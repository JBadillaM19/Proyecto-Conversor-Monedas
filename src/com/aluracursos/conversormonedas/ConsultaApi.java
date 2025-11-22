package com.aluracursos.conversormonedas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    static void main(String[] args) throws IOException, InterruptedException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Creando cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/a558f018878e62018cebc093/pair/USD/CRC/50"))//Añadir dirección de la API
                .GET()
                .build();

        try {
            // Enviando solicitud y recibiendo respuesta
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            String json = respuesta.body();
            //System.out.println(json);

            ResultadoConversion miResultadoConversion = gson.fromJson(json, ResultadoConversion.class);
            System.out.println(miResultadoConversion);

        }catch(Exception e){
            System.out.println("Error en dar respuesta");
        }


    }
}