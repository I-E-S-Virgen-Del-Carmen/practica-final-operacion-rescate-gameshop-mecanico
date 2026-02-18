package com.gameshop;

public class GestorInventario {

    public static final int STOCK_MINIMO = 5;

    public void gestionarInventario(String[] nombreJuego, int[] cantidad) {
        int Total = 0;

        for (int i = 0; i < nombreJuego.length; i++) {
            comprobarNombre("Revisando stock de: " + nombreJuego[i]);

            comprobarStock(nombreJuego, cantidad, i);

            Total = getTotal(Total, cantidad[i]);
        }
        comprobarNombre("Total de juegos en el almacén: " + Total);
    }

    private static int getTotal(int Total, int cantidad) {
        Total = Total + cantidad;
        return Total;
    }

    private static void comprobarNombre(String nombreJuego) {
        System.out.println(nombreJuego);
    }

    private static void comprobarStock(String[] nombreJuego, int[] cantidad, int i) {
        if (cantidad[i] <= STOCK_MINIMO) {
            comprobarNombre("¡ALERTA! Pedir más copias de " + nombreJuego[i]);
        }
    }
}