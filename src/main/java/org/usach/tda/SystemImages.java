package org.usach.tda;

import java.util.List;


public class SystemImages {
    private int contieneImagenes;
    private int contienePixeles;
    private List<Image> images;
    private List<Pixel> pixeles;

    public SystemImages() {
        this.contieneImagenes = 0;
        this.contienePixeles = 0;
    }


    public void addImage(Image image){
        images.add(image);
    }

    public void addPixel(Pixel pixel){
        pixeles.add(pixel);
    }

    public void removeImage(){
        System.out.println("Remove Image");
    }

    public void removePixel(){
        System.out.println("Remove Pixel");
    }

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

