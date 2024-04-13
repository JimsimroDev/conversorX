package com.jimsimrodev.conversorX.principal;

import com.jimsimrodev.conversorX.modelo.ConvertidorDeMoneda;
import com.jimsimrodev.conversorX.modelo.Moneda;
import com.jimsimrodev.conversorX.modelo.ApiConversonMoneda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestConversor {
    public static void main(String[] args) {
        StringBuilder menu = new  StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ApiConversonMoneda conversorModeda = new ApiConversonMoneda();
        ConvertidorDeMoneda cant = new ConvertidorDeMoneda();
        String opcion = "";
        String USD = "USD";
        String COP = "COP";
        double cantidad = 0;

        menu.append(":::::::::::::::::::::CONVERSOR DE MONEDA:::::::::::::::::::::::::\n");
        menu.append("1 ~ de USD a COP\n");
        menu.append("2 ~ de COP a USD\n");
        menu.append("3 ~ salir\n");
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
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("No se encuentra esa moneda " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizacion la aplicacion");
            }
            if("3".equalsIgnoreCase(opcion)){
                break;
            }
        }
        System.out.println("Hasta pronto gracias por utilizar el programa...");
    }
}
