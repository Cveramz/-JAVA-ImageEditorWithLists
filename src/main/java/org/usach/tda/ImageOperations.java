package org.usach.tda;

public interface ImageOperations {
    static void isCompressed(){}

    static void flipH(){}
    static void invertColor(){
        System.out.println("invertColor");
    }
    static void crop(int x1,int x2,int y1,int y2){
        System.out.println("crop");
    }

}
