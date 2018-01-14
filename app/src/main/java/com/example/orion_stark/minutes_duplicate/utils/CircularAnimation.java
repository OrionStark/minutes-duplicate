package com.example.orion_stark.minutes_duplicate.utils;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by orionstark on 1/14/18.
 * Untuk Activity transisi aja
 */

public class CircularAnimation {
    public static final String EXTRA_CIRCULAR_REVEAL_X = "EXTRA_CIRCULAR_REVEAL_X";
    public static final String EXTRA_CIRCULAR_REVEAL_Y = "EXTRA_CIRCULAR_REVEAL_Y";

    private final View view;
    private Activity activity;

    private int revealX;
    private int revealY;

    public CircularAnimation(final View mview, Intent intent, Activity activity) {
        this.view = mview;
        this.activity = activity;

        if (Build.VERSION.SDK_INT >= 21 && intent.hasExtra(EXTRA_CIRCULAR_REVEAL_X) && intent.hasExtra(EXTRA_CIRCULAR_REVEAL_Y)) {
            this.view.setVisibility(View.INVISIBLE);
            revealX = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_X, 0);
            revealY = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_Y, 0);

            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if ( viewTreeObserver.isAlive() ) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        revealActivity(revealX, revealY);
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        }
    }

    public void revealActivity( int x, int y ) {
        if ( Build.VERSION.SDK_INT >= 21 ) {
            float finalRadius = (float) (Math.max(this.view.getWidth(), this.view.getHeight()) * 1.1);
            Animator animator = ViewAnimationUtils.createCircularReveal(this.view, x, y, 0, finalRadius);
            animator.setDuration(300);
            animator.setInterpolator(new AccelerateInterpolator());

            this.view.setVisibility(View.VISIBLE);
            animator.start();
        } else {
            this.activity.finish();
        }
    }

    public void unrevealActivity() {
        if (Build.VERSION.SDK_INT >= 21) {
            float finalRadius = (float) (Math.max(this.view.getWidth(), this.view.getHeight()) * 1.1);
            Animator animator = ViewAnimationUtils.createCircularReveal(this.view, revealX, revealY, finalRadius, 0);
            animator.setDuration(300);
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(View.INVISIBLE);
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            animator.start();
        } else {
            this.activity.finish();
        }
    }
}
