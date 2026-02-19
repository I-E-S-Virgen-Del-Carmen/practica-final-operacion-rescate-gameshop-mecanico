package com.gameshop;

import java.util.logging.Logger;

/**
 * Clase encargada de gestionar el inventario de videojuegos.
 * Recorre la lista de juegos, comprueba si el stock es bajo
 * y calcula el total de unidades almacenadas.
 *
 *
 * @author Manuel
 * @version 1.0
 */
public class GestorInventario {

    static Logger logger = Logger.getLogger(GestorInventario.class.getName());

    /** Cantidad mínima permitida antes de generar alerta de reposición */
    public static final int STOCK_MINIMO = 5;

    /**
     * Recorre todos los juegos, comprueba su stock
     * y calcula el total de unidades disponibles.
     *
     * @param nombreJuego Array con los nombres de los videojuegos
     * @param cantidad    Array con la cantidad disponible de cada videojuego
     */
    public void gestionarInventario(String[] nombreJuego, int[] cantidad) {
        int total = 0;

        for (int i = 0; i < nombreJuego.length; i++) {

            // Muestra por log el juego que se está revisando
            comprobarNombre("Revisando stock de: " + nombreJuego[i]);

            // Comprueba si el stock está por debajo del mínimo
            comprobarStock(nombreJuego, cantidad, i);

            // Acumula el total de unidades
            total = getTotal(total, cantidad[i]);
        }

        // Muestra el total final del inventario
        comprobarNombre("Total de juegos en el almacén: " + total);
    }

    /**
     * Suma la cantidad actual al total acumulado.
     *
     * @param total    Total acumulado hasta el momento
     * @param cantidad Cantidad del juego actual
     * @return Nuevo total actualizado
     */
    private static int getTotal(int total, int cantidad) {
        total = total + cantidad;
        return total;
    }

    private static void comprobarNombre(String nombreJuego) {
        logger.info(nombreJuego);
    }

    /**
     * Comprueba si el stock de un juego está por debajo del mínimo.
     *
     * @param nombreJuego Array con los nombres de los videojuegos
     * @param cantidad    Array con las cantidades disponibles
     * @param i           Índice del juego que se está evaluando
     */
    private static void comprobarStock(String[] nombreJuego, int[] cantidad, int i) {
        if (cantidad[i] <= STOCK_MINIMO) {
            comprobarNombre("¡ALERTA! Pedir más copias de " + nombreJuego[i]);
        }
    }
}
