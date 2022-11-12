package org.usach.tda;

import java.util.List;
import java.util.stream.Collectors;


public class Image implements ImageOperations {
    private int largo;
    private int ancho;
    private List<Pixel> pixels;



    public Image(int largo, int ancho, List<Pixel> pixels) {
        this.largo = largo;
        this.ancho = ancho;
        this.pixels = pixels;
    }

    public void crearImagen(){
        //TODO
    }

    //otros
    public void flipH(){
        System.out.println("flipH");
    }
    public void invertColor(){
        System.out.println("invertColor");
    }
    public void crop(int x1,int x2,int y1,int y2){
        System.out.println("crop");
    }


    public int getLargo() {
        return largo;
    }

    public int getAncho() {
        return ancho;
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
    }

    @Override
    public String toString() {
        return "Image{" +
                "largo=" + largo +
                ", ancho=" + ancho +
                ", pixels=" + pixels +
                '}';
    }
}
