package org.usach.tda;


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
            System.out.println("4. Ver lista de pixeles creados");
            System.out.println("5. Comprobar tipo de imagen");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion: ");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {
                //===========cASO 1: CREAR IMAGEN================
                case 1:
                    //Crear imagen

                //===========cASO 2: CREAR PIXEL================
                case 2:
                    //Crear pixel
                    System.out.println("Crear lista de pixeles");
                    System.out.println("Ingrese la cantidad de pixeles que desea crear: ");
                    int cantidadPixeles = sc.nextInt();
                    List<Pixel> pixeles = systemImages.crearListaDePixeles(cantidadPixeles);
                    //mostrar en pantalla la lista de pixeles creados
                    System.out.println("Pixeles creados: ");
                    for (int i = 0; i < pixeles.size(); i++) {
                        System.out.println("Pixel " + (i + 1) + ": " + pixeles.get(i).toString());
                    }
                    System.out.println("¿Desea guardar esta lista de pixeles? 1. Si 2. No");
                    int guardarPixeles = sc.nextInt();
                    if (guardarPixeles == 1) {
                        if(systemImages.getContienePixeles() == 0){
                            systemImages.setPixeles(pixeles);
                            systemImages.setContienePixeles(1);
                        }else{
                            System.out.println("Ya existe una lista de pixeles, desea reemplazarla? 1. Si 2. No");
                            int reemplazarPixeles = sc.nextInt();
                            if(reemplazarPixeles == 1){
                                systemImages.setPixeles(pixeles);
                            }
                        }
                    } else {
                        System.out.println("Lista de pixeles no guardada");
                    }
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
                //===========cASO 4: VER LISTA DE PIXELES CREADOS================
                case 4:
                    //mostrar lista de pixeles
                    System.out.println("--------------------");
                    System.out.println("Lista de pixeles creados: ");
                    if (systemImages.getContienePixeles() == 0) {
                        System.out.println("No hay pixeles creados");
                    } else {
                        //mostrar lista de pixeles
                        List<Pixel> pixelesCreados = systemImages.getPixeles();
                        for (int i = 0; i < pixelesCreados.size(); i++) {
                            System.out.println("Pixel " + (i + 1) + ": " + pixelesCreados.get(i).toString());
                        }
                    }
                    break;
                //===========cASO 5: COMPROBAR TIPO DE IMAGEN================
                case 5:
                    System.out.println("Comprobar tipo de imagen");
                    break;
                //===========cASO 6: SALIR================
                case 6:
                    //Salir
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion != 6);

    }
}