package com.aluracursos.conversormonedas;

public class CalculoMoneda {
    //Realiza la conversión directa (De Moneda Base/"USD" a Moneda de Cambio).
    public static double calculadoraConversionDirecta(double monto, double tasa){
        return monto * tasa;
    }

    //Realiza la conversión inversa (De Moneda de Cambio a Moneda Base/USD).
    public static double calculadoraConversionInversa(double monto, double tasa){
        if (tasa == 0){
            System.err.println("ERROR: La tasa de cambio es cero. Imposible de dividir");
            return 0.0;
        }
        return monto / tasa;
    }

}
