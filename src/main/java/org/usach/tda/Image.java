package org.usach.tda;

import java.util.List;

import java.util.Collections;


public class Image implements ImageOperations {
    private int largo;
    private int ancho;
    private List<Pixel> pixels;
    private int tipoPixel; //1. Bit 2. Hex 3. RGB


    public Image(int largo, int ancho, List<Pixel> pixels, int tipoPixel) {
        this.largo = largo;
        this.ancho = ancho;
        this.pixels = pixels;
        this.tipoPixel = tipoPixel;
    }


    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
    }

    public int getTipoPixel() {
        return tipoPixel;
    }

    public void setTipoPixel(int tipoPixel) {
        this.tipoPixel = tipoPixel;
    }

    public boolean isCompressed(){
        return this.largo * this.ancho > this.pixels.size();
    }

    public Image flipH(){
        //crear matriz de pixeles
        Pixel[][] matriz = new Pixel[this.ancho][this.largo];
        int cont = 0;
        //primero rellenamos la matriz con los pixeles
        for (int i = 0; i < this.ancho; i++) {
            for (int j = 0; j < this.largo; j++) {
                matriz[i][j] = this.pixels.get(cont);
                cont++;
            }
        }
        //ahora debemos ir invirtiendo fila por fila
        for (int i = 0; i < this.ancho; i++) {
            for (int j = 0; j < this.largo/2; j++) {
                Pixel aux = matriz[i][j];
                matriz[i][j] = matriz[i][this.largo - j - 1];
                matriz[i][this.largo - j - 1] = aux;
            }
        }
        //ahora debemos pasar la matriz a una lista de pixeles
        List<Pixel> lista = this.pixels;
        cont = 0;
        for (int i = 0; i < this.ancho; i++) {
            for (int j = 0; j < this.largo; j++) {
                lista.set(cont,matriz[i][j]);
                cont++;
            }
        }
        //ahora debemos crear la nueva imagen
        return new Image(this.largo, this.ancho,lista, this.tipoPixel);
    }

    public Image flipV(){
        //para invertir una imagen verticalmente, podemos simplemente invertir
        //la lista resultante del metodo flipH
        List<Pixel> lista = this.flipH().getPixels();
        Collections.reverse(lista);
        return new Image(this.largo, this.ancho,lista, this.tipoPixel);
    }
    @Override
    public String toString() {
        return "Image{" +
                "largo=" + largo +
                ", ancho=" + ancho +
                ", pixels=" + pixels +
                ", tipoPixel=" + tipoPixel +
                '}';
    }
}