package org.usach;

import java.util.List;

import java.util.Collections;




public class Image implements ImageOperations {
    private int largo;
    private int alto;
    private List<Pixel> pixels;
    private int tipoPixel; //1. Bit 2. Hex 3. RGB



    public Image(int largo, int alto, List<Pixel> pixels, int tipoPixel) {
        this.largo = largo;
        this.alto = alto;
        this.pixels = pixels;
        this.tipoPixel = tipoPixel;

    }

    @Override
    public boolean isBitmap() {
        if (tipoPixel == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean isHexmap() {
        if (tipoPixel == 2) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean isPixmap() {
        if (tipoPixel == 3) {
            return true;
        } else {
            return false;
        }
    }


    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getalto() {
        return alto;
    }

    public void setalto(int alto) {
        this.alto = alto;
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
    @Override
    public boolean isCompressed(){
        return this.largo * this.alto > this.pixels.size();
    }
    @Override
    public Image flipH(){
        //crear matriz de pixeles
        Pixel[][] matriz = new Pixel[this.alto][this.largo];
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
                Pixel aux = matriz[i][j];
                matriz[i][j] = matriz[i][this.largo - j - 1];
                matriz[i][this.largo - j - 1] = aux;
            }
        }
        //ahora debemos pasar la matriz a una lista de pixeles
        List<Pixel> lista = this.pixels;
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
        return new Image(this.largo,this.alto,lista,this.tipoPixel);
    }
    @Override
    public Image flipV(){
        //para invertir una imagen verticalmente, podemos simplemente invertir
        //la lista resultante del metodo flipH
        List<Pixel> lista = this.flipH().getPixels();
        Collections.reverse(lista);
        //ahora arreglar las coordenadas Y de los pixeles
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setY(i / this.largo);
        }
        return new Image(this.largo, this.alto,lista, this.tipoPixel);
    }

    //funcion para recortar una imagen
    @Override
    public Image crop(int x1, int y1, int x2, int y2){
        List<Pixel> lista = getPixels();
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
        return new Image(newLargo, newalto, lista, this.tipoPixel);
    }

    //funcion para transformar un pixel tipo RGB a un pixel tipo Hex
    public Pixel pixRGBToHex(PixelRGB pixel){
        int r = pixel.getRed();
        int g = pixel.getGreen();
        int b = pixel.getBlue();
        String hex;
        hex=String.format("#%02x%02x%02x", r, g, b);
        return new PixelHex(pixel.getX(), pixel.getY(), pixel.getDepth(), hex);
    }
    @Override
    public Image imgRGBToHex(){
        List<Pixel> lista = getPixels();
        lista.replaceAll(pixel -> pixRGBToHex((PixelRGB) pixel));
        return new Image(this.largo, this.alto, lista, 2);
    }



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