package org.usach;

/**
 * Clase que representa el comportamiento de una imagen
 * @author Carlos Vera Ramirez
 * @version 1.0
 * @since 2022-11-06
 */

public interface ImageOperations_20816739_VeraRamirez {

    /**
     * Metodo que verifica si la imagen es de pixeles Bit
     * @return boolean
     */
    public boolean isBitmap();

    /**
     * Metodo que verifica si la imagen es de pixeles RGB
     * @return boolean
     */
    public boolean isPixmap();

    /**
     * Metodo que verifica si la imagen es de pixeles Hex
     * @return boolean
     */
    public boolean isHexmap();

    /**
     * Metodo que retorna comprueba si la imagen esta comprimida
     * @return boolean
     */
    public boolean isCompressed();

    /**
     * Metodo que modifica la imagen, invierte la imagen horizontalmente
     * @return Image
     */
    public Image_20816739_VeraRamirez flipH();

    /**
     * Metodo que modifica la imagen, invierte la imagen verticalmente
     * @return Image
     */
    public Image_20816739_VeraRamirez flipV();

    /**
     * Metodo que modifica la imagen, recorta la imagen
     * @param x1 coordenada x del primer pixel
     * @param x2 coordenada x del segundo pixel
     * @param y1 coordenada y del primer pixel
     * @param y2 coordenada y del segundo pixel
     * @return Image
     */
    public Image_20816739_VeraRamirez crop(int x1, int y1, int x2, int y2);

    /**
     * Metodo que modifica un pixel, cambia el tipo de pixel de RGB a Hex.
     * @return Image
     */
    public Image_20816739_VeraRamirez imgRGBToHex();

}
