package com.example.Paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * User: rober
 * Date: 26/09/13
 * Time: 07:15 PM
 * Agregar la descripción del archivo
 */
public class MiVista extends View {
    ArrayList<Point> puntos = new ArrayList<Point>();
    Paint paint = new Paint();

    public MiVista(Context context) {
        super(context);
        fill();
    }

    public MiVista(Context context, AttributeSet attrs) {
        super(context, attrs);
        fill();
    }

    public MiVista(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        fill();
    }

    void fill(){
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Point punto = new Point();
                punto.x = (int)event.getX();
                punto.y = (int)event.getY();
                puntos.add(punto);
                invalidate();
                return true;
            }
        });
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Point punto : puntos){
            canvas.drawCircle(punto.x,punto.y,5,paint);
        }
        this.invalidate();
    }
}
