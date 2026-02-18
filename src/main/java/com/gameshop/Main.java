package com.gameshop;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Main {
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Iniciando Sistema GameShop...\n");

        GestorInventario inventario = new GestorInventario();
        ProcesadorVentas ventas = new ProcesadorVentas();
        SistemaRecompensasVip recompensas = new SistemaRecompensasVip();

        // --- PRUEBA ALUMNO 1: INVENTARIO ---
        logger.info("--- 1. TEST DE INVENTARIO ---");
        String[] juegos = {"Cyberpunk", "Zelda", "Mario Kart", "Halo"};
        int[] stock = {10, 2, 15, 4};
        inventario.gestionarInventario(juegos, stock);

        // --- PRUEBA ALUMNO 2: VENTAS ---
        logger.info("\n--- 2. TEST DE VENTAS ---");

        double precioFinal = ventas.calcularPrecioFinal(100.0, true);
        logger.info(String.format("Precio final calculado al VIP: %.2f EUR", precioFinal));

        // --- PRUEBA ALUMNO 3: RECOMPENSAS VIP ---
        logger.info("\n--- 3. TEST DE RECOMPENSAS ---");
        if (logger.isLoggable(Level.INFO)) {
            String reporte = recompensas.generarReporte(150);
            logger.info(reporte);
        }


        logger.info("### Comprobando cliente anónimo ###");

        String cliente = null;

        if (cliente == null) {
            logger.warning("No se puede comprobar VIP: el cliente es null.");
        } else if (logger.isLoggable(Level.INFO)) {
            boolean esVIP = recompensas.comprobarVip(cliente);
            logger.info(String.format("¿Es VIP => %s", esVIP));
        }

    }
}