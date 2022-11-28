package org.usach;

/**
 * Clase que representa un pixel de tipo Bit
 * @author Carlos Vera Ramirez
 * @version 1.0
 * @since 2022-11-06
 */
public class PixelBit_20816739_VeraRamirez extends Pixel_20816739_VeraRamirez {
    private int bit;

    /**
     * Constructor de la clase PixelBit
     * @param x posicion en x
     * @param y posicion en y
     * @param depth profundidad del pixel
     * @param bit valor del bit
     */
    public PixelBit_20816739_VeraRamirez(int x, int y, int depth, int bit) {
        super(x, y, depth);
        this.bit = bit;
    }

    /**
     * Metodo que retorna el valor del bit
     * @return valor del bit (int)
     */
    public int getBit() {
        return bit;
    }

    /**
     * Metodo que modifica el valor del bit
     * @param bit nuevo valor del bit (int)
     */
    public void setBit(int bit) {
        this.bit = bit;
    }


    /**
     * Metodo que transforma la informacion a un String
     * @return String
     */
    @Override
    public String toString() {
        return "PixelBit{" +
                "bit=" + bit +
                ", x=" + x +
                ", y=" + y +
                ", depth=" + depth +
                "}";
    }
}