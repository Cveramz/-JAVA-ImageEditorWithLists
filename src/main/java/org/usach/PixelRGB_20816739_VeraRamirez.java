package org.usach;


/**
 * Clase que representa un pixel de tipo RGB
 * @author Carlos Vera Ramirez
 * @version 1.0
 * @since 2022-11-06
 */
public class PixelRGB_20816739_VeraRamirez extends Pixel_20816739_VeraRamirez {
    private int red;
    private int green;
    private int blue;

    /**
     * Constructor de la clase PixelBit
     * @param x posicion en x (int)
     * @param y posicion en y (int)
     * @param depth profundidad del pixel (int)
     * @param red valor del rojo (int)
     * @param green valor del verde (int)
     * @param blue valor del azul (int)
     */
    public PixelRGB_20816739_VeraRamirez(int x, int y, int depth, int red, int green, int blue) {
        super(x, y, depth);
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Metodo que retorna el valor del rojo
     * @return valor del rojo (int)
     */
    public int getRed() {
        return red;
    }

    /**
     * Metodo que cambia el valor del rojo
     * @param red valor del rojo (int)
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * Metodo que retorna el valor del verde
     * @return valor del verde (int)
     */
    public int getGreen() {
        return green;
    }

    /**
     * Metodo que cambia el valor del verde
     * @param green valor del verde (int)
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     * Metodo que retorna el valor del azul
     * @return valor del azul (int)
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Metodo que cambia el valor del azul
     * @param blue valor del azul (int)
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }


    /**
     * Metodo que transforma la informacion a un String
     * @return String
     */
    @Override
    public String toString() {
        return "PixelRGB{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", x=" + x +
                ", y=" + y +
                ", depth=" + depth +
                '}';
    }
}
