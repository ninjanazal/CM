package a8794.pong.ipca.pong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Eurico on 09/01/2018.
 */

public class Ball {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int randXSpeed, randYSpeed;

    private int maxX, maxY;

    private Rect boundingBox;

    private Random random;

    private boolean isAlive;


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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

    public Ball(Context context, int screenX, int screenY, int startX, int startY) {
        isAlive = true;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ball);

        random = new Random();
        randYSpeed = 10 + random.nextInt(10);
        randXSpeed = 10 + random.nextInt(10);


        if (random.nextInt(2) == 1)
            randXSpeed *= -1;

        if (random.nextInt(2) == 1)
            randYSpeed *= -1;

        x = startX;
        y = startY;

        maxX = screenX - bitmap.getWidth();
        maxY = screenY - bitmap.getHeight();

        boundingBox = new Rect(x, y, x + bitmap.getHeight(), y + bitmap.getWidth());

    }

    public void update() {
        if (x + randXSpeed >= maxX || x + randXSpeed <= 0)
            randXSpeed *= -1;

        if (y + randYSpeed >= maxY || y + randYSpeed <= 0)
            randYSpeed *= -1;

        x += randXSpeed;
        y += randYSpeed;


        boundingBox.left = x;
        boundingBox.top = y;
        boundingBox.right = x + bitmap.getWidth();
        boundingBox.bottom = y + bitmap.getHeight();
    }
}
