package org.usach.tda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        //crear objeto de la clase SystemImages
        SystemImages systemImages = new SystemImages();


        //ahora en adelante viene el menu
        int opcion;
        //mientras que opcion sea mayor a 0 y menor a 4
        //Opciones: 1. Crear imagen, 2. Crear Pixel, 3. Comprobar tipo de imagen, 4. Salir
        do {
            System.out.println("1. Crear imagen");
            System.out.println("2. Crear Pixel");
            System.out.println("3. Ver lista de images creadas");
            System.out.println("4. Comprobar tipo de imagen");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {
                //===========cASO 1: CREAR IMAGEN================
                case 1:
                    //Crear imagen
                    System.out.println("Ingresar el largo de la imagen: ");
                    int largo = sc.nextInt();
                    System.out.println("Ingresar el ancho de la imagen: ");
                    int ancho = sc.nextInt();
                    int cantidadPixeles = largo * ancho;
                    System.out.println("Ingrese tipo de pixeles: ");
                    System.out.println("1. BIT, 2. HEX, 3. RGB");
                    int tipoPixel = sc.nextInt();
                    List<Pixel> pixeles = new ArrayList<>();
                    switch (tipoPixel) {
                        case 1:
                            //BIT
                            for (int i = 0; i < cantidadPixeles; i++) {
                                //informacion que se le pide al usuario:
                                //1. x 2. y 3. depth 4. color
                                System.out.println("Ingrese x: ");
                                int x = sc.nextInt();
                                System.out.println("Ingrese y: ");
                                int y = sc.nextInt();
                                System.out.println("Ingrese depth: ");
                                int depth = sc.nextInt();
                                //mientras bit sea distinto de 0 o 1 preguntar por tipo de bit
                                int bit;
                                do {
                                    System.out.println("Ingrese bit: ");
                                    bit = sc.nextInt();
                                } while (bit != 0 && bit != 1);
                                //crear objeto de la clase PixelBit
                                PixelBit pixelBit = new PixelBit(x, y, depth, bit);
                                //agregar el pixel a la lista de pixeles
                                pixeles.add(pixelBit);
                            }
                            break;
                        case 2:
                            //HEX
                            for (int i = 0; i < cantidadPixeles; i++) {
                                //informacion que se le pide al usuario:
                                //1. x 2. y 3. depth 4. HEXCOLOR
                                System.out.println("Ingrese x: ");
                                int x = sc.nextInt();
                                System.out.println("Ingrese y: ");
                                int y = sc.nextInt();
                                System.out.println("Ingrese depth: ");
                                int depth = sc.nextInt();
                                System.out.println("Ingrese HEX: ");
                                String hex = sc.next();
                                //crear objeto de la clase PixelHex
                                PixelHex pixelHex = new PixelHex(x, y, depth, hex);
                                //agregar el pixel a la lista de pixeles
                                pixeles.add(pixelHex);

                            }
                            break;
                        case 3:
                            //RGB
                            for (int i = 0; i < cantidadPixeles; i++) {
                                //informacion que se le pide al usuario:
                                //1. x 2. y 3. depth 4. RED 5. GREEN 6. BLUE
                                System.out.println("Ingrese x: ");
                                int x = sc.nextInt();
                                System.out.println("Ingrese y: ");
                                int y = sc.nextInt();
                                System.out.println("Ingrese depth: ");
                                int depth = sc.nextInt();
                                //mientras que red, green y blue NO sean mayores a 255 o menores a 0
                                //preguntar por red, green y blue
                                int red, green, blue;
                                do {
                                    System.out.println("Ingrese red: ");
                                    red = sc.nextInt();
                                    System.out.println("Ingrese green: ");
                                    green = sc.nextInt();
                                    System.out.println("Ingrese blue: ");
                                    blue = sc.nextInt();
                                } while (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0);
                                //crear objeto de la clase PixelRGB
                                PixelRGB pixelRGB = new PixelRGB(x, y, depth, red, green, blue);
                                //agregar el pixel a la lista de pixeles
                                pixeles.add(pixelRGB);
                            }
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                    //crear objeto de la clase Image
                    Image image = new Image(largo, ancho, pixeles);
                    //agregar la imagen a la lista de imagenes
                    systemImages.addImage(image);
                    break;







                //===========cASO 2: CREAR PIXEL================
                case 2:
                    //Crear pixel
                    break;
                //===========cASO 3: VER LISTA DE IMAGES CREADAS================
                case 3:
                    System.out.println("--------------------");
                    System.out.println("Lista de imagenes creadas: ");
                    if (systemImages.getContieneImagenes() == 0) {
                        System.out.println("No hay imagenes creadas");
                    } else {
                        //mostrar lista de imagenes
                        systemImages.getImages();
                    }
                    System.out.println("--------------------");
                    break;
                //===========cASO 4: COMPROBAR TIPO DE IMAGEN================
                case 4:
                    //Comprobar tipo de imagen
                    break;
                //===========cASO 5: SALIR================
                case 5:
                    //Salir
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion > 0 && opcion < 4);

    }
}