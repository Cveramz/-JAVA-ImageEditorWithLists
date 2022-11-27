package org.usach;


import java.util.List;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        //crear objeto de la clase SystemImages
        Sistema_20816739_VeraRamirez systemImages = new Sistema_20816739_VeraRamirez();


        //ahora en adelante viene el menu
        int opcion;
        //mientras que opcion sea mayor a 0 y menor a 4
        //Opciones: 1. Crear imagen, 2. Crear Pixel, 3. Comprobar tipo de imagen, 4. Salir
        do {

            System.out.println("=========MENU=========");
            System.out.println("1. Crear imagen");
            System.out.println("2. Crear Pixel");
            System.out.println("3. Ver lista de images creadas");
            System.out.println("4. Ver lista de pixeles creados");
            System.out.println("5. Comprobar tipo de imagen");
            System.out.println("6. Verificar si imagen es comprimida");
            System.out.println("7. Invertir horizontalmente imagen");
            System.out.println("8. Invertir verticalmente imagen");
            System.out.println("9. Recortar imagen");
            System.out.println("10. Transformar imagen RGB a Hex");
            System.out.println("11. Salir");
            System.out.println("Ingrese una opcion: ");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {
                //===========cASO 1: CREAR IMAGEN================
                case 1:
                    //Crear imagen
                    systemImages.createImage();
                    break;

                //===========cASO 2: CREAR PIXEL================
                case 2:
                    //Crear pixel
                    systemImages.createPixel();
                    break;
                //===========cASO 3: VER LISTA DE IMAGES CREADAS================
                case 3:
                    System.out.println("--------------------");
                    System.out.println("Lista de imagenes creadas: ");
                    if (systemImages.getContieneImagenes() == 0) {
                        System.out.println("No hay imagenes creadas");
                    } else {
                        //mostrar lista de imagenes
                        for (int i = 0; i < systemImages.getImages().size(); i++) {
                            System.out.println("Imagen " + (i + 1) + ": " + systemImages.getImages().get(i).toString());
                        }
                    }
                    System.out.println("--------------------");
                    break;
                //===========cASO 4: VER LISTA DE PIXELES CREADOS================
                case 4:
                    //mostrar lista de pixeles
                    System.out.println("--------------------");
                    System.out.println("Lista de pixeles creados: ");
                    if (systemImages.getContienePixeles() == 0) {
                        System.out.println("No hay pixeles creados");
                    } else {
                        //mostrar lista de pixeles
                        List<Pixel_20816739_VeraRamirez> pixelesCreados = systemImages.getPixeles();
                        for (int i = 0; i < pixelesCreados.size(); i++) {
                            System.out.println("Pixel " + (i + 1) + ": " + pixelesCreados.get(i).toString());
                        }
                    }
                    System.out.println("--------------------");
                    break;
                //===========cASO 5: COMPROBAR TIPO DE IMAGEN================
                case 5:
                    systemImages.checktype();
                    break;
                //===========cASO 6: VERIFICAR SI IMAGEN ES COMPRIMIDA================
                case 6:
                    systemImages.checkCompression();
                    break;
                //===========cASO 7: INVERTIR HORIZONTALMENTE IMAGEN================
                case 7:
                    systemImages.flipHorizontal();
                    break;
                //===========cASO 8: INVERTIR VERTICALMENTE IMAGEN================
                case 8:
                    systemImages.flipVertical();
                    break;
                //===========cASO 9: RECORTAR IMAGEN================
                case 9:
                    systemImages.recortarImagen();
                    break;
                //===========cASO 10: TRANSFORMAR IMAGEN RGB A HEX================
                case 10:
                    systemImages.transformPixmapToHexmap();
                    break;
                //===========cASO 11: SALIR================
                case 11:
                    //Salir
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion != 11);

    }
}