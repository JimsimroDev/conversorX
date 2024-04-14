package com.jimsimrodev.conversorX.principal;

import com.jimsimrodev.conversorX.modelo.ConvertidorDeMoneda;
import com.jimsimrodev.conversorX.modelo.Moneda;
import com.jimsimrodev.conversorX.modelo.ApiConversonMoneda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestConversor {
    private static final String DIVLINE = "+-------+-------+-------+-------+-------+-------+-------+";

    public void titulo(){
        String titulo = "CONVERSOR DE MONEDA";
        StringBuilder menu = new  StringBuilder();
        menu.append("|   1   | dolar americano USD a peso colombiano COP     |\n");
        menu.append("|   2   | peso colombiano COP a dolar americano USD     |\n");
        menu.append("|   3   | peso boliviano BOB a Real brasileño BRL       |\n");
        menu.append("|   4   | salir                                         |");

        System.out.println("+-------------------------------------------------------+");
        System.out.print("|");

        int x = 1;
        while (x < (DIVLINE.length() - titulo.length())/2){
            System.out.print(" ");
            x++;
        }
        System.out.print(titulo);
        x = x + titulo.length();
        while(x < (DIVLINE.length()-1)){
            System.out.print(" ");
            x++;
        }
        System.out.println("|");
        System.out.println(DIVLINE);
        System.out.print("|comando|");
        System.out.println(" descripcion                                   |");
        System.out.println(menu);
        System.out.println(DIVLINE);
        System.out.print("¿Que desea hacer ?: ");
    }

    public void run(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ApiConversonMoneda conversorModeda = new ApiConversonMoneda();
        ConvertidorDeMoneda cant = new ConvertidorDeMoneda();
        String opcion = "";
        String USD = "USD";
        String COP = "COP";
        String BOB = "BOB";
        String BRL = "BRL";
        double cantidad = 0;

        /*
        * ARS - Peso argentino
BOB - Boliviano boliviano
BRL - Real brasileño
CLP - Peso chileno
COP - Peso colombiano
USD - Dólar estadounidense  * */

        while (true) {
            titulo();
            try {
                // System.out.println(menu);
                opcion = in.readLine();

                if ("1".equalsIgnoreCase(opcion)) {
                    cantidad = cant.realizarConversion(in);
                    Moneda monedaConvertida = conversorModeda.escojerMoneda(USD, COP);
                    System.out.println(monedaConvertida.toString());
                    System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                }else if("2".equalsIgnoreCase(opcion)){
                    cantidad = cant.realizarConversion(in);
                    Moneda monedaConvertida = conversorModeda.escojerMoneda(COP, USD);
                    System.out.println(monedaConvertida.toString());
                    System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                }else if("3".equalsIgnoreCase(opcion)){
                    cantidad = cant.realizarConversion(in);
                    Moneda monedaConvertida = conversorModeda.escojerMoneda(BOB, BRL);
                    System.out.println(monedaConvertida.toString());
                    System.out.println(monedaConvertida.cantidaMonedas(cantidad));
                }

            } catch (IOException | NumberFormatException e) {
                System.out.println("No se encuentra esa moneda " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizacion la aplicacion");
            }
            if("4".equalsIgnoreCase(opcion)){
                break;
            }
        }
        System.out.println("Hasta pronto gracias por utilizar el programa...");
    }
    public static void main(String[] args) {
        TestConversor iniciar = new TestConversor();
        iniciar.run();
    }
}
