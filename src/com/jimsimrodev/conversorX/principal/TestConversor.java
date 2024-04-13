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
    public void run(){
        StringBuilder menu = new  StringBuilder();
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
USD - Dólar estadounidense
        * */

        menu.append(":::::::::::::::::::::CONVERSOR DE MONEDA:::::::::::::::::::::::::\n");
        menu.append("1 ~ de dolares americano USD a pesos colombianos COP\n");
        menu.append("2 ~ de pesos colombianos COP a dolar americano USD\n");
        menu.append("3 ~ de pesos boliviano BOB a Real brasileño BRL\n");
        menu.append("4 ~ salir\n");
        menu.append("¿Que desea hacer ?: ");
        while (true) {
            try {
                System.out.println(menu);
                opcion = in.readLine();

                if ("1".equalsIgnoreCase(opcion)) {
                    cantidad = cant.realizarConversion(in);
                    Moneda monedaConvertida = conversorModeda.escojerMoneda(USD, COP);
                    //System.out.println(monedaConvertida.toString());
                    System.out.println("EL TOTAL ES " + monedaConvertida.cantidaMonedas(cantidad));
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
