package com.gameshop;

public class SistemaRecompensasVip {

    private static final int oro = 100;
    private static final int leyenda = 500;

    public boolean comprobarVip(String tipoCliente) {
        // BUG (NPE): Si 'tipoCliente' es null (como pasa en el Main), intentar hacer .equals() lanza un NullPointerException.
        // SOLUCIÓN SONARLINT: Escribir "Premium".equals(tipoCliente)
        if ("Premium".equals(tipoCliente)) {
            return true;
        } else {
            return false;
        }
    }

    public String generarReporte(int puntos) {
        StringBuilder reporte = new StringBuilder();

        // CODE SMELL CRÍTICO: Concatenación de Strings en un bucle con '+' (usar StringBuilder)
        generarAstericos(puntos, reporte);

        // CODE SMELL: Complejidad Cognitiva alta (Escalera de Ifs)
        agregarTituloCliente(puntos, reporte);

        return reporte.toString();
    }

    private void agregarTituloCliente(int puntos, StringBuilder reporte) {
        if (puntos > 0) {
            if (puntos >= oro) {
                if (puntos >= leyenda) {
                    reporte.append(" ¡CLIENTE LEYENDA!");
                } else {
                    reporte.append(" ¡CLIENTE ORO!");
                }
            }
        }
    }

    private void generarAstericos(int puntos, StringBuilder reporte) {
        for (int i = 0; i < puntos; i++) {
            reporte.append("*");
        }
    }
}