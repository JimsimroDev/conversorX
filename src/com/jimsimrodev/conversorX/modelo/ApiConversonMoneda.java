package com.jimsimrodev.conversorX.modelo;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ApiConversonMoneda {
    private String API_KEY;
    private String BASE_URL;

    public ApiConversonMoneda() {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(".env")) {
            // Cargar el archivo .env
            properties.load(input);

            // Obtener las variables del archivo .env
            API_KEY = properties.getProperty("API_KEY");
            BASE_URL = properties.getProperty("BASE_URL");

            // Imprimir las variables cargadas
            System.out.println("API Key: " + API_KEY);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Moneda mostrarCodigosAdminitod() {
        URI direccion = URI.create(BASE_URL + API_KEY + "codes");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encotro la moneda" + e.getMessage());
        }
    }

    public Moneda escojerMoneda(String moneda, String moneda1) {
        URI url = URI
                .create(BASE_URL + API_KEY + "pair/" + moneda + "/" + moneda1);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encotro la moneda" + e.getMessage());
        }
    }

}
