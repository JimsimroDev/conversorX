package com.jimsimrodev.conversorX.principal;

import com.jimsimrodev.conversorX.modelo.ConvertidorDeMoneda;
import com.jimsimrodev.conversorX.modelo.Moneda;
import com.jimsimrodev.conversorX.modelo.ApiConversonMoneda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class TestConversor {
    private static final String DIVLINE = "+-------+-------+-------+-------+-------+-------+-------+";

    public void titulo(){
        StringBuilder menu = new  StringBuilder();
        String titulo = "CONVERSOR DE MONEDA";
        menu.append("|   1   | dolar americano USD a peso colombiano COP     |\n");
        menu.append("|   2   | peso colombiano COP a dolar americano USD     |\n");
        menu.append("|   3   | peso boliviano BOB a Real brasileño BRL       |\n");
        menu.append("|   4   | Consultar tu Historial de busqueda            |\n");
        menu.append("|   5   | Codigos que se admiten                        |\n");
        menu.append("|   6   | Convertir otras monedas                       |\n");
        menu.append("|   7   | Salir                                         |");

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

    public String capturarFehcaHora(){
        LocalDate ld = LocalDate.now();
        LocalTime hr = LocalTime.now();
        String fechaYHora =  "\nEsta consulta se realizo el: " + String.valueOf(ld) + " a las: " + String.valueOf(hr);
        return fechaYHora;
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

        Map<String, String> historialDeConversiones = new HashMap<>();
        List<Moneda> historialDeMonedas = new ArrayList<>();

        while (true) {
            titulo();
            try {
                opcion = in.readLine();

                switch(opcion){
                    case "1" ->{
                        cantidad = cant.realizarConversion(in);
                        Moneda monedaConvertida = conversorModeda.escojerMoneda(USD, COP);
                        capturarFehcaHora();

                        System.out.println(monedaConvertida.toString());
                        System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                        historialDeConversiones.put(monedaConvertida.cantidaMonedas(cantidad),capturarFehcaHora());
                        historialDeMonedas.add(monedaConvertida);
                        break;
                    }
                    case "2" ->{
                        cantidad = cant.realizarConversion(in);
                        Moneda monedaConvertida = conversorModeda.escojerMoneda(COP, USD);
                        capturarFehcaHora();

                        System.out.println(monedaConvertida.toString());
                        System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                        historialDeConversiones.put(monedaConvertida.cantidaMonedas(cantidad),capturarFehcaHora());
                        historialDeMonedas.add(monedaConvertida);
                        break;
                    }
                    case "3" ->{
                        cantidad = cant.realizarConversion(in);
                        Moneda monedaConvertida = conversorModeda.escojerMoneda(BOB, BRL);
                        capturarFehcaHora();

                        System.out.println(monedaConvertida.toString());
                        System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                        historialDeConversiones.put(monedaConvertida.cantidaMonedas(cantidad),capturarFehcaHora());
                        historialDeMonedas.add(monedaConvertida);
                        break;
                    }
                    case "4" -> {
                        System.out.println(DIVLINE);
                        System.out.println("| Historial de las monedas consultadas |");
                        historialDeConversiones.forEach((k,v) -> System.out.println(k +  v.toString()));
                        //historialDeMonedas.forEach((k,v) -> System.out.println(k +  v.toString()));
                        //  historialDeCosulta.forEach((x) -> System.out.println(x.toString()));
                        break;
                    }
                    case "5" ->{
                        //conversorModeda.mostrarCodigosAdminitod();
                        Moneda  mo = conversorModeda.mostrarCodigosAdminitod();
                        mo.codes();
                        break;
                    }
                    case "6" ->{
                        System.out.println("Ingrese la el codigo de la moneda que quiere convertir");
                        String moneda = in.readLine();
                        System.out.println("Ingrese la el codigo de la moneda a la que quiere convertir");
                        String moneda1 = in.readLine();
                        System.out.println("Ingrese la el codigo de la moneda a la que quiere convertir");
                        cantidad = cant.realizarConversion(in);
                        capturarFehcaHora();
                        Moneda monedaConvertida = conversorModeda.escojerMoneda(moneda, moneda1);

                        System.out.println(monedaConvertida.toString());
                        System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                        historialDeConversiones.put(monedaConvertida.cantidaMonedas(cantidad),capturarFehcaHora());
                        historialDeMonedas.add(monedaConvertida);
                        break;
                    }
                    case "7" -> {
                        System.out.print("👌");
                        in.close();
                        break;
                    }
                    default -> System.out.println("Ingrse un numero entero valido");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("No se encuentra esa moneda " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizacion de la aplicacion");
            }
            if("7".equalsIgnoreCase(opcion)){
                break;
            }
        }
        System.out.println("Gracias por utilizar el programa Hasta pronto ...");
    }
    public static void main(String[] args) {
        TestConversor iniciar = new TestConversor();
        iniciar.run();
    }
}
