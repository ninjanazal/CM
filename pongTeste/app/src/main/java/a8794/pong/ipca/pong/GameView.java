package a8794.pong.ipca.pong;

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
 * Created by Eurico on 09/01/2018.
 */

public class GameView extends SurfaceView implements Runnable {
    private boolean playing = false;
    private Thread gameThread = null;

    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    private List<Ball> balls;
    private Context ctx;
    private int xScreen, yScreen;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        xScreen = screenX;
        yScreen = screenY;
        ctx = context;
        surfaceHolder = getHolder();
        paint = new Paint();

        balls = new ArrayList<Ball>();

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
        if (balls != null) {

            for (Ball ball : balls)
                if (!ball.isAlive()) {
                    balls.remove(ball);
                    break;

                }
            for (Ball ball : balls)
                ball.update();

            for (Ball ball : balls) {
                for (Ball ball2 : balls) {
                    if (balls.indexOf(ball) != balls.indexOf(ball2)) {
                        if (Rect.intersects(ball.getBoundingBox(), ball2.getBoundingBox())) {
                            ball.setAlive(false);
                            ball2.setAlive(false);
                        }
                    }
                }
            }
        }
    }

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);

            paint.setColor(Color.WHITE);
            if (balls != null)
                for (Ball ball : balls) {
                    canvas.drawBitmap(ball.getBitmap(), ball.getX(), ball.getY(), paint);
                }
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
                if (balls.size() < 15)
                    balls.add(new Ball(ctx, xScreen, yScreen, (int) event.getX(), (int) event.getY()));
                break;

        }
        return true;
    }
}
