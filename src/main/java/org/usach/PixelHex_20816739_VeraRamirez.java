package org.usach;

public class PixelHex_20816739_VeraRamirez extends Pixel_20816739_VeraRamirez {
    private String hex;

    public PixelHex_20816739_VeraRamirez(int x, int y, int depth, String hex) {
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