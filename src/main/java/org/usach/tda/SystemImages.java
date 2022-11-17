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
        this.images = new ArrayList<>();
        this.pixeles = new ArrayList<>();
    }

    //funcion para crear una lista de pixeles
    public List<Pixel> crearListaDePixeles(int cantidadPixeles){
        Scanner sc = new Scanner(System.in);
        List<Pixel> pixeles = new ArrayList<>();
        System.out.println("¿Que tipo de pixeles desea crear? 1. Bit 2. Hex 3. RGB");
        int tipoPixel = sc.nextInt();
        System.out.println("***Aviso: Para un correcto funcionamiento del programa:***");
        System.out.println("-Las coordenadas de los pixeles deben ser ingresados en orden");
        System.out.println("-No se pueden repetir las coordenadas de los pixeles");
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
        List<Pixel> pixeles = new ArrayList<>();
        for (int i = 0; i < cantidadPixeles; i++) {
            System.out.println("Ingrese el valor X del pixel " + (i + 1));
            int x = sc.nextInt();
            System.out.println("Ingrese el valor Y del pixel " + (i + 1));
            int y = sc.nextInt();
            System.out.println("Ingrese el valor Depth del pixel " + (i + 1));
            int depth = sc.nextInt();
            int bit;
            //mientras bit sea distinto de 0 o 1
            do {
                System.out.println("Ingrese el valor Bit del pixel " + (i + 1));
                System.out.println("***Recuerde que el valor Bit debe ser 0 o 1***");
                bit = sc.nextInt();
            } while (bit != 0 && bit != 1);
            Pixel pixel = new PixelBit(x, y, depth, bit);
            pixeles.add(pixel);
        }
        return pixeles;
    }

    //funcion para crear lista de pixeles tipo HEX
    public List<Pixel> crearListaDePixelesHex(int cantidadPixeles) {
        Scanner sc = new Scanner(System.in);
        List<Pixel> pixeles = new ArrayList<>();
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
        List<Pixel> pixeles = new ArrayList<>();
        for (int i = 0; i < cantidadPixeles; i++) {
            System.out.println("Ingrese el valor X del pixel " + (i + 1));
            int x = sc.nextInt();
            System.out.println("Ingrese el valor Y del pixel " + (i + 1));
            int y = sc.nextInt();
            System.out.println("Ingrese el valor Depth del pixel " + (i + 1));
            int depth = sc.nextInt();
            //mientras red sea menor a 0 o mayor a 255
            int r;
            do {
                System.out.println("Ingrese el valor Red del pixel " + (i + 1));
                System.out.println("***Recuerde que el valor Red debe estar entre 0 y 255***");
                r = sc.nextInt();
            } while (r < 0 || r > 255);
            //mientras green sea menor a 0 o mayor a 255
            int g;
            do {
                System.out.println("Ingrese el valor Green del pixel " + (i + 1));
                System.out.println("***Recuerde que el valor Green debe estar entre 0 y 255***");
                g = sc.nextInt();
            } while (g < 0 || g > 255);
            //mientras blue sea menor a 0 o mayor a 255
            int b;
            do {
                System.out.println("Ingrese el valor Blue del pixel " + (i + 1));
                System.out.println("***Recuerde que el valor Blue debe estar entre 0 y 255***");
                b = sc.nextInt();
            } while (b < 0 || b > 255);
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
        int tipoDePixel;
        //verificar tipo de pixel creado
        if(pixeles.get(0) instanceof PixelBit){
            tipoDePixel = 1;
        }else if(pixeles.get(0) instanceof PixelHex){
            tipoDePixel = 2;
        }else{
            tipoDePixel = 3;
        }

        Image image = new Image(largo, ancho, pixeles, tipoDePixel);
        System.out.println("====IMAGEN CREADA====");
        System.out.println("Consejo: Para ver la imagen creada, en menu principal seleccione la opcion 3");
        addImage(image);
        this.contieneImagenes++;
    }

    public void createPixel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Crear pixel");
        System.out.println("¿Que tipo de pixel desea crear? 1. Bit 2. Hex 3. RGB");
        int tipoPixel = sc.nextInt();
        switch(tipoPixel){
            case 1:
                List<Pixel> pixeles = new ArrayList<>();
                pixeles = crearListaDePixelesBit(1);
                Pixel pixel = pixeles.get(0);
                addPixel(pixel);
                break;
            case 2:
                List<Pixel> pixeles2 = new ArrayList<>();
                pixeles2 = crearListaDePixelesHex(1);
                Pixel pixel2 = pixeles2.get(0);
                addPixel(pixel2);
                break;
            case 3:
                List<Pixel> pixeles3 = new ArrayList<>();
                pixeles3 = crearListaDePixelesRGB(1);
                Pixel pixel3 = pixeles3.get(0);
                addPixel(pixel3);
                break;
        }
        System.out.println("Consejo: Para ver el pixel creado, en menu principal seleccione la opcion 4");
    }
    public void checktype(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        if (this.contieneImagenes == 0) {
            System.out.println("No hay imagenes creadas");
            System.out.println("--------------------");
        } else {
            System.out.println("Seleccione una de las imagenes creadas: ");
            for (int i = 0; i < getImages().size(); i++) {
                System.out.println("Imagen " + (i + 1) + ": " + getImages().get(i).toString());
            }
            int opcion = sc.nextInt();
            Image image = getImages().get(opcion - 1);
            //confirmacion de tipo de pixel
            System.out.println("Elija un tipo de verificacion: ");
            System.out.println("1. Verificar imagen tipo Bitmap");//bit
            System.out.println("2. Verificar imagen tipo Pixmap");//RGB
            System.out.println("3. Verificar imagen tipo Hexmap");//Hex
            int opcion2 = sc.nextInt();
            switch (opcion2) {
                case 1:
                    if (isBitmap(image)) {
                        System.out.println("La imagen efectivamente es de tipo Bitmap");
                    } else {
                        System.out.println("La imagen no es de tipo Bitmap");
                    }
                    break;
                case 2:
                    if (isPixmap(image)) {
                        System.out.println("La imagen efectivamente es de tipo Pixmap");
                    } else {
                        System.out.println("La imagen no es de tipo Pixmap");
                    }
                    break;
                case 3:
                    if (isHexmap(image)) {
                        System.out.println("La imagen efectivamente es de tipo Hexmap");
                    } else {
                        System.out.println("La imagen no es de tipo Hexmap");
                    }
                    break;
            }
        }
    }

    public boolean isBitmap(Image image){
        return image.getTipoPixel() == 1;
    }

    public boolean isPixmap(Image image){
        return image.getTipoPixel() == 3;
    }

    public boolean isHexmap(Image image){
        return image.getTipoPixel() == 2;
    }

    public void addImage(Image image){
        this.images.add(image);
    }
    /*public void addImage(Image image){
        List<Image> aux = new ArrayList<>();
        aux.add(image);
        this.images = aux;

    }*/


    public void checkCompression(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Verificar si una imagen esta comprimida");
        if (this.contieneImagenes == 0) {
            System.out.println("No hay imagenes creadas");
            System.out.println("--------------------");
        } else {
            System.out.println("Seleccione una de las imagenes creadas: ");
            for (int i = 0; i < getImages().size(); i++) {
                System.out.println("Imagen " + (i + 1) + ": " + getImages().get(i).toString());
            }
            int opcion = sc.nextInt();
            Image image = getImages().get(opcion - 1);
            if(image.isCompressed()){
                System.out.println("La imagen esta comprimida");
            }else{
                System.out.println("La imagen no esta comprimida");
            }
        }

    }

    public void addPixel(Pixel pixel){
        this.pixeles.add(pixel);
        this.contienePixeles++;
    }

    public void addPixel(Pixel pixel, int index){
        this.pixeles.add(index, pixel);
        this.contienePixeles++;
    }


    public void flipHorizontal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Voltear imagen horizontalmente");
        if (this.contieneImagenes == 0) {
            System.out.println("No hay imagenes creadas");
            System.out.println("--------------------");
        } else {
            System.out.println("Seleccione una de las imagenes creadas: ");
            for (int i = 0; i < getImages().size(); i++) {
                System.out.println("Imagen " + (i + 1) + ": " + getImages().get(i).toString());
            }
            int opcion = sc.nextInt();
            Image image = getImages().get(opcion - 1);
            Image newImage = image.flipH();
            //mostrar en pantalla la nueva imagen
            System.out.println("Imagen NUEVA: ");
            System.out.println(newImage.toString());
            System.out.println("=====");
            //reemplazar imagen por la nueva
            this.images.set(opcion - 1, newImage);
            System.out.println("Imagen volteada horizontalmente");
        }
    }

    public void flipVertical(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Voltear imagen verticalmente");
        if (this.contieneImagenes == 0) {
            System.out.println("No hay imagenes creadas");
            System.out.println("--------------------");
        } else {
            System.out.println("Seleccione una de las imagenes creadas: ");
            for (int i = 0; i < getImages().size(); i++) {
                System.out.println("Imagen " + (i + 1) + ": " + getImages().get(i).toString());
            }
            int opcion = sc.nextInt();
            Image image = getImages().get(opcion - 1);
            Image newImage = image.flipV();
            //mostrar en pantalla la nueva imagen
            System.out.println("Imagen NUEVA: ");
            System.out.println(newImage.toString());
            System.out.println("=====");
            //reemplazar imagen por la nueva
            this.images.set(opcion - 1, newImage);
            System.out.println("Imagen volteada verticalmente");
        }
    }



    //---------OTRAS FUNCIONES-------------

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

