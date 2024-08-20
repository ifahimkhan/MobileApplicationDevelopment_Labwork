package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircleView extends View {
    
    private Paint paint;
    private int circleColor = Color.BLUE;
    private float circleRadius = 100f;

    // Constructor to use when creating the view programmatically
    public CustomCircleView(Context context) {
        super(context);
        init();
    }

    // Constructor to use when inflating the view from XML
    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    // Constructor to use when inflating the view from XML with a style attribute
    public CustomCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Initialize the paint object
        paint = new Paint();
        paint.setColor(circleColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Get the center of the view
        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;

        // Draw the circle
        canvas.drawCircle(centerX, centerY, circleRadius, paint);
    }

    // Setters to change the circle's attributes programmatically
    public void setCircleColor(int color) {
        circleColor = color;
        paint.setColor(circleColor);
        invalidate(); // Redraw the view with the new color
    }

    public void setCircleRadius(float radius) {
        circleRadius = radius;
        invalidate(); // Redraw the view with the new radius
    }
}
