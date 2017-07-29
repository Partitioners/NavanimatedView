package com.example.dell.navanimatedview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.BounceInterpolator;

/**
 * Created by DELL on 29-07-2017.
 */

public class MyBounceInterpolater extends BounceInterpolator {
    private double mAmplitude = 1;
    private double mFrequency = 10;
    public MyBounceInterpolater() {
        super();
    }

    public MyBounceInterpolater(double mAmplitude,double mFrequency) {
        this.mAmplitude=mAmplitude;
        this.mFrequency=mFrequency;
    }

    @Override
    public float getInterpolation(float t) {
        return (float) (-1 * Math.pow(Math.E, -t/ mAmplitude) *
                Math.cos(mFrequency * t) + 1);    }
}
