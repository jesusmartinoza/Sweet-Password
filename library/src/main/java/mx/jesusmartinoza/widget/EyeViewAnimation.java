package mx.jesusmartinoza.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by jesusmartinoza on 10/03/18.
 */

public class EyeViewAnimation extends Animation {

    private EyeView eyeView;

    private boolean eyeOpen;

    /**
     * Set Eye Open Ratio to 0 (Closed eye)
     * @param eyeView
     */
    public EyeViewAnimation(EyeView eyeView) {
        this.eyeView = eyeView;
        eyeOpen = false;
    }

    /**
     * When true the eye will open
     * @param eyeOpen
     */
    public void setEyeOpen(boolean eyeOpen) {
        this.eyeOpen = eyeOpen;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        if(eyeOpen)
            eyeView.setEOR(interpolatedTime);
        else
            eyeView.setEOR(1.0f - interpolatedTime);

        eyeView.requestLayout();
    }
}