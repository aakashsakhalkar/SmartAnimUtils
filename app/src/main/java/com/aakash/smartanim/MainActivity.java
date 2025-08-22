package com.aakash.smartanim;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private View demoBox;
    private RecyclerView recyclerView;
    private String[] animations = {
            "ShowFromCenter", "HideToCenter", "SlideInFromLeft", "SlideInFromRight",
            "SlideInFromTop", "SlideInFromBottom", "PopUp", "PopUpBounce",
            "FadeIn", "FadeOut", "RotateClockwise", "RotateCounterClockwise",
            "FlipHorizontal", "FlipVertical", "ZoomIn", "ZoomOut",
            "Shake", "Bounce", "Blink", "Pulse", "Swing", "Wobble",
            "Flash", "Tada", "Heartbeat", "DropOut", "SlideOutLeft",
            "SlideOutRight", "SlideOutUp", "SlideOutDown"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        demoBox = findViewById(R.id.demoBox);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new AnimAdapter(animations, this::runAnimation));
    }

    /*private void runAnimation(String name) {
        SmartAnimUtils.resetAnimations(demoBox);
        switch (name) {
            case "ShowFromCenter":
                SmartAnimUtils.animateShowFromCenter(demoBox, 600);
                break;
            case "HideToCenter":
                SmartAnimUtils.animateHideToCenter(demoBox, 600);
                break;
            case "SlideInFromLeft":
                SmartAnimUtils.animSlideInFromLeft(demoBox, 600);
                break;
            case "SlideInFromRight":
                SmartAnimUtils.animSlideInFromRight(demoBox, 600);
                break;
            case "SlideInFromTop":
                SmartAnimUtils.animSlideInFromTop(demoBox, 600);
                break;
            case "SlideInFromBottom":
                SmartAnimUtils.animSlideInFromBottom(demoBox, 600);
                break;
            case "PopUp":
                SmartAnimUtils.animatePopUp(demoBox, 600);
                break;
            case "PopUpBounce":
                SmartAnimUtils.animatePopUpBounce(demoBox, 800);
                break;
            case "FadeIn":
                SmartAnimUtils.fadeIn(demoBox, 500);
                break;
            case "FadeOut":
                SmartAnimUtils.fadeOut(demoBox, 500);
                break;
            case "RotateClockwise":
                SmartAnimUtils.rotateClockwise(demoBox, 1000);
                break;
            case "RotateCounterClockwise":
                SmartAnimUtils.rotateCounterClockwise(demoBox, 1000);
                break;
            case "FlipHorizontal":
                SmartAnimUtils.flipHorizontal(demoBox, 600);
                break;
            case "FlipVertical":
                SmartAnimUtils.flipVertical(demoBox, 600);
                break;
            case "ZoomIn":
                SmartAnimUtils.zoomIn(demoBox, 500);
                break;
            case "ZoomOut":
                SmartAnimUtils.zoomOut(demoBox, 500);
                break;
            case "Shake":
                SmartAnimUtils.shake(demoBox, 600);
                break;
            case "Bounce":
                SmartAnimUtils.bounce(demoBox, 600);
                break;
            case "Blink":
                SmartAnimUtils.blink(demoBox, 500);
                break;
            case "Pulse":
                SmartAnimUtils.pulse(demoBox, 800);
                break;
            case "Swing":
                SmartAnimUtils.swing(demoBox, 600);
                break;
            case "Wobble":
                SmartAnimUtils.wobble(demoBox, 600);
                break;
            case "Flash":
                SmartAnimUtils.flash(demoBox, 600);
                break;
            case "Tada":
                SmartAnimUtils.tada(demoBox, 800);
                break;
            case "Heartbeat":
                SmartAnimUtils.heartbeat(demoBox, 700);
                break;
            case "DropOut":
                SmartAnimUtils.dropOut(demoBox, 700);
                break;
            case "SlideOutLeft":
                SmartAnimUtils.slideOutLeft(demoBox, 700);
                break;
            case "SlideOutRight":
                SmartAnimUtils.slideOutRight(demoBox, 700);
                break;
            case "SlideOutUp":
                SmartAnimUtils.slideOutUp(demoBox, 700);
                break;
            case "SlideOutDown":
                SmartAnimUtils.slideOutDown(demoBox, 700);
                break;
        }
    }*/
}