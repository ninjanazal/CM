package a8794.game.ipca.testfinal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Geral on 30/01/2018.
 */

public class GameView extends SurfaceView implements Runnable {

    private boolean playing = false;
    private Thread gameThread = null;

    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    private Context ctx;
    private int xScreen, yScreen;

    private quadrado square;
    private List<rectangle> rectangles;

    public GameView(Context context, int screenX, int screenY) {
        super(context);

        xScreen = screenX;
        yScreen = screenY;
        ctx = context;
        surfaceHolder = getHolder();
        paint = new Paint();

        square = new quadrado(ctx, xScreen, yScreen);
        rectangles = new ArrayList<rectangle>();
    }


    @Override
    public void run() {
        while (playing) {
            update();
            draw();
            control();
        }
    }

    private void update() {
        if (square.isAlive())
            square.update();

        if (rectangles != null)
            for (rectangle rec : rectangles)
                if (rec.isAlive())
                    rec.update();

        for (rectangle rec : rectangles)
            if (rec.isAlive())
                if (Rect.intersects(square.getBoundingBox(), rec.getBoundingBox())) {
                    square.setAlive(false);
                    rec.setAlive(false);
                }

        for (rectangle rec : rectangles)
            if (!rec.isAlive()) {
                rectangles.remove(rec);
                break;
            }
    }

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);

            paint.setColor(Color.WHITE);

            // desenha quadrado
            if (square.isAlive())
                canvas.drawBitmap(square.getBitmap(), square.getX(), square.getY(), paint);

            if (rectangles != null)
                for (rectangle rec : rectangles)
                    canvas.drawBitmap(rec.getBitmap(), rec.getX(), rec.getY(), paint);

            surfaceHolder.unlockCanvasAndPost(canvas);

        }

    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {

        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                if (rectangles.size() < 2)
                    rectangles.add(new rectangle(ctx, xScreen, yScreen, (int) event.getX(), (int) event.getY()));
                break;

        }
        return true;
    }

}
