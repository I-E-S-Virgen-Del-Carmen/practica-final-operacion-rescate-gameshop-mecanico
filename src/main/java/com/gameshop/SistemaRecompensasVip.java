package com.gameshop;

/**
 * Clase que gestiona las recompensas VIP de los clientes.
 * Permite comprobar si un cliente es Premium y generar un reporte de puntos.
 *
 * @author Ayoub chikhaoui machache
 * @version 1.0
 */

public class SistemaRecompensasVip {

    private static final int ORO = 100;
    private static final int LEYENDA = 500;

    /**
     * Comprueba si un cliente es de tipo Premium.
     *
     * @param tipoCliente El tipo de cliente (puede ser null)
     * @return true si el cliente es Premium, false en caso contrario
     */

    public boolean comprobarVip(String tipoCliente) {
        // BUG (NPE): Si 'tipoCliente' es null (como pasa en el Main), intentar hacer .equals() lanza un NullPointerException.
        // SOLUCIÓN SONARLINT: Escribir "Premium".equals(tipoCliente)
        return "Premium".equals(tipoCliente);

    }

    /**
     * Genera un reporte visual de los puntos de un cliente,
     * agregando asteriscos y un título según los puntos acumulados.
     *
     * @param puntos La cantidad de puntos del cliente
     * @return String con el reporte de puntos y título
     */

    public String generarReporte(int puntos) {
        StringBuilder reporte = new StringBuilder();

        // CODE SMELL CRÍTICO: Concatenación de Strings en un bucle con '+' (usar StringBuilder)
        generarAstericos(puntos, reporte);

        // CODE SMELL: Complejidad Cognitiva alta (Escalera de Ifs)
        agregarTituloCliente(puntos, reporte);

        return reporte.toString();
    }

    private void agregarTituloCliente(int puntos, StringBuilder reporte) {
        if (puntos > 0 && puntos < ORO) {
            if (puntos >= LEYENDA) {
                reporte.append(" ¡CLIENTE LEYENDA!");
            } else {
                reporte.append(" ¡CLIENTE ORO!");
            }
        }
    }

    private void generarAstericos(int puntos, StringBuilder reporte) {
        for (int i = 0; i < puntos; i++) {
            reporte.append("*");
        }
    }
}