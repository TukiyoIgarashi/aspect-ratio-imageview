package dev.chuross.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class FullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);

        final TextView text = (TextView) findViewById(R.id.txt_size_1);
        final View imageView = findViewById(R.id.img_aspect_image_1);
        final View parent = findViewById(R.id.parent);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                text.setText(String.format("w:%d x h:%d (%d, %d)", imageView.getWidth(), imageView.getHeight(), parent.getMeasuredWidth(), parent.getMeasuredHeight()));
            }
        });
    }
}
