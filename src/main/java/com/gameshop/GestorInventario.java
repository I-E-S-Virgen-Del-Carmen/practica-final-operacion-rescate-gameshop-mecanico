package com.gameshop;
import java.util.logging.Logger;

public class GestorInventario {
    static Logger logger = Logger.getLogger(GestorInventario.class.getName());
    public static final int STOCK_MINIMO = 5;

    public void gestionarInventario(String[] nombreJuego, int[] cantidad) {
        int total = 0;

        for (int i = 0; i < nombreJuego.length; i++) {
            comprobarNombre("Revisando stock de: " + nombreJuego[i]);

            comprobarStock(nombreJuego, cantidad, i);

            total = getTotal(total, cantidad[i]);
        }
        comprobarNombre("Total de juegos en el almacén: " + total);
    }

    private static int getTotal(int total, int cantidad) {
        total = total + cantidad;
        return total;
    }

    private static void comprobarNombre(String nombreJuego) {
        logger.info(nombreJuego);
    }

    private static void comprobarStock(String[] nombreJuego, int[] cantidad, int i) {
        if (cantidad[i] <= STOCK_MINIMO) {
            comprobarNombre("¡ALERTA! Pedir más copias de " + nombreJuego[i]);
        }
    }
}