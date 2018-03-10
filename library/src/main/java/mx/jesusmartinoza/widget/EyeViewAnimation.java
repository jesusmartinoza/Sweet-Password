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
     * Set Eye Closed Ratio to 0 (Opened eye)
     * @param eyeView
     */
    public EyeViewAnimation(EyeView eyeView) {
        this.eyeView = eyeView;
        eyeOpen = false;
    }

    /**
     * Apply {interpolatedTime} to eyeView's EOR
     * @param interpolatedTime
     * @param transformation
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        if(eyeOpen)
            eyeView.setECR(interpolatedTime);
        else
            eyeView.setECR(1.0f - interpolatedTime);

        eyeView.requestLayout();
    }

    /*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
                        G  E  T  T  E  R  S    &    S  E  T  T  E  R  S
     =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*/
    /**
     * When true the eye will open
     * @param eyeOpen
     */
    public void setEyeOpen(boolean eyeOpen) {
        this.eyeOpen = eyeOpen;
    }
}