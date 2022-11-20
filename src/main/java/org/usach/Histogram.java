package org.usach;

import java.util.List;

public class Histogram {
    private int tipoPixel; //1. Bit 2. Hex 3. RGB;
    //tendremos 3 listas, uno para bit(int), hex(String) y rgb(int)
    private List<Integer> bit;
    private List<String> hex;
    private List<Integer> rgb;
    //tendremos 2 listas tipo histograma, uno que tendra tipos int y otro que tendra tipos string
    private List<Integer> histogramaInt;
    private List<String> histogramaString;

    public Histogram(List<Pixel> pixeles, int tipoPixel){
        if (tipoPixel == 1){
            //si se encuentra en pixeles un bit=1, se agrega a la lista bit, si ya esta en la lista se ignora
            //si se encuentra en pixeles un bit=0, se agrega a la lista bit, si ya esta en la lista se ignora
            //primero revisar si el pixel es de tipo bit, viendo si es instancia.
            //esto basta con solo ver el primer pixel de la lista

        }

    }


}