package a8794.game.ipca.testfinal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

/**
 * Created by Geral on 30/01/2018.
 */

public class rectangle {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed;

    private Rect boundingBox;

    private int maxX, maxY;

    private boolean isAlive;

    public  rectangle(Context context, int screenX, int screenY, int startx, int startY){
        isAlive = true;
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.rectangle);

        speed = 10;
        x = startx;
        y = startY;

        maxX = screenX - bitmap.getWidth();
        maxY = screenY - bitmap.getHeight();

        boundingBox = new Rect(x,y,x+ bitmap.getHeight(), y + bitmap.getWidth());

    }
    public void update(){
        y -= speed;

        if(y< 0)
            isAlive = false;

        boundingBox.left = x;
        boundingBox.top = y;
        boundingBox.right = x + bitmap.getWidth();
        boundingBox.bottom = y + bitmap.getHeight();
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rect getBoundingBox() {
        return boundingBox;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
