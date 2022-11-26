package org.usach;

public interface ImageOperations {

    public boolean isBitmap();
    public boolean isPixmap();
    public boolean isHexmap();
    public boolean isCompressed();
    public Image flipH();
    public Image flipV();
    public Image crop(int x1, int y1, int x2, int y2);
    public Image imgRGBToHex();

}
