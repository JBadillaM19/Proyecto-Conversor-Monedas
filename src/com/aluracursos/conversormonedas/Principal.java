package com.aluracursos.conversormonedas;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    //Clase principal que funciona como menú de interacción con el usuario.

    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        System.out.println("Sistema Iniciado🪙");

        //Bucle principal
        while (opcion != 7){
            mostrarmenu();

            System.out.println("Elija una opción válida: ");
            if (teclado.hasNextInt()){
                opcion = teclado.nextInt();

                if (opcion >= 1 && opcion <= 6){
                    System.out.println("Ingrese el valor a convertir: ");
                    if (teclado.hasNextDouble()){
                        double valor = teclado.nextDouble();

                        //Se llama a la lógica de conversión.
                        manejarConversion(opcion, valor);
                    } else {
                        System.out.println("⚠️ERROR: Por favor ingrese un valor/monto númerico para convertir.⚠️");
                        teclado.next(); //Limpiar el teclado
                    }
                } else if (opcion == 7) {
                    System.out.println("Saliendo del Sistema 👋🏼");
                } else {
                    System.out.println("❌Opción no válida. Intente de nuevo.❌");
                }
            } else {
                System.out.println("⚠️ERROR: Debe ingresar un número válido del menú.⚠️");
                teclado.next();
            }
        }
        teclado.close();
    }

    //--- Lógica de conversión---
    //Determina las monedas y la llamada a la API.
    public static void manejarConversion(int opcion, double valor){

        ConsultaApi api = new ConsultaApi();
        String monedaOrigen = "", monedaCambio = "";
        double resultado = 0;

        //Determinar el par de conversión
        switch (opcion){
            case 1: monedaOrigen = "USD"; monedaCambio = "CRC"; break;
            case 2: monedaOrigen = "CRC"; monedaCambio = "USD"; break;
            case 3: monedaOrigen = "USD"; monedaCambio = "BRL"; break;
            case 4: monedaOrigen = "BRL"; monedaCambio = "USD"; break;
            case 5: monedaOrigen = "USD"; monedaCambio = "MXN"; break;
            case 6: monedaOrigen = "MXN"; monedaCambio = "USD"; break;
            default:
                System.err.println("ERROR: Opción no válida para conversión.");
        }

        //Llamada a la API
        try {
            System.out.println("Consultando tasa en tiempo real para: " + monedaOrigen + " a " + monedaCambio + "...");
            ResultadoConversion conversion = api.buscarConversion(monedaOrigen, monedaCambio, valor);
            resultado = conversion.conversion_result();
        } catch (IOException | InterruptedException e){
            //Manejo de excepciones para problemas de red o de la API
            System.err.println("\nError con la conexión o la respuesta de la API. No se pudo completar la conversión");
            System.err.println("Detalle del error: " + e.getMessage());
        }

        //Se muestra el resultado de la conversión (La API hace el cálculo)
        System.out.println("\n📈Resultado de la conversión:\n");
        System.out.printf("El resultado de convertir %.2f %s es: %.2f %s\n\n",
                           valor, monedaOrigen, resultado, monedaCambio);
    }


    // Metodo de interfaz de usuario.
    public static void mostrarmenu(){
        System.out.println("\nSea bienvenido/a al Conversor de Monedas =)");
        System.out.println("\n******************************************************");
        System.out.println("1) Dólar ==> Colón");
        System.out.println("2) Colón ==> Dólar");
        System.out.println("3) Dólar ==> Real brasileño");
        System.out.println("4) Real brasileño ==> Dólar");
        System.out.println("5) Dólar ==> Peso mexicano");
        System.out.println("6) Peso mexicano ==> Dólar");
        System.out.println("7) Salir del sistema");
        System.out.println("******************************************************");
    }
}


