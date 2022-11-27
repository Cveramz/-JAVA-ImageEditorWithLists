package org.usach;

public interface ImageOperations_20816739_VeraRamirez {

    public boolean isBitmap();
    public boolean isPixmap();
    public boolean isHexmap();
    public boolean isCompressed();
    public Image_20816739_VeraRamirez flipH();
    public Image_20816739_VeraRamirez flipV();
    public Image_20816739_VeraRamirez crop(int x1, int y1, int x2, int y2);
    public Image_20816739_VeraRamirez imgRGBToHex();

}
