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
        String titulo = "CONVERSOR DE MONEDA";
        StringBuilder menu = new  StringBuilder();
        menu.append("|   1   | dolar americano USD a peso colombiano COP     |\n");
        menu.append("|   2   | peso colombiano COP a dolar americano USD     |\n");
        menu.append("|   3   | peso boliviano BOB a Real brasileño BRL       |\n");
        menu.append("|   4   | Consultar tu Historial de busqueda            |\n");
        menu.append("|   5   | Codigos que se admiten                        |\n");
        menu.append("|   5   | Salir                                         |");

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

    public String fecha(String fecha, String hora){
        return  String.valueOf(fecha) +" a las: "+ String.valueOf(hora);
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
        Map<String, String> historial = new HashMap<>();
        List<Moneda> historialDeMonedas = new ArrayList<>();



        while (true) {
            titulo();
            try {
                // System.out.println(menu);
                opcion = in.readLine();

                if ("1".equalsIgnoreCase(opcion)) {
                    cantidad = cant.realizarConversion(in);
                    Moneda monedaConvertida = conversorModeda.escojerMoneda(USD, COP);
                    LocalDate ld = LocalDate.now();
                    LocalTime hr = LocalTime.now();

                    System.out.println(monedaConvertida.toString());
                    System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                    historial.put(monedaConvertida.cantidaMonedas(cantidad),fecha(String.valueOf(ld),String.valueOf(hr)));
                    historialDeMonedas.add(monedaConvertida);

                }else if("2".equalsIgnoreCase(opcion)){
                    cantidad = cant.realizarConversion(in);
                    Moneda monedaConvertida = conversorModeda.escojerMoneda(COP, USD);
                    System.out.println(monedaConvertida.toString());
                    System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                    historialDeMonedas.add(monedaConvertida);

                }else if("3".equalsIgnoreCase(opcion)){
                    cantidad = cant.realizarConversion(in);
                    Moneda monedaConvertida = conversorModeda.escojerMoneda(BOB, BRL);
                    System.out.println(monedaConvertida.toString());
                    System.out.println(monedaConvertida.cantidaMonedas(cantidad));

                    historialDeMonedas.add(monedaConvertida);
                }else if("4".equalsIgnoreCase(opcion)){
                    System.out.println(DIVLINE);
                    System.out.println("Historial");
                    historial.forEach((k,v) -> System.out.println(k +" Esta consulta se realizo el " +  v.toString()));
                    //historialDeMonedas.forEach(System.out::println);
                  //  historialDeCosulta.forEach((x) -> System.out.println(x.toString()));
                }else if("5".equalsIgnoreCase(opcion)){
                    //conversorModeda.mostrarCodigosAdminitod();
                    Moneda  mo = conversorModeda.mostrarCodigosAdminitod();
                    mo.codes();
                }else if("6".equalsIgnoreCase(opcion)){
                    System.out.println("Ingrese la el codigo de la moneda que quiere convertir");
                    String moneda = in.readLine();
                    System.out.println("Ingrese la el codigo de la moneda a la que quiere convertir");
                    String moneda1 = in.readLine();
                    System.out.println("Ingrese la el codigo de la moneda a la que quiere convertir");
                    cantidad = cant.realizarConversion(in);
                    Moneda monedaConvertida = conversorModeda.escojerMoneda(moneda, moneda1);
                    System.out.println(monedaConvertida.toString());
                    System.out.println(monedaConvertida.cantidaMonedas(cantidad));
                    LocalDate ld = LocalDate.now();
                    LocalTime hr = LocalTime.now();
                    historial.put(monedaConvertida.cantidaMonedas(cantidad),fecha(String.valueOf(ld),String.valueOf(hr)));
                    historialDeMonedas.add(monedaConvertida);

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
