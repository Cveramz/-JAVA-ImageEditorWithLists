package org.usach.tda;

public class PixelBit extends Pixel{
    private int bit;

    public PixelBit(int x, int y, int depth, int bit) {
        super(x, y, depth);
        this.bit = bit;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }


    @Override
    public String toString() {
        return "PixelBit{" +
                "bit=" + bit +
                ", x=" + x +
                ", y=" + y +
                ", depth=" + depth +
                '}';
    }
}