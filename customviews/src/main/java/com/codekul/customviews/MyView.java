package com.codekul.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by aniruddha on 4/7/16.
 */
public class MyView extends TextView{

    private Paint paint;

    public MyView(Context context) {
        super(context);

        // using code

        initPaint();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context,attrs);

        // using xml

        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(30,30,50,paint);
        paint.setTextSize(30);
        canvas.drawText("{code}kul;",50,100,paint);
    }

    public void initPaint(){
        paint = new Paint();
        paint.setColor(Color.RED);
    }
}
