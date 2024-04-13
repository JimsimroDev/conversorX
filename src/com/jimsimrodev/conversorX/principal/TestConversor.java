package com.jimsimrodev.conversorX.principal;

import com.jimsimrodev.conversorX.Moneda;
import com.jimsimrodev.conversorX.modelo.ApiConversonMoneda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestConversor {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ApiConversonMoneda conversorModeda = new ApiConversonMoneda();
       // System.out.println("Escoje la maneda a convertir");
        try {
        String USD = "USD";
        String cop = "COP";
            Moneda monedaConvertida = conversorModeda.escojerMoneda(USD, cop);
            System.out.println(monedaConvertida.toString());
        }catch (NumberFormatException e){
            System.out.println("No se encutra " + e.getMessage());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizacion la aplicacion");
        }
    }
}
