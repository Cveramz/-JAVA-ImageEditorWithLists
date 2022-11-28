package org.usach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa el sistema en donde se almacenan las imagenes y pixeles
 * @author Carlos Vera Ramirez
 * @version 1.0
 * @since 2022-11-06
 */

public class Sistema_20816739_VeraRamirez {
    private int contieneImagenes;
    private int contienePixeles;
    private List<Image_20816739_VeraRamirez> images;
    private List<Pixel_20816739_VeraRamirez> pixeles;

    /**
     * Constructor de la clase Sistema
     */
    public Sistema_20816739_VeraRamirez() {
        this.contieneImagenes = 0;
        this.contienePixeles = 0;
        this.images = new ArrayList<>();
        this.pixeles = new ArrayList<>();
    }

    /**
     * Metodo que permite crear una lista de pixeles
     * @param cantidadPixeles Cantidad de pixeles que se desea crear
     * @return Retorna la lista de pixeles creada (List<Pixel>)
     */
    public List<Pixel_20816739_VeraRamirez> crearListaDePixeles(int cantidadPixeles){
        Scanner sc = new Scanner(System.in);
        List<Pixel_20816739_VeraRamirez> pixeles = new ArrayList<>();
        System.out.println("¿Que tipo de pixeles desea crear? 1. Bit 2. Hex 3. RGB");
        int tipoPixel = sc.nextInt();
        System.out.println("***Aviso: Para un correcto funcionamiento del programa:***");
        System.out.println("-Las coordenadas de los pixeles deben ser ingresados en orden");
        System.out.println("- - - Considerando de derecha a izquierda y de arriba hacia abajo - - -");
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


    /**
     * Metodo que permite crear una lista de pixeles de tipo Bit
     * @param cantidadPixeles Cantidad de pixeles que se desea crear
     * @return Retorna la lista de pixeles creada (List<Pixel>)
     */
    public List<Pixel_20816739_VeraRamirez> crearListaDePixelesBit(int cantidadPixeles) {
        Scanner sc = new Scanner(System.in);
        List<Pixel_20816739_VeraRamirez> pixeles = new ArrayList<>();
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
            Pixel_20816739_VeraRamirez pixel = new PixelBit_20816739_VeraRamirez(x, y, depth, bit);
            pixeles.add(pixel);
        }
        return pixeles;
    }

    /**
     * Metodo que permite crear una lista de pixeles de tipo Hex
     * @param cantidadPixeles Cantidad de pixeles que se desea crear
     * @return Retorna la lista de pixeles creada (List<Pixel>)
     */
    public List<Pixel_20816739_VeraRamirez> crearListaDePixelesHex(int cantidadPixeles) {
        Scanner sc = new Scanner(System.in);
        List<Pixel_20816739_VeraRamirez> pixeles = new ArrayList<>();
        for (int i = 0; i < cantidadPixeles; i++) {
            System.out.println("Ingrese el valor X del pixel " + (i + 1));
            int x = sc.nextInt();
            System.out.println("Ingrese el valor Y del pixel " + (i + 1));
            int y = sc.nextInt();
            System.out.println("Ingrese el valor Depth del pixel " + (i + 1));
            int depth = sc.nextInt();
            System.out.println("Ingrese el valor Hexadecimal del pixel " + (i + 1));
            String hex = sc.next();
            Pixel_20816739_VeraRamirez pixel = new PixelHex_20816739_VeraRamirez(x, y, depth, hex);
            pixeles.add(pixel);
        }
        return pixeles;
    }

