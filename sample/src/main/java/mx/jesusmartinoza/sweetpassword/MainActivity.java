package mx.jesusmartinoza.sweetpassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;

import mx.jesusmartinoza.widget.SweetPassword;

public class MainActivity extends AppCompatActivity {

    private SweetPassword spInterpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spInterpolator = findViewById(R.id.sp_interpolator);

        spInterpolator.setInterpolator(new BounceInterpolator());
        spInterpolator.setAnimDuration(700);
    }
}
