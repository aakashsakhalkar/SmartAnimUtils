package com.aakash.smartanimutils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

/**
 * SmartAnimUtils
 * A collection of ready-to-use static animation helper methods for Android Views.
 *
 * Usage:
 * SmartAnimUtils.animateShowFromCenter(myView, 300);
 */
public class SmartAnimUtils {

    // ---------------- BASIC SHOW/HIDE ----------------

    /** Show view by scaling from center */
    public static void animateShowFromCenter(View view, long duration) {
        view.setScaleX(0f);
        view.setScaleY(0f);
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);

        view.animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(duration)
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }

    /** Hide view by shrinking to center */
    public static void animateHideToCenter(View view, long duration) {
        view.animate()
                .scaleX(0f)
                .scaleY(0f)
                .alpha(0f)
                .setDuration(duration)
                .setInterpolator(new AccelerateInterpolator())
                .withEndAction(() -> view.setVisibility(View.GONE))
                .start();
    }

    // ---------------- SLIDE IN ----------------

    /** Slide in from left */
    public static void animSlideInFromLeft(View view, long duration) {
        view.setTranslationX(-view.getWidth());
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);

        view.animate()
                .translationX(0)
                .alpha(1f)
                .setDuration(duration)
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }

    /** Slide in from right */
    public static void animSlideInFromRight(View view, long duration) {
        view.setTranslationX(view.getWidth());
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);

        view.animate()
                .translationX(0)
                .alpha(1f)
                .setDuration(duration)
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }

    /** Slide in from top */
    public static void animSlideInFromTop(View view, long duration) {
        view.setTranslationY(-view.getHeight());
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);

        view.animate()
                .translationY(0)
                .alpha(1f)
                .setDuration(duration)
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }

    /** Slide in from bottom */
    public static void animSlideInFromBottom(View view, long duration) {
        view.setTranslationY(view.getHeight());
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);

        view.animate()
                .translationY(0)
                .alpha(1f)
                .setDuration(duration)
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }

    // ---------------- POP ANIMATIONS ----------------

    /** Pop up with overshoot bounce */
    public static void animatePopUp(View view, long duration) {
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);

        view.animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(duration)
                .setInterpolator(new OvershootInterpolator())
                .start();
    }

    /** Pop up with bounce effect */
    public static void animatePopUpBounce(View view, long duration) {
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);

        view.animate()
                .alpha(1f)
                .setDuration(duration / 5)
                .withEndAction(() -> {
                    ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.8f, 1.1f, 0.95f, 1.05f, 1f);
                    ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.8f, 1.1f, 0.95f, 1.05f, 1f);
                    AnimatorSet bounceSet = new AnimatorSet();
                    bounceSet.playTogether(scaleX, scaleY);
                    bounceSet.setInterpolator(new DecelerateInterpolator());
                    bounceSet.setDuration(duration);
                    bounceSet.start();
                })
                .start();
    }

    // ---------------- FADE ANIMATIONS ----------------

    /** Fade in */
    public static void fadeIn(View view, long duration) {
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.animate().alpha(1f).setDuration(duration).start();
    }

    /** Fade out */
    public static void fadeOut(View view, long duration) {
        view.animate()
                .alpha(0f)
                .setDuration(duration)
                .withEndAction(() -> view.setVisibility(View.GONE))
                .start();
    }

    // ---------------- ROTATE ----------------

    /** Rotate clockwise */
    public static void rotateClockwise(View view, long duration) {
        view.animate().rotationBy(360f).setDuration(duration).setInterpolator(new LinearInterpolator()).start();
    }

    /** Rotate counter-clockwise */
    public static void rotateCounterClockwise(View view, long duration) {
        view.animate().rotationBy(-360f).setDuration(duration).setInterpolator(new LinearInterpolator()).start();
    }

    /** Flip horizontally */
    public static void flipHorizontal(View view, long duration) {
        view.animate().rotationYBy(180f).setDuration(duration).setInterpolator(new DecelerateInterpolator()).start();
    }

    /** Flip vertically */
    public static void flipVertical(View view, long duration) {
        view.animate().rotationXBy(180f).setDuration(duration).setInterpolator(new DecelerateInterpolator()).start();
    }

    // ---------------- ZOOM ----------------

    /** Zoom in */
    public static void zoomIn(View view, long duration) {
        view.setScaleX(0.5f);
        view.setScaleY(0.5f);
        view.setVisibility(View.VISIBLE);
        view.animate().scaleX(1f).scaleY(1f).setDuration(duration).setInterpolator(new DecelerateInterpolator()).start();
    }

    /** Zoom out */
    public static void zoomOut(View view, long duration) {
        view.animate().scaleX(0.5f).scaleY(0.5f).setDuration(duration).setInterpolator(new AccelerateInterpolator()).withEndAction(() -> view.setVisibility(View.GONE)).start();
    }

    // ---------------- SHAKE / BOUNCE ----------------

    /** Shake horizontally */
    public static void shake(View view, long duration) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationX", 0, 25, -25, 20, -20, 10, -10, 0);
        anim.setDuration(duration);
        anim.start();
    }

    /** Bounce vertically */
    public static void bounce(View view, long duration) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", 0, -30, 0, -15, 0);
        anim.setInterpolator(new BounceInterpolator());
        anim.setDuration(duration);
        anim.start();
    }

    // ---------------- SPECIAL EFFECTS ----------------

    /** Blink effect */
    public static void blink(View view, long duration) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        anim.setDuration(duration);
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.start();
    }

    /** Pulse (scales in and out) */
    public static void pulse(View view, long duration) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.1f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.1f, 1f);

        // Set repeat on each animator
        scaleX.setRepeatCount(ObjectAnimator.INFINITE);
        scaleX.setRepeatMode(ObjectAnimator.RESTART);

        scaleY.setRepeatCount(ObjectAnimator.INFINITE);
        scaleY.setRepeatMode(ObjectAnimator.RESTART);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY);
        set.setDuration(duration);
        set.start();
    }

    /** Swing left and right */
    public static void swing(View view, long duration) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0, 10, -10, 5, -5, 0);
        anim.setDuration(duration);
        anim.start();
    }

    /** Wobble effect */
    public static void wobble(View view, long duration) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0, 5, -5, 3, -3, 0);
        anim.setDuration(duration);
        anim.start();
    }

    /** Flash effect */
    public static void flash(View view, long duration) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f, 0f, 1f);
        anim.setDuration(duration);
        anim.start();
    }

    /** Tada effect (like surprise animation) */
    public static void tada(View view, long duration) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.9f, 1.1f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.1f, 0.9f, 1f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0, -3, 3, -3, 0);
        set.playTogether(scaleX, scaleY, rotate);
        set.setDuration(duration);
        set.start();
    }

    /** Heartbeat animation */
    public static void heartbeat(View view, long duration) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.3f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.3f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY);
        set.setDuration(duration);
        set.setInterpolator(new DecelerateInterpolator());
        set.start();
    }

    /** Drop out (fall down and disappear) */
    public static void dropOut(View view, long duration) {
        view.animate()
                .translationY(view.getHeight())
                .alpha(0f)
                .setDuration(duration)
                .withEndAction(() -> view.setVisibility(View.GONE))
                .start();
    }

    /** Slide out to left */
    public static void slideOutLeft(View view, long duration) {
        view.animate()
                .translationX(-view.getWidth())
                .alpha(0f)
                .setDuration(duration)
                .withEndAction(() -> view.setVisibility(View.GONE))
                .start();
    }

    /** Slide out to right */
    public static void slideOutRight(View view, long duration) {
        view.animate()
                .translationX(view.getWidth())
                .alpha(0f)
                .setDuration(duration)
                .withEndAction(() -> view.setVisibility(View.GONE))
                .start();
    }

    /** Slide out to top */
    public static void slideOutUp(View view, long duration) {
        view.animate()
                .translationY(-view.getHeight())
                .alpha(0f)
                .setDuration(duration)
                .withEndAction(() -> view.setVisibility(View.GONE))
                .start();
    }

    /** Slide out to bottom */
    public static void slideOutDown(View view, long duration) {
        view.animate()
                .translationY(view.getHeight())
                .alpha(0f)
                .setDuration(duration)
                .withEndAction(() -> view.setVisibility(View.GONE))
                .start();
    }
    public static void resetAnimations(View view) {
        view.animate().cancel(); // stop any running animation
        view.setAlpha(1f);
        view.setScaleX(1f);
        view.setScaleY(1f);
        view.setTranslationX(0f);
        view.setTranslationY(0f);
        view.setRotation(0f);
        view.setVisibility(View.VISIBLE);
    }
}