    /**
     * Metodo que permite crear una lista de pixeles de tipo RGB
     * @param cantidadPixeles Cantidad de pixeles que se desea crear
     * @return Retorna la lista de pixeles creada (List<Pixel>)
     */
    public List<Pixel_20816739_VeraRamirez> crearListaDePixelesRGB(int cantidadPixeles) {
        Scanner sc = new Scanner(System.in);
        List<Pixel_20816739_VeraRamirez> pixeles = new ArrayList<>();
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
            Pixel_20816739_VeraRamirez pixel = new PixelRGB_20816739_VeraRamirez(x, y, depth, r, g, b);
            pixeles.add(pixel);
        }
        return pixeles;
    }

    /**
     * Metodo que permite crear una imagen solicitando informacion al usuario
     */
    public void createImage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Crear imagen");
        System.out.println("Ingrese el largo de la imagen: ");
        int largo = sc.nextInt();
        System.out.println("Ingrese el ancho de la imagen: ");
        int ancho = sc.nextInt();
        List<Pixel_20816739_VeraRamirez> pixeles = new ArrayList<>();
        int cantidadPixeles = largo * ancho;
        System.out.println("CREACION DE PIXELES");
        pixeles = crearListaDePixeles(cantidadPixeles);
        int tipoDePixel;
        //verificar tipo de pixel creado
        if(pixeles.get(0) instanceof PixelBit_20816739_VeraRamirez){
            tipoDePixel = 1;
        }else if(pixeles.get(0) instanceof PixelHex_20816739_VeraRamirez){
            tipoDePixel = 2;
        }else{
            tipoDePixel = 3;
        }

        Image_20816739_VeraRamirez image = new Image_20816739_VeraRamirez(largo, ancho, pixeles, tipoDePixel);
        System.out.println("====IMAGEN CREADA====");
        System.out.println("Consejo: Para ver la imagen creada, en menu principal seleccione la opcion 3");
        addImage(image);
        this.contieneImagenes++;
    }

    /**
     * Metodo que permite agregar 3 imagenes predeterminadas al inicio del programa.
     */
    public void crearImagenesPredeterminadas(){
        List<Pixel_20816739_VeraRamirez> pixeles = new ArrayList<>();
        pixeles.add(new PixelBit_20816739_VeraRamirez(0, 0, 10, 1));
        pixeles.add(new PixelBit_20816739_VeraRamirez(1, 0, 1, 0));
        pixeles.add(new PixelBit_20816739_VeraRamirez(0, 1, 1, 0));
        pixeles.add(new PixelBit_20816739_VeraRamirez(1, 1, 1, 1));
        Image_20816739_VeraRamirez image = new Image_20816739_VeraRamirez(2, 2, pixeles, 1);
        addImage(image);
        pixeles = new ArrayList<>();
        pixeles.add(new PixelHex_20816739_VeraRamirez(2, 2, 1, "FF0F0F"));
        pixeles.add(new PixelHex_20816739_VeraRamirez(3, 2, 1, "00F0F0"));
        pixeles.add(new PixelHex_20816739_VeraRamirez(2, 3, 1, "0F0F0F"));
        pixeles.add(new PixelHex_20816739_VeraRamirez(3, 3, 1, "FFF000"));
        image = new Image_20816739_VeraRamirez(2, 2, pixeles, 2);
        addImage(image);
        pixeles = new ArrayList<>();
        pixeles.add(new PixelRGB_20816739_VeraRamirez(5,5, 1, 255, 255, 255));
        pixeles.add(new PixelRGB_20816739_VeraRamirez(10, 5, 1, 0, 0, 0));
        pixeles.add(new PixelRGB_20816739_VeraRamirez(5, 10, 1, 0, 255, 0));
        pixeles.add(new PixelRGB_20816739_VeraRamirez(10, 10, 1, 255, 255, 255));
        image = new Image_20816739_VeraRamirez(2, 2, pixeles, 3);
        addImage(image);
        this.contieneImagenes = 3;
    }

    /**
     * Metodo que permite crear una imagen solicitando informacion al usuario
     */
    public void createPixel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Crear pixel");
        System.out.println("¿Que tipo de pixel desea crear? 1. Bit 2. Hex 3. RGB");
        int tipoPixel = sc.nextInt();
        switch(tipoPixel){
            case 1:
                List<Pixel_20816739_VeraRamirez> pixeles = new ArrayList<>();
                pixeles = crearListaDePixelesBit(1);
                Pixel_20816739_VeraRamirez pixel = pixeles.get(0);
                addPixel(pixel);
                break;
            case 2:
                List<Pixel_20816739_VeraRamirez> pixeles2 = new ArrayList<>();
                pixeles2 = crearListaDePixelesHex(1);
                Pixel_20816739_VeraRamirez pixel2 = pixeles2.get(0);
                addPixel(pixel2);
                break;
            case 3:
                List<Pixel_20816739_VeraRamirez> pixeles3 = new ArrayList<>();
                pixeles3 = crearListaDePixelesRGB(1);
                Pixel_20816739_VeraRamirez pixel3 = pixeles3.get(0);
                addPixel(pixel3);
                break;
        }
        System.out.println("Consejo: Para ver el pixel creado, en menu principal seleccione la opcion 4");
    }

    /**
     * Metodo que permite verificar el tipo de imagen
     */
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
            Image_20816739_VeraRamirez image = getImages().get(opcion - 1);
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

    /**
     * Metodo que permite verificar si una imagen es de tipo Bitmap
     * @param image
     * @return boolean
     */
    public boolean isBitmap(Image_20816739_VeraRamirez image){
        return image.isBitmap();
    }

    /**
     * Metodo que permite verificar si una imagen es de tipo Pixmap
     * @param image
     * @return boolean
     */
    public boolean isPixmap(Image_20816739_VeraRamirez image){
        return image.isPixmap();
    }

    /**
     * Metodo que permite verificar si una imagen es de tipo Hexmap
     * @param image
     * @return boolean
     */
    public boolean isHexmap(Image_20816739_VeraRamirez image){
        return image.isHexmap();
    }

    /**
     * Metodo que permite agregar una imagen a la lista de imagenes
     * @param image
     */
    public void addImage(Image_20816739_VeraRamirez image){
        this.images.add(image);
    }

    /**
     * Metodo que permite verificar la compresion de una imagen que seleccione dentro el usuario
     */
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
            Image_20816739_VeraRamirez image = getImages().get(opcion - 1);
            if(image.isCompressed()){
                System.out.println("La imagen esta comprimida");
            }else{
                System.out.println("La imagen no esta comprimida");
            }
        }

    }

    /**
     * Metodo que permite agregar un pixel al listado de pixeles
     * @param pixel
     */
    public void addPixel(Pixel_20816739_VeraRamirez pixel){
        this.pixeles.add(pixel);
        this.contienePixeles++;
    }


    /**
     * Metodo que permite realizar un flip horizontal a una imagen que el usuario seleccione
     */
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
            Image_20816739_VeraRamirez image = getImages().get(opcion - 1);
            Image_20816739_VeraRamirez newImage = image.flipH();
            //reemplazar imagen por la nueva
            this.images.set(opcion - 1, newImage);
            System.out.println("Imagen volteada horizontalmente");
            System.out.println("Consejo: Para ver la imagen invertida, en menu principal seleccione la opcion 3");
            System.out.println("--------------------");
        }
    }

    /**
     * Metodo que permite realizar un flip vertical a una imagen que el usuario seleccione
     */
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
            Image_20816739_VeraRamirez image = getImages().get(opcion - 1);
            Image_20816739_VeraRamirez newImage = image.flipV();
            //reemplazar imagen por la nueva
            this.images.set(opcion - 1, newImage);
            System.out.println("Imagen volteada verticalmente");
            System.out.println("Consejo: Para ver la imagen invertida, en menu principal seleccione la opcion 3");
            System.out.println("--------------------");
        }
    }

    /**
     * Metodo que permite recortar una imagen seleccionada
     */
    public void recortarImagen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Recortar imagen");
        if (this.contieneImagenes == 0) {
            System.out.println("No hay imagenes creadas");
            System.out.println("--------------------");
        } else {
            System.out.println("Seleccione una de las imagenes creadas: ");
            for (int i = 0; i < getImages().size(); i++) {
                System.out.println("Imagen " + (i + 1) + ": " + getImages().get(i).toString());
            }
            int opcion = sc.nextInt();
            Image_20816739_VeraRamirez image = getImages().get(opcion - 1);
            int x1, y1, x2, y2;
            System.out.println("Ingrese limite superior izquierdo (X1): ");
            x1 = sc.nextInt();
            System.out.println("Ingrese limite superior izquierdo (Y1): ");
            y1 = sc.nextInt();
            System.out.println("Ingrese limite inferior derecho (X2): ");
            x2 = sc.nextInt();
            System.out.println("Ingrese limite inferior derecho (Y2): ");
            y2 = sc.nextInt();
            Image_20816739_VeraRamirez newImage = image.crop(x1, y1, x2, y2);
            System.out.println("Imagen recortada correctamente");
            System.out.println("Consejo: Para ver la imagen recortada, en menu principal seleccione la opcion 3");
            //reemplazar imagen por la nueva
            this.images.set(opcion - 1, newImage);
            System.out.println("--------------------");
        }


    }

    /**
     * Metodo que permite transformar un pixmap a un hexmap seleccionado.
     */
    public void transformPixmapToHexmap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Convertir imagen RGB a HEX");
        if (this.contieneImagenes == 0) {
            System.out.println("No hay imagenes creadas");
            System.out.println("--------------------");
        } else {
            System.out.println("Seleccione una de las imagenes creadas: ");
            for (int i = 0; i < getImages().size(); i++) {
                System.out.println("Imagen " + (i + 1) + ": " + getImages().get(i).toString());
            }
            int opcion = sc.nextInt();
            Image_20816739_VeraRamirez image = getImages().get(opcion - 1);
            if(image.getTipoPixel() == 1){
                System.out.println("La imagen es tipo Bitmap");
                System.out.println("Para utilizar esta funcion, la imagen debe ser tipo RGB");
                //si tipopixel == 2, la imagen ya es tipo hexmap, por lo tanto no se puede convertir
            }else if(image.getTipoPixel() == 2){
                System.out.println("La imagen ya es tipo Hexmap");
                System.out.println("Para utilizar esta funcion, la imagen debe ser tipo RGB");
            }else{
                Image_20816739_VeraRamirez newImage = image.imgRGBToHex();
                System.out.println("Imagen convertida correctamente");
                System.out.println("Consejo: Para ver la imagen convertida, en menu principal seleccione la opcion 3");
                //reemplazar imagen por la nueva
                this.images.set(opcion - 1, newImage);
            }
            System.out.println("--------------------");
        }
    }



    //---------OTRAS FUNCIONES-------------

    /**
     * Metodo que retorna el numero que confirma si tiene imagenes o no.
     * @return contieneImagenes (int)
     */
    public int getContieneImagenes() {
        return contieneImagenes;
    }

    /**
     * Metodo que permite modificar el numero que confirma si tiene imagenes o no.
     * @param contieneImagenes (int)
     */
    public void setContieneImagenes(int contieneImagenes) {
        this.contieneImagenes = contieneImagenes;
    }

    /**
     * Metodo que retorna el numero que confirma si tiene pixeles o no.
     * @return contienePixeles (int)
     */
    public int getContienePixeles() {
        return contienePixeles;
    }

    /**
     * Metodo que permite modificar el numero que confirma si tiene pixeles o no.
     * @param contienePixeles (int)
     */
    public void setContienePixeles(int contienePixeles) {
        this.contienePixeles = contienePixeles;
    }

    /**
     * Metodos que retorna las imagenes creadas por el usuario.
     * @return images (List<Image>)
     */
    public List<Image_20816739_VeraRamirez> getImages() {
        return images;
    }

    /**
     * Metodo que permite modificar las imagenes creadas por el usuario.
     * @param images (List<Image>)
     */
    public void setImages(List<Image_20816739_VeraRamirez> images) {
        this.images = images;
    }

    /**
     * Metodo que retorna los pixeles creados por el usuario.
     * @return pixels (List<Pixel>)
     */
    public List<Pixel_20816739_VeraRamirez> getPixeles() {
        return pixeles;
    }

    /**
     * Metodo que permite modificar los pixeles creados por el usuario.
     * @param pixeles (List<Pixel>)
     */
    public void setPixeles(List<Pixel_20816739_VeraRamirez> pixeles) {
        this.pixeles = pixeles;
    }

    /**
     * Metodo que transforma la informacion a un String
     * @return String
     */
    @Override
    public String toString() {
        return "SystemImages{" +
                "images=" + images +
                ", pixeles=" + pixeles +
                '}';
    }
}

