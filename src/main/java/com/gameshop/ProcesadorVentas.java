package com.gameshop;

public class ProcesadorVentas {

    // VULNERABILIDAD SONARLINT: Contraseña en texto plano

    private String dbClave;

    public ProcesadorVentas() {
        this.dbClave = System.getenv("DB_CLAVE");
    }


    private static final double DESCUENTO_VIP =0.15;
    private static final double IVA_GENERAL =0.21;









    /**
     * Calcula el precio final aplicando descuento VIP o IVA.
     *
     * @param precioOriginal precio base del producto
     * @param esVip indica si el cliente es VIP
     * @return precio final calculado
     */
    public double calcularPrecioFinal(double precioOriginal, boolean esVip) {


        if (esVip) {
            // CODE SMELL: Magic Number (0.15 representa el 15% de descuento)

            return aplicarDescuento(precioOriginal, DESCUENTO_VIP);
        }
        return aplicarIva(precioOriginal, IVA_GENERAL);
    }
        // BUG LÓGICO: Al VIP se le está SUMANDO el descuento al precio original, encareciendo el juego.

     private double aplicarDescuento(double precio, double descuento) {
        return precio * (1 - descuento);

         // CODE SMELL: Magic Number (1.21 representa el 21% de IVA)
     }
     private double aplicarIva(double precio, double iva) {
        return precio * (1 + iva);
     }


    public String getDbClave() {
        return dbClave;
    }

    public void setDbClave(String dbClave) {
        this.dbClave = dbClave;
    }
}