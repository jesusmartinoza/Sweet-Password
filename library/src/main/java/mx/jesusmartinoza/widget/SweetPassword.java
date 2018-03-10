package mx.jesusmartinoza.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
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

    // UI
    private EditText editText;
    private EyeView eyeView;
    private TextInputLayout textInputLayout;

    // Animation
    private boolean showing;
    private EyeViewAnimation animation;
    private Interpolator interpolator;

    /**
     * Mandatory constructor for View
     * @param context Context
     */
    public SweetPassword(Context context) {
        super(context);
        initComponent();
    }

    /**
     * After init components set default values from attributes
     * @param context Context
     */
    public SweetPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
        initComponent();

        TypedArray a = getContext().obtainStyledAttributes(attrs,
                R.styleable.SweetPassword);

        animation.setDuration(a.getInteger(R.styleable.SweetPassword_anim_duration, 280));
        eyeView.setIrisColor(a.getColor(R.styleable.SweetPassword_iris_color, fetchAccentColor()));
        eyeView.setEyeColor(a.getColor(R.styleable.SweetPassword_eye_color, fetchAccentColor()));

        // OK, I need some optional sugar :P
        String hint = a.getString(R.styleable.SweetPassword_password_hint);
        textInputLayout.setHint(hint.isEmpty() ? "Password" : hint);

        a.recycle();
    }

    /**
     * Inflate view, instantiate components and set {eyeview} click listener
     */
    private void initComponent() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li =
                (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.sweet_password, this, true);

        showing = false;
        editText = findViewById(R.id.edit_text);
        eyeView = findViewById(R.id.eye_view);
        textInputLayout = findViewById(R.id.text_input_layout);
        interpolator = new DecelerateInterpolator();
        animation = new EyeViewAnimation(eyeView);

        eyeView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                animation.setEyeOpen(showing);
                animation.setInterpolator(interpolator);

                eyeView.startAnimation(animation);
                showing = !showing;

                togglePasswordVisibility();
            }
        });
    }

    /**
     * Toggle EditText password visibility.
     */
    public void togglePasswordVisibility() {
        if (showing) {
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    /**
     * Fetch accent color from project
     * @return
     */
    private int fetchAccentColor() {
        TypedValue typedValue = new TypedValue();

        TypedArray a = getContext().obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorAccent });
        int color = a.getColor(0, 0);

        a.recycle();

        return color;
    }

    /*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
                        G  E  T  T  E  R  S    &    S  E  T  T  E  R  S
     =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*/
    /**
     * Set animation duration
     * @param durationMillis
     */
    public void setAnimDuration(int durationMillis) {
        animation.setDuration(durationMillis);
    }

    /**
     * Set iris color
     * @param color new color
     */
    public void setIrisColor(int color) {
        eyeView.setIrisColor(color);
    }

    /**
     * Set border color of eye
     * @param color new color
     */
    public void setEyeColor(int color) {
        eyeView.setEyeColor(color);
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