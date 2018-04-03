package com.kiaora.masterproject;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
//import com.olacabs.customer.a.a;
//import com.olacabs.customer.model.dd;

public class BouncingMapPointer //extends RelativeLayout
{
 /*   private ObjectAnimator A;
    private ObjectAnimator B;
    private ObjectAnimator C;
    private ObjectAnimator D;
    private ObjectAnimator E;
    private ObjectAnimator F;
    private AnimatorSet G;
    private AnimatorSet H;
    private AnimatorSet I;
    private AnimatorSet J;
    private AnimatorSet K;
    private dd L;
    private Property<View, Float> M = new BouncingMapPointer(this, Float.TYPE, "translation_x_fraction");
    private Property<View, Float> N = new BouncingMapPointer(this, Float.TYPE, "translation_y_fraction");
    private Context a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private View e;
    private Drawable f;
    private Drawable g;
    private Drawable h;
    private AccelerateInterpolator i;
    private DecelerateInterpolator j;
    private OvershootInterpolator k;
    private ObjectAnimator l;
    private ObjectAnimator m;
    private ObjectAnimator n;
    private ObjectAnimator o;
    private ObjectAnimator p;
    private ObjectAnimator q;
    private ObjectAnimator r;
    private ObjectAnimator s;
    private ObjectAnimator t;
    private ObjectAnimator u;
    private ObjectAnimator v;
    private ObjectAnimator w;
    private ObjectAnimator x;
    private ObjectAnimator y;
    private ObjectAnimator z;

    public BouncingMapPointer(Context paramContext)
    {
        this(paramContext, null);
    }

    public BouncingMapPointer(Context paramContext, AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, 0);
    }

    public BouncingMapPointer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        this.a = paramContext;
        a(paramAttributeSet);
        d();
        k();
        l();
        e();
    }

    private ObjectAnimator a(View paramView, dd paramdd)
    {
        float f1 = paramdd.getTranslationXFrom();
        float f2 = paramdd.getTranslationYFrom();
        float f3 = paramdd.getScaleXFrom();
        float f4 = paramdd.getScaleYFrom();
        float f5 = paramdd.getTranslationXTo();
        float f6 = paramdd.getTranslationYTo();
        float f7 = paramdd.getScaleXTo();
        float f8 = paramdd.getScaleYTo();
        float f9 = paramdd.getAlphaFrom();
        float f10 = paramdd.getAlphaTo();
        int i1 = paramdd.getDuration();
        TimeInterpolator localTimeInterpolator = paramdd.getTimeInterpolator();
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.M, new float[] { f1, f5 }), PropertyValuesHolder.ofFloat(this.N, new float[] { f2, f6 }), PropertyValuesHolder.ofFloat(SCALE_X, new float[] { f3, f7 }), PropertyValuesHolder.ofFloat(SCALE_Y, new float[] { f4, f8 }), PropertyValuesHolder.ofFloat(ALPHA, new float[] { f9, f10 }) });
        localObjectAnimator.setDuration(i1);
        localObjectAnimator.setInterpolator(localTimeInterpolator);
        return localObjectAnimator;
    }

    private void a(AttributeSet paramAttributeSet)
    {
        TypedArray localTypedArray = this.a.obtainStyledAttributes(paramAttributeSet, a.a.BouncingMapPointer);
        this.g = localTypedArray.getDrawable(0);
        this.h = localTypedArray.getDrawable(1);
        this.f = localTypedArray.getDrawable(2);
        localTypedArray.recycle();
    }

    private void d()
    {
        this.d = new ImageView(this.a);
        this.e = new View(this.a);
        this.e.setId(2131427494);
        this.b = new ImageView(this.a);
        this.c = new ImageView(this.a);
        this.d.setImageDrawable(this.f);
        this.b.setImageDrawable(this.g);
        this.c.setImageDrawable(this.h);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    private void e()
    {
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(1, 1);
        localLayoutParams1.addRule(13);
        addView(this.e, localLayoutParams1);
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams2.addRule(13);
        addView(this.d, localLayoutParams2);
        RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams3.addRule(8, this.e.getId());
        localLayoutParams3.addRule(14);
        addView(this.b, localLayoutParams3);
        RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams4.addRule(8, this.e.getId());
        localLayoutParams4.addRule(1, this.e.getId());
        addView(this.c, localLayoutParams4);
    }

    private void f()
    {
        this.i = new AccelerateInterpolator();
        this.j = new DecelerateInterpolator();
        this.k = new OvershootInterpolator();
    }

    private void g()
    {
        this.L = new dd();
        this.L.setTranslationY(-0.4F, 0.0F);
        this.L.setScaleX(0.6F, 1.0F);
        this.L.setScaleY(0.6F, 1.0F);
        this.L.setDuration(350);
        this.L.setTimeInterpolator(this.i);
        this.L.setAlpha(0.0F, 1.0F);
        this.n = a(this.b, this.L);
        this.n.addListener(new BouncingMapPointer.3(this));
        this.L.clearProperties();
        this.L.setTranslationY(-1.0F, 0.0F);
        this.L.setTranslationX(0.3F, 0.0F);
        this.L.setScaleX(0.6F, 1.0F);
        this.L.setScaleY(0.6F, 1.0F);
        this.L.setDuration(350);
        this.L.setTimeInterpolator(this.i);
        this.L.setAlpha(0.0F, 1.0F);
        this.o = a(this.c, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(0.0F, -0.4F);
        this.L.setDuration(350);
        this.L.setTimeInterpolator(this.j);
        this.l = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(-0.4F, 0.0F);
        this.L.setDuration(350);
        this.L.setTimeInterpolator(this.i);
        this.m = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(0.0F, -0.8F);
        this.L.setTranslationX(0.0F, 0.3F);
        this.L.setScaleX(1.0F, 1.3F);
        this.L.setScaleY(1.0F, 1.4F);
        this.L.setDuration(350);
        this.L.setTimeInterpolator(this.j);
        this.E = a(this.c, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(-0.8F, 0.0F);
        this.L.setTranslationX(0.3F, 0.0F);
        this.L.setScaleX(1.3F, 1.0F);
        this.L.setScaleY(1.4F, 1.0F);
        this.L.setDuration(350);
        this.L.setTimeInterpolator(this.i);
        this.F = a(this.c, this.L);
    }

    private void h()
    {
        this.L.clearProperties();
        this.L.setTranslationY(0.0F, -1.7F);
        this.L.setDuration(550);
        this.L.setTimeInterpolator(this.j);
        this.p = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(-1.7F, 0.5F);
        this.L.setDuration(116);
        this.L.setTimeInterpolator(this.i);
        this.q = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(0.5F, 0.0F);
        this.L.setDuration(200);
        this.L.setTimeInterpolator(this.k);
        this.r = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(0.0F, -2.0F);
        this.L.setTranslationX(0.0F, 0.5F);
        this.L.setScaleX(1.0F, 1.7F);
        this.L.setScaleY(1.0F, 1.8F);
        this.L.setDuration(550);
        this.L.setTimeInterpolator(this.j);
        this.s = a(this.c, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(-2.0F, 0.0F);
        this.L.setTranslationX(0.5F, 0.0F);
        this.L.setScaleX(1.7F, 1.0F);
        this.L.setScaleY(1.8F, 1.0F);
        this.L.setDuration(116);
        this.L.setTimeInterpolator(this.i);
        this.t = a(this.c, this.L);
    }

    private void i()
    {
        this.L.clearProperties();
        this.L.setTranslationY(0.0F, -1.3F);
        this.L.setDuration(175);
        this.L.setTimeInterpolator(this.j);
        this.u = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(-1.3F, -1.2F);
        this.L.setDuration(233);
        this.L.setTimeInterpolator(this.k);
        this.v = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(0.0F, -2.2F);
        this.L.setTranslationX(0.0F, 0.8F);
        this.L.setScaleX(1.0F, 1.5F);
        this.L.setScaleY(1.0F, 1.6F);
        this.L.setDuration(175);
        this.L.setTimeInterpolator(this.j);
        this.w = a(this.c, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(-2.2F, -2.0F);
        this.L.setTranslationX(0.8F, 0.7F);
        this.L.setScaleX(1.5F, 1.4F);
        this.L.setScaleY(1.6F, 1.5F);
        this.L.setDuration(233);
        this.L.setTimeInterpolator(this.k);
        this.x = a(this.c, this.L);
        this.L.clearProperties();
        this.L.setScaleX(0.0F, 1.0F);
        this.L.setScaleY(0.0F, 1.0F);
        this.L.setAlpha(0.0F, 1.0F);
        this.L.setDuration(233);
        this.y = a(this.d, this.L);
        this.y.addListener(new BouncingMapPointer.4(this));
    }

    private void j()
    {
        this.L.clearProperties();
        this.L.setTranslationY(-1.2F, 0.1F);
        this.L.setDuration(116);
        this.z = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(0.1F, 0.0F);
        this.L.setDuration(116);
        this.L.setTimeInterpolator(this.k);
        this.B = a(this.b, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(-2.0F, 0.1F);
        this.L.setTranslationX(0.7F, 0.0F);
        this.L.setScaleX(1.4F, 0.8F);
        this.L.setScaleY(1.5F, 0.8F);
        this.L.setDuration(116);
        this.C = a(this.c, this.L);
        this.L.clearProperties();
        this.L.setTranslationY(0.1F, 0.0F);
        this.L.setScaleX(0.8F, 1.0F);
        this.L.setScaleY(0.8F, 1.0F);
        this.L.setDuration(116);
        this.L.setTimeInterpolator(this.k);
        this.D = a(this.c, this.L);
        this.L.clearProperties();
        this.L.setScaleX(1.0F, 0.0F);
        this.L.setScaleY(1.0F, 0.0F);
        this.L.setAlpha(1.0F, 0.0F);
        this.L.setDuration(233);
        this.A = a(this.d, this.L);
        this.A.addListener(new BouncingMapPointer.5(this));
    }

    private void k()
    {
        f();
        g();
        h();
        i();
        j();
    }

    private void l()
    {
        this.G = new AnimatorSet();
        this.G.play(this.l).before(this.m);
        this.G.play(this.l).with(this.E);
        this.G.play(this.m).with(this.F);
        this.H = new AnimatorSet();
        this.H.play(this.n).with(this.o);
        this.H.play(this.o).before(this.G);
        this.H.setStartDelay(116L);
        this.I = new AnimatorSet();
        this.I.play(this.p).before(this.q);
        this.I.play(this.p).with(this.s);
        this.I.play(this.q).with(this.t);
        this.I.play(this.r).after(this.q);
        this.J = new AnimatorSet();
        this.J.play(this.u).before(this.v);
        this.J.play(this.u).with(this.w);
        this.J.play(this.u).with(this.y);
        this.J.play(this.v).with(this.x);
        this.K = new AnimatorSet();
        this.K.play(this.z).before(this.B);
        this.K.play(this.z).with(this.C);
        this.K.play(this.z).with(this.A);
        this.K.play(this.B).with(this.D);
    }

    public void a()
    {
        this.H.start();
    }

    public void a(int paramInt)
    {
        this.b.setImageResource(paramInt);
    }

    @Deprecated
    public void b()
    {
        if (!c())
        {
            this.J.cancel();
            this.K.start();
        }
    }

    public boolean c()
    {
        return (this.H.isStarted()) || (this.G.isStarted()) || (this.I.isStarted());
    }

    public AnimatorSet getFinalBounceAnimatorSet()
    {
        return this.I;
    }

    public AnimatorSet getPinBounceAnimatorSet()
    {
        return this.G;
    }

    public void setPinVisibility(int paramInt)
    {
        this.b.setVisibility(paramInt);
        this.c.setVisibility(paramInt);
    }*/
}
