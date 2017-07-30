package com.example.dell.navanimatedview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.GroupModel;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

public class MainActivity extends AppCompatActivity {

    ImageView rotateImage, rotateImageBack, mSettings, mBounce, mFrameItem1,mFrameItem2;
    ObjectAnimator mAnimator, appsAnimator;
    Button startAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startAnimation = (Button) findViewById(R.id.start_animation);
        mSettings = (ImageView) findViewById(R.id.settings);
        mBounce = (ImageView) findViewById(R.id.bounce);
        mFrameItem1 = (ImageView) findViewById(R.id.frame_item_1);
        mFrameItem2 = (ImageView) findViewById(R.id.frame_item_2);
        initRotateAnimation();


        startAnimation.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                mAnimator.start();
                rotateImage.getDrawable().setTint(getResources().getColor(R.color.colorAccent));
                startTrimAnimation();
                startBounceAnimation();
                startFrameItemAnimation();
//                final ValueAnimator mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.9f);
//                final ValueAnimator mValueAnimatorEnd = ValueAnimator.ofFloat(0.1f, 1.0f);
//                //mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
//                mValueAnimator.setDuration(2000);
//                mValueAnimatorEnd.setDuration(2000);
//                mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
//                mValueAnimatorEnd.setRepeatCount(ValueAnimator.INFINITE);
//                mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                        outline.setTrimPathOffset((float) mValueAnimator.getAnimatedValue());
//                        outline.setTrimPathStart((float) mValueAnimator.getAnimatedValue());
//                        outline.setTrimPathEnd((float) mValueAnimatorEnd.getAnimatedValue());
//                        //outline.setTrimPathStart(0.1f);
//
//                        mTrimPath.update();
//
//                        //outline.setTrimPathEnd((Float) valueAnimator.getAnimatedValue());
//                        //mTrimPath.update();
//                    }
//                });
//                mValueAnimator.start();
//                mValueAnimatorEnd.start();


//                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 180f);
//                valueAnimator.setDuration(1000);
//
//                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//
//                      // set trim end value and update view
//                        model.setRotation((Float) valueAnimator.getAnimatedValue());
//                        mSettings.update();
//                    }
//                });
//                valueAnimator.start();
            }
        });
//        ValueAnimator valueAnimator=Val

        //VectorDrawable mDrawable=
    }

    public void initRotateAnimation() {
        rotateImage = (ImageView) findViewById(R.id.rotating_icon);
        rotateImageBack = (ImageView) findViewById(R.id.rotating_icon_1);
        mAnimator = ObjectAnimator.ofFloat(rotateImage, "rotationY", 0f, 90f);
        appsAnimator = ObjectAnimator.ofFloat(rotateImageBack, "rotationY", 90f, 0f);
        mAnimator.setDuration(500);
        mAnimator.setTarget(rotateImage);
        appsAnimator.setDuration(500);
        appsAnimator.setTarget(rotateImageBack);
        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                rotateImageBack.setVisibility(View.VISIBLE);
                appsAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }

    public void startTrimAnimation() {
        Drawable mDrawable = mSettings.getDrawable();
        ((Animatable) mDrawable).start();

    }

    public void startBounceAnimation() {
        ObjectAnimator bounceAnimator = ObjectAnimator.ofFloat(mBounce, "scaleX", 0.1f, 1.0f);
        ObjectAnimator bounceAnimator1 = ObjectAnimator.ofFloat(mBounce, "scaleY", 0.1f, 1.0f);
        bounceAnimator.setInterpolator(new MyBounceInterpolater(0.2, 20));
        bounceAnimator1.setInterpolator(new MyBounceInterpolater(0.2, 20));

        bounceAnimator.setDuration(1000);
        bounceAnimator1.setDuration(1000);

        bounceAnimator.start();
        bounceAnimator1.start();
    }

    public void startFrameItemAnimation() {
        //TODO implement this type of animation
        ObjectAnimator frameItemAnimation1 = ObjectAnimator.ofFloat(mFrameItem1, "rotation", 0f, 90f);
        ObjectAnimator frameItemAnimation2 = ObjectAnimator.ofFloat(mFrameItem2, "rotation", 0f, -90f);

        frameItemAnimation1.setDuration(300);
        frameItemAnimation2.setDuration(300);

        frameItemAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
        frameItemAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
        frameItemAnimation1.start();
        frameItemAnimation2.start();
    }
}
