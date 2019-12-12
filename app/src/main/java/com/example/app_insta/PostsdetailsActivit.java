package com.example.app_insta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class PostsdetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
    @Override
    public void onViewCaptured(@NonNull View capturedChild, int activePointerId) {
        if (capturedChild instanceof MaterialCardView) {
            ((MaterialCardView)view).setDragged(true);
        }
    }

    @Override
    public void onViewReleased(@NonNull View releaseChild, float xVel, float yVel) {
        if (releaseChild instanceof MaterialCardView) {
            Object view;
            ((MaterialCardView)view).setDragged(false);
        }
    }♦
}