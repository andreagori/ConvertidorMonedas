package com.aluracursos.conversormonedas.modelos;
import com.aluracursos.conversormonedas.principal.Principal;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
Aqui ira lo relacionado a HTTPS y el servidor del API.
 */
public class ConversorAPI extends Principal {
    // https://v6.exchangerate-api.com/v6/f65e035411c610a68057465c/latest/USD
    // pair conversion: GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
    // Setting URL
    public double convertir(int opcion, double valor) {
        String url = obtenerUrl(opcion, valor);
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Convertir la respuesta JSON a un objeto JsonObject
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            // Acceder a los datos de la respuesta
            double conversionRate = jsonResponse.get("conversion_rate").getAsDouble();
            String req_result = jsonResponse.get("result").getAsString();

            System.out.println("Valor convertido: " + conversionRate);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static String obtenerUrl(int opcion, double valor) {
        // URL de la API
        String API = "f65e035411c610a68057465c";
        String url = "";
        String Url = "https://v6.exchangerate-api.com/v6/" + API + "/pair/";
        if (opcion == 1) {
            // Dolares a pesos argentinos:
            url = Url + "USD/ARS/" + valor;
        } else if (opcion == 2) {
            // peso argentino a dolar
            url = Url + "ARS/USD/" + valor;
        } else if (opcion == 3) {
            // Dolar a real brasileño
            url = Url + "USD/BRL/" + valor;
        } else if (opcion == 4) {
            // Real brasileño a dolar
            url = Url + "BRL/USD/" + valor;
        } else if (opcion == 5) {
            // Dolar a peso colombiano
            url = Url + "USD/COP/" + valor;
        } else if (opcion == 6) {
            // Peso colombiano a dolar.
            url = Url + "COP/USD/" + valor;
        }
        return url;
    }
}