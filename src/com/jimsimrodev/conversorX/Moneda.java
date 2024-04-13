package com.jimsimrodev.conversorX;

public record Moneda(String base_code,
                     String target_code,
                     String conversion_rate) {
    @Override
    public String toString() {
        return  "Moneda a convertir= [" + base_code+ "]" +
                ", Mondeda convertida a= [" + target_code +"]" +
                ", Valore de la moneda es='" + conversion_rate + " " +target_code;
    }
}
