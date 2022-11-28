package org.usach;

import java.util.List;

import java.util.Collections;


//DOCUMENTAR PROGRAMA CON JAVADOC

/**
 * Clase que representa un sistema de imagenes
 * @author Carlos Vera Ramirez
 * @version 1.0
 * @since 2022-11-06
 */
public class Image_20816739_VeraRamirez implements ImageOperations_20816739_VeraRamirez {
    private int largo;
    private int alto;
    private List<Pixel_20816739_VeraRamirez> pixels;
    private int tipoPixel; //1. Bit 2. Hex 3. RGB


    /**
     * Constructor de la clase Image
     * @param largo largo de la imagen
     * @param alto alto de la imagen
     * @param pixels lista de pixeles de la imagen
     * @param tipoPixel tipo de pixel de la imagen
     */
    public Image_20816739_VeraRamirez(int largo, int alto, List<Pixel_20816739_VeraRamirez> pixels, int tipoPixel) {
        this.largo = largo;
        this.alto = alto;
        this.pixels = pixels;
        this.tipoPixel = tipoPixel;

    }

    /**
     * Metodo que verifica si la imagen es de pixeles Bit
     * @return boolean
     */
    @Override
    public boolean isBitmap() {
        if (tipoPixel == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que verifica si la imagen es de pixeles Hex
     * @return boolean
     */
    @Override
    public boolean isHexmap() {
        if (tipoPixel == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que verifica si la imagen es de pixeles RGB
     * @return boolean
     */
    @Override
    public boolean isPixmap() {
        if (tipoPixel == 3) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Metodo que retorna el largo de la imagen
     * @return largo (int)
     */
    public int getLargo() {
        return largo;
    }

    /**
     * Metodo que modifica el atributo Largo
     * @param largo nuevo largo de la imagen (int)
     */
    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * Metodo que retorna el alto de la imagen
     * @return alto (int)
     */
    public int getalto() {
        return alto;
    }

    /**
     * Metodo que modifica el atributo Alto
     * @param alto nuevo alto de la imagen
     */
    public void setalto(int alto) {
        this.alto = alto;
    }

    /**
     * Metodo que retorna la lista de pixeles de la imagen
     * @return pixels (List<Pixel>)
     */
    public List<Pixel_20816739_VeraRamirez> getPixels() {
        return pixels;
    }

    /**
     * Metodo que modifica la lista de pixeles de la imagen
     * @param pixels nueva lista de pixeles de la imagen (List<Pixel>)
     */
    public void setPixels(List<Pixel_20816739_VeraRamirez> pixels) {
        this.pixels = pixels;
    }

    /**
     * Metodo que retorna el tipo de pixel de la imagen
     * @return tipoPixel (int)
     */
    public int getTipoPixel() {
        return tipoPixel;
    }

    /**
     * Metodo que modifica el tipo de pixel de la imagen
     * @param tipoPixel nuevo tipo de pixel de la imagen (int)
     */
    public void setTipoPixel(int tipoPixel) {
        this.tipoPixel = tipoPixel;
    }

    /**
     * Metodo que retorna comprueba si la imagen esta comprimida
     * @return boolean
     */
    @Override
    public boolean isCompressed(){
        return this.largo * this.alto > this.pixels.size();
    }

    /**
     * Metodo que modifica la imagen, invierte la imagen horizontalmente
     * @return Image
     */
    @Override
    public Image_20816739_VeraRamirez flipH(){
        //crear matriz de pixeles
        Pixel_20816739_VeraRamirez[][] matriz = new Pixel_20816739_VeraRamirez[this.alto][this.largo];
        int cont = 0;
        //primero rellenamos la matriz con los pixeles
        for (int i = 0; i < this.alto; i++) {
            for (int j = 0; j < this.largo; j++) {
                matriz[i][j] = this.pixels.get(cont);
                cont++;
            }
        }
        //ahora debemos ir invirtiendo fila por fila
        for (int i = 0; i < this.alto; i++) {
            for (int j = 0; j < this.largo/2; j++) {
                Pixel_20816739_VeraRamirez aux = matriz[i][j];
                matriz[i][j] = matriz[i][this.largo - j - 1];
                matriz[i][this.largo - j - 1] = aux;
            }
        }
        //ahora debemos pasar la matriz a una lista de pixeles
        List<Pixel_20816739_VeraRamirez> lista = this.pixels;
        cont = 0;
        for (int i = 0; i < this.alto; i++) {
            for (int j = 0; j < this.largo; j++) {
                lista.set(cont,matriz[i][j]);
                cont++;
            }
        }
        //ahora arreglar las coordenadas de los pixeles
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setX(i % this.largo);
            lista.get(i).setY(i / this.largo);
        }
        return new Image_20816739_VeraRamirez(this.largo,this.alto,lista,this.tipoPixel);
    }

    /**
     * Metodo que modifica la imagen, invierte la imagen verticalmente
     * @return Image
     */
    @Override
    public Image_20816739_VeraRamirez flipV(){
        //para invertir una imagen verticalmente, podemos simplemente invertir
        //la lista resultante del metodo flipH
        List<Pixel_20816739_VeraRamirez> lista = this.flipH().getPixels();
        Collections.reverse(lista);
        //ahora arreglar las coordenadas Y de los pixeles
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setY(i / this.largo);
        }
        return new Image_20816739_VeraRamirez(this.largo, this.alto,lista, this.tipoPixel);
    }

    /**
     * Metodo que modifica la imagen, recorta la imagen
     * @param x1 coordenada x del primer pixel
     * @param x2 coordenada x del segundo pixel
     * @param y1 coordenada y del primer pixel
     * @param y2 coordenada y del segundo pixel
     * @return Image
     */
    @Override
    public Image_20816739_VeraRamirez crop(int x1, int y1, int x2, int y2){
        List<Pixel_20816739_VeraRamirez> lista = getPixels();
        int newLargo = x2 - x1 + 1;
        int newalto = y2 - y1 + 1;
        //primero que nada debemos ir borrando todos los pixeles que tengan un X o Y menor a x1 o y1
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getX() < x1 || lista.get(i).getY() < y1){
                lista.remove(i);
                i--;
            }
        }
        //ahora debemos ir borrando todos los pixeles que tengan un X o Y mayor a x2 o y2
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getX() > x2 || lista.get(i).getY() > y2){
                lista.remove(i);
                i--;
            }
        }
        //ahora crear nueva imagen
        return new Image_20816739_VeraRamirez(newLargo, newalto, lista, this.tipoPixel);
    }

    /**
     * Metodo que modifica un pixel, cambia el tipo de pixel de RGB a Hex.
     * @param pixel pixel a modificar
     * @return Image
     */
    public Pixel_20816739_VeraRamirez pixRGBToHex(PixelRGB_20816739_VeraRamirez pixel){
        int r = pixel.getRed();
        int g = pixel.getGreen();
        int b = pixel.getBlue();
        String hex;
        hex=String.format("#%02x%02x%02x", r, g, b);
        return new PixelHex_20816739_VeraRamirez(pixel.getX(), pixel.getY(), pixel.getDepth(), hex);
    }

    /**
     * Metodo que modifica todos los pixeles, cambia el tipo de pixel de RGB a Hex.
     * @return Image
     */
    @Override
    public Image_20816739_VeraRamirez imgRGBToHex(){
        List<Pixel_20816739_VeraRamirez> lista = getPixels();
        lista.replaceAll(pixel -> pixRGBToHex((PixelRGB_20816739_VeraRamirez) pixel));
        return new Image_20816739_VeraRamirez(this.largo, this.alto, lista, 2);
    }



    /**
     * Metodo que transforma la informacion a un String
     * @return String
     */
    @Override
    public String toString() {
        return "Image{" +
                "largo=" + largo +
                ", alto=" + alto +
                ", pixels=" + pixels +
                ", tipoPixel=" + tipoPixel +
                '}';
    }
}