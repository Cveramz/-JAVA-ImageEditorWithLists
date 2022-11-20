package org.usach;

public class PixelRGB extends Pixel{
    private int red;
    private int green;
    private int blue;

    public PixelRGB(int x, int y, int depth, int red, int green, int blue) {
        super(x, y, depth);
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }


    @Override
    public String toString() {
        return "PixelRGB{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", x=" + x +
                ", y=" + y +
                ", depth=" + depth +
                '}';
    }
}