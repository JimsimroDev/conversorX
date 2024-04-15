package com.jimsimrodev.conversorX.modelo;

import java.io.BufferedReader;
import java.io.IOException;

public record Moneda(String base_code,
                     String target_code,
                     String conversion_rate) {

    public String cantidaMonedas(double cantidad){
        double total = cantidad * Double.parseDouble(conversion_rate);
        //¡Hecho! Ahora [cantidad ingresada] se convierte en [cantidad convertida] en [moneda deseada].
        return "¡Hecho! Ahora " + cantidad +base_code + " Se convierten en "+ total + target_code;
    }


    @Override
    public String toString() {
        return  "Moneda a convertir= [" + base_code+ "]" +
                ", Mondeda convertida a= [" + target_code +"]" +
                ", Valore de un = ["+ base_code +"] en [" + target_code + "]  es de [" +conversion_rate +"] "+target_code;
    }
}
