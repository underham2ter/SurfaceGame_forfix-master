package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class Enemy {
    private Bitmap bitmap;
    private int zz;
    private int x;
    private int y;
    private int speed = 0;
    private boolean boosting;
    private final int GRAVITY = -10;
    private int maxY;
    private int minY;
    private int maxX;

    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    private Rect detectCollision;

    public Enemy(Context context, int screenX, int screenY) {
        x = 1500;
        Random generator = new Random();

        y = generator.nextInt(1500);
        speed = 20;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        maxY = screenY - bitmap.getHeight();
        minY = 0;
        maxX = screenX - bitmap.getWidth();
        boosting = false;



    }


    public void update() {


        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        x -= 1.5*speed;
        Random generator = new Random();


        if(x<3*maxX/4&&x>2*maxX/4){
            y-= 15;
        }
        else if(x<2*maxX/4&&x>maxX/4){
            y += 10;
        }
        else if(x<maxX&&x>3*maxX/4){
            y += 15;
        }
        else if(x<maxX/4){
            y -= 12;
        }

        if (x < 0) {

            x = maxX;

            y = generator.nextInt(maxY);

        }
        detectCollision =  new Rect(x, y, x+bitmap.getWidth(), y+bitmap.getHeight());

    }


    public Rect getDetectCollision() {
        return detectCollision;
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

    public int getSpeed() {
        return speed;
    }
}


