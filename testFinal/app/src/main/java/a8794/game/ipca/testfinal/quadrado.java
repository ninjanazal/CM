package a8794.game.ipca.testfinal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

/**
 * Created by Geral on 30/01/2018.
 */

public class quadrado {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed;

    private int maxX, maxY;

    private Rect boundingBox;
    private boolean isAlive;

    public quadrado(Context context, int screenX, int screenY){
        isAlive = true;
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.square);

        x = screenX / 2 - bitmap.getWidth() / 2;
        y = 50;

        maxX = screenX - bitmap.getWidth();
        speed = 5;

        boundingBox = new Rect(x,y,x+bitmap.getHeight(),y+ bitmap.getWidth());
    }

    public void update(){
        if(x>= maxX)
            speed *= -1;
        else if(x<= 0)
            speed *=-1;

        x += speed;

        boundingBox.left =x;
        boundingBox.right = y;
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
