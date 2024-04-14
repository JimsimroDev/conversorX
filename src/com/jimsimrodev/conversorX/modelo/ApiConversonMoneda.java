package com.jimsimrodev.conversorX.modelo;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConversonMoneda {

    public Moneda escojerMoneda(String moneda, String moneda1){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/1bd5ee7d59735329e24ec8f9/pair/"+moneda+"/"+moneda1+"/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("No se encotro la moneda" + e.getMessage());
        }
    }

}
