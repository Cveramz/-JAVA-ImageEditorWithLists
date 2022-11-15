package org.usach.tda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SystemImages {
    private int contieneImagenes;
    private int contienePixeles;
    private List<Image> images;
    private List<Pixel> pixeles;

    public SystemImages() {
        this.contieneImagenes = 0;
        this.contienePixeles = 0;
    }

    //funcion para crear una lista de pixeles
    public List<Pixel> crearListaDePixeles(int cantidadPixeles){
        Scanner sc = new Scanner(System.in);
        List<Pixel> pixeles = new ArrayList<>();
        System.out.println("¿Que tipo de pixeles desea crear? 1. Bit 2. Hex 3. RGB");
        int tipoPixel = sc.nextInt();
        switch(tipoPixel){
            case 1:
                pixeles = crearListaDePixelesBit(cantidadPixeles);
                break;
            case 2:
                pixeles = crearListaDePixelesHex(cantidadPixeles);
                break;
            case 3:
                pixeles = crearListaDePixelesRGB(cantidadPixeles);
                break;
        }
        return pixeles;
    }


    //funcion para crear lista de pixeles tipo bit
    public List<Pixel> crearListaDePixelesBit(int cantidadPixeles) {
        Scanner sc = new Scanner(System.in);
        List<Pixel> pixeles = new ArrayList<Pixel>();
        for (int i = 0; i < cantidadPixeles; i++) {
            System.out.println("Ingrese el valor X del pixel " + (i + 1));
            int x = sc.nextInt();
            System.out.println("Ingrese el valor Y del pixel " + (i + 1));
            int y = sc.nextInt();
            System.out.println("Ingrese el valor Depth del pixel " + (i + 1));
            int depth = sc.nextInt();
            System.out.println("Ingrese el valor Bit del pixel " + (i + 1));
            int bit = sc.nextInt();
            Pixel pixel = new PixelBit(x, y, depth, bit);
            pixeles.add(pixel);
        }
        return pixeles;
    }

    //funcion para crear lista de pixeles tipo HEX
    public List<Pixel> crearListaDePixelesHex(int cantidadPixeles) {
        Scanner sc = new Scanner(System.in);
        List<Pixel> pixeles = new ArrayList<Pixel>();
        for (int i = 0; i < cantidadPixeles; i++) {
            System.out.println("Ingrese el valor X del pixel " + (i + 1));
            int x = sc.nextInt();
            System.out.println("Ingrese el valor Y del pixel " + (i + 1));
            int y = sc.nextInt();
            System.out.println("Ingrese el valor Depth del pixel " + (i + 1));
            int depth = sc.nextInt();
            System.out.println("Ingrese el valor Hexadecimal del pixel " + (i + 1));
            String hex = sc.next();
            Pixel pixel = new PixelHex(x, y, depth, hex);
            pixeles.add(pixel);
        }
        return pixeles;
    }

    //funcion para crear lista de pixeles tipo RGB
    public List<Pixel> crearListaDePixelesRGB(int cantidadPixeles) {
        Scanner sc = new Scanner(System.in);
        List<Pixel> pixeles = new ArrayList<Pixel>();
        for (int i = 0; i < cantidadPixeles; i++) {
            System.out.println("Ingrese el valor X del pixel " + (i + 1));
            int x = sc.nextInt();
            System.out.println("Ingrese el valor Y del pixel " + (i + 1));
            int y = sc.nextInt();
            System.out.println("Ingrese el valor Depth del pixel " + (i + 1));
            int depth = sc.nextInt();
            System.out.println("Ingrese el valor R del pixel " + (i + 1));
            int r = sc.nextInt();
            System.out.println("Ingrese el valor G del pixel " + (i + 1));
            int g = sc.nextInt();
            System.out.println("Ingrese el valor B del pixel " + (i + 1));
            int b = sc.nextInt();
            Pixel pixel = new PixelRGB(x, y, depth, r, g, b);
            pixeles.add(pixel);
        }
        return pixeles;
    }

    public void createImage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Crear imagen");
        System.out.println("Ingrese el largo de la imagen: ");
        int largo = sc.nextInt();
        System.out.println("Ingrese el ancho de la imagen: ");
        int ancho = sc.nextInt();
        List<Pixel> pixeles = new ArrayList<>();
        int cantidadPixeles = largo * ancho;
        System.out.println("CREACION DE PIXELES");
        pixeles = crearListaDePixeles(cantidadPixeles);
        System.out.println("====PIXELES CREADOS====");
        Image image = new Image(largo, ancho, pixeles);
        System.out.println("====IMAGEN CREADA====");
        addImage(image);
        this.contieneImagenes++;
    }



    public void addImage(Image image){
        List<Image> aux = new ArrayList<>();
        aux.add(image);
        this.images = aux;

    }
    public void addPixel(Pixel pixel){
        this.pixeles.add(pixel);
        this.contienePixeles++;
    }

    /*public void removeImage(){
        System.out.println("Remove Image");
    }

    public void removePixel(){
        System.out.println("Remove Pixel");
    }*/

    public void replaceImage(){
        System.out.println("Replace Image");
    }

    public void replacePixel(){
        System.out.println("Replace Pixel");
    }

    public int getContieneImagenes() {
        return contieneImagenes;
    }

    public void setContieneImagenes(int contieneImagenes) {
        this.contieneImagenes = contieneImagenes;
    }

    public int getContienePixeles() {
        return contienePixeles;
    }

    public void setContienePixeles(int contienePixeles) {
        this.contienePixeles = contienePixeles;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Pixel> getPixeles() {
        return pixeles;
    }

    public void setPixeles(List<Pixel> pixeles) {
        this.pixeles = pixeles;
    }

    @Override
    public String toString() {
        return "SystemImages{" +
                "images=" + images +
                ", pixeles=" + pixeles +
                '}';
    }
}

