package org.usach;

/**
 * Clase que representa un pixel, para ser heredado por los tipos de pixeles.
 * @author Carlos Vera Ramirez
 * @version 1.0
 * @since 2022-11-06
 */
public abstract class Pixel_20816739_VeraRamirez {
    protected int x;
    protected int y;
    protected int depth;

    /**
     * Constructor de la clase Pixel
     * @param x coordenada x del pixel
     * @param y coordenada y del pixel
     * @param depth profundidad del pixel
     */
    public Pixel_20816739_VeraRamirez(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    /**
     * Metodo que retorna la coordenada x del pixel
     * @return coordenada x del pixel (int)
     */
    public int getX() {
        return x;
    }

    /**
     * Metodo que retorna la coordenada y del pixel
     * @return coordenada y del pixel (int)
     */
    public int getY() {
        return y;
    }

    /**
     * Metodo que retorna la profundidad del pixel
     * @return profundidad del pixel (int)
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Metodo que cambia el valor de la coordenada x del pixel
     * @param x nuevo valor de la coordenada x del pixel (int)
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Metodo que cambia el valor de la coordenada y del pixel
     * @param y nuevo valor de la coordenada y del pixel (int)
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Metodo que cambia el valor de la profundidad del pixel
     * @param depth nuevo valor de la profundidad del pixel (int)
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Metodo que transforma la informacion a un String
     * @return String
     */
    @Override
    public String toString() {
        return "Pixel{" +
                "x=" + x +
                ", y=" + y +
                ", depth=" + depth +
                '}';
    }
}
