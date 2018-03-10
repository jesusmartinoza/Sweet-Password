package mx.jesusmartinoza.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jesusmartinoza on 10/03/18.
 */

public class EyeView extends View {

    private Paint paint;
    private Path lashline;
    private Path waterLine;
    private float anchorX;

    private float ECR; // Eye Closed Ratio

    public EyeView(Context context) {
        super(context);
        init();
    }

    public EyeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EyeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        paint = new Paint();
        ECR = 1.0f;

        paint.setAntiAlias(true);
    }

    /**
     * Set Eye Closed Ratio.
     * 0.0 - Fully opened eye
     * 1.0 - Closed eye
     * @param eyeOpenRatio new Open Ratio
     */
    public void setEOR(float eyeOpenRatio) {
        ECR = eyeOpenRatio;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        anchorX = 20;
        lashline = new Path();
        waterLine = new Path();

        paint.setColor(getResources().getColor(android.R.color.holo_orange_dark));
        paint.setStrokeWidth(8);

        paint.setStyle(Paint.Style.STROKE);

        // Lashline
        lashline.moveTo(anchorX, canvas.getHeight() / 2);
        lashline.cubicTo(canvas.getWidth() / 2 - anchorX, 25.0f + 58 * ECR,
                canvas.getWidth() / 2 + anchorX,
                25.0f + 58 * ECR, canvas.getWidth() - anchorX, canvas.getHeight() / 2);

        canvas.drawPath(lashline, paint);

        // Waterline
        paint.setColor(getResources().getColor(android.R.color.holo_orange_dark));
        waterLine.moveTo(anchorX, canvas.getHeight() / 2);
        waterLine.cubicTo(canvas.getWidth() / 2 - anchorX,canvas.getHeight() - 25,
                canvas.getWidth() / 2 + anchorX,
                canvas.getHeight() - 25, canvas.getWidth() - anchorX, canvas.getHeight() / 2);

        canvas.drawPath(waterLine, paint);

        // Iris
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 10 * (1.0f - ECR), paint);
    }
}