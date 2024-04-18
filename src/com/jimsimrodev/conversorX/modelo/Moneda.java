package com.jimsimrodev.conversorX.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.SimpleTimeZone;


public record Moneda(String base_code,
                         String target_code,
                         String conversion_rate,
                         List<List<String>> supported_codes) {

        public String cantidaMonedas(double cantidad) {
            double total = cantidad * Double.parseDouble(conversion_rate);
            return "\n¡Hecho! Ahora " + cantidad +" "+ base_code + " Equivalen a " + total +" "+ target_code;
        }

        public void codes(){
            supported_codes.forEach(System.out::println);

        }
               @Override
        public String toString() {
            return "Moneda a convertir= [" + base_code + "]" +
                    ", Mondeda convertida a= [" + target_code + "]" +
                    ", Valore de un = [" + base_code + "] en [" + target_code + "]  es de [" + conversion_rate + "] " + target_code;
        }
    }

