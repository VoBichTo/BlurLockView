package com.example.pet.blurlockview;

import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.nightonke.blurlockview.BlurLockView;
import com.nightonke.blurlockview.Directions.HideType;
import com.nightonke.blurlockview.Directions.ShowType;
import com.nightonke.blurlockview.Eases.EaseType;
import com.nightonke.blurlockview.Password;

public class MainActivity extends AppCompatActivity {

    private BlurLockView blurLockView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Request full screen
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        blurLockView = findViewById(R.id.blurLockView);
        blurLockView.setBlurredView(imageView);

        imageView = findViewById(R.id.background);

        blurLockView.setCorrectPassword("1310");
        blurLockView.setLeftButton("Left");
        blurLockView.setRightButton("Right");
        blurLockView.setTypeface(Typeface.DEFAULT);
        blurLockView.setType(Password.NUMBER, false);

        blurLockView.setOnLeftButtonClickListener(new BlurLockView.OnLeftButtonClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "Left Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        blurLockView.setOnPasswordInputListener(new BlurLockView.OnPasswordInputListener() {
            @Override
            public void correct(String inputPassword) {
                Toast.makeText(MainActivity.this, "Password Correct", Toast.LENGTH_SHORT).show();
                blurLockView.hide(1000, HideType.FADE_OUT, EaseType.EaseInBounce);
            }

            @Override
            public void incorrect(String inputPassword) {
                Toast.makeText(MainActivity.this, "Password Incorrect", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void input(String inputPassword) {

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blurLockView.show(1000, ShowType.FADE_IN, EaseType.EaseOutBack);
            }
        });
    }
}
