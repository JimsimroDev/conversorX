package com.jimsimrodev.conversorX.modelo;

import java.io.BufferedReader;
import java.io.IOException;

public class ConvertidorDeMoneda {

    public double realizarConversion(BufferedReader in) throws IOException {
        System.out.println("Igrese la cantidad a convertir");
        double cantidad = Double.parseDouble(in.readLine());
        return cantidad;
    }
}
