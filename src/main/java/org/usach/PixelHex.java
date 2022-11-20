package org.usach;

public class PixelHex extends Pixel{
    private String hex;

    public PixelHex(int x, int y, int depth, String hex) {
        super(x, y, depth);
        this.hex = hex;
    }


    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    @Override
    public String toString() {
        return "PixelHex{" +
                "hex='" + hex + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", depth=" + depth +
                '}';
    }
}