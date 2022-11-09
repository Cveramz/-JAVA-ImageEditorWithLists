package org.com.usach;
import java.util.Scanner;



public class Main {
    //Crear funcion menu
    public static void menu(){
        int opcion;
        //mientras que opcion sea mayor a 0 y menor a 4
        //Opciones: 1. Crear imagen, 2. Crear Pixel, 3. Comprobar tipo de imagen, 4. Salir
        do{
            System.out.println("1. Crear imagen");
            System.out.println("2. Crear Pixel");
            System.out.println("3. Comprobar tipo de imagen");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion: ");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    //Crear imagen
                    break;
                case 2:
                    //Crear pixel
                    break;
                case 3:
                    //Comprobar tipo de imagen
                    break;
                case 4:
                    //Salir
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opcion > 0 && opcion < 4);
    }

    public static void main(String[] args) {

    }
}