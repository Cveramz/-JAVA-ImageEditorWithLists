package org.usach;

/**
 * Clase que representa un pixel de tipo Hex
 * @author Carlos Vera Ramirez
 * @version 1.0
 * @since 2022-11-06
 */

public class PixelHex_20816739_VeraRamirez extends Pixel_20816739_VeraRamirez {
    private String hex;

    /**
     * Constructor de la clase PixelHex
     * @param x posicion en x
     * @param y posicion en y
     * @param depth profundidad
     * @param hex valor en hexadecimal
     */

    public PixelHex_20816739_VeraRamirez(int x, int y, int depth, String hex) {
        super(x, y, depth);
        this.hex = hex;
    }


    /**
     * Metodo que retorna el valor del pixel en hexadecimal
     * @return valor del pixel en hexadecimal (String)
     */
    public String getHex() {
        return hex;
    }

    /**
     * Metodo que modifica el valor Hex
     * @param hex nuevo valor en hexadecimal
     */
    public void setHex(String hex) {
        this.hex = hex;
    }

    /**
     * Metodo que transforma la informacion a un String
     * @return String
     */
    @Override
    public String toString() {
        return "PixelHex{" +
                "hex='" + hex + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", depth=" + depth +
                '}';
    }
}