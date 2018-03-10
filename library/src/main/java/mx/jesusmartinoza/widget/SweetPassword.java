package mx.jesusmartinoza.widget;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Created by jesusmartinoza on 10/03/18.
 */
public class SweetPassword extends RelativeLayout {

    private EditText editText;
    private EyeView eyeView;
    private boolean showing;
    private Interpolator interpolator;

    public SweetPassword(Context context) {
        super(context);
        initComponent();
    }

    public SweetPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
        initComponent();
    }

    /**
     * Inflate view and create default eye animation
     */
    private void initComponent() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li =
                (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.sweet_password, this, true);

        showing = false;
        editText = findViewById(R.id.edit_text);
        eyeView = findViewById(R.id.eye_view);
        interpolator = new DecelerateInterpolator();

        eyeView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EyeViewAnimation anim = new EyeViewAnimation(eyeView);
                anim.setDuration(200);
                anim.setEyeOpen(showing);
                anim.setInterpolator(interpolator);

                eyeView.startAnimation(anim);
                showing = !showing;

                toggleShowPassword();
            }
        });
    }

    public void toggleShowPassword() {
        if (showing) {
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    /**
     * Set interpolator for eye animation
     * @param interpolator
     */
    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    /**
     * Get content of edit text
     * @return
     */
    public String getPassword() {
        return editText.getText().toString();
    }
}