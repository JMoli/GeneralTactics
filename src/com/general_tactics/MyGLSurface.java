package com.general_tactics;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import com.general_tactics.Engine.GTEngine;
import com.general_tactics.Engine.GlRender;
import com.general_tactics.States.HUD.Cursor;
import com.general_tactics.States.State;
import com.general_tactics.Surface.TouchEvent;

/**
 * Created by root on 7/20/13.
 */
class MyGLSurface extends GLSurfaceView
{
    private Context context;
   // Point dPad_MIN = new Point(0,190);
   // Point dPad_MAX = new Point(140,320);
   // TouchEvent dPad ;

    TouchEvent joystick;
    TouchEvent ButtonA;
    TouchEvent ButtonB;
    TouchEvent ButtonC;


    public MyGLSurface(Context context, float dense)
    {
        super(context);
        this.context = context;
        setRenderer(new GlRender(context));
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        joystick = new TouchEvent(GTEngine.JOYSTICK_POINT, GTEngine.JOYSTICK_RADIUS, context);
        ButtonA = new TouchEvent(GTEngine.BUTTON_A_POINT, GTEngine.BUTTON_RADIUS, context);
        ButtonB = new TouchEvent(GTEngine.BUTTON_B_POINT, GTEngine.BUTTON_RADIUS, context);
        ButtonC = new TouchEvent(GTEngine.BUTTON_C_POINT, GTEngine.BUTTON_RADIUS, context);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
       // int index = MotionEventCompat.getActionIndex(event);
        if(joystick.check_Circle(event.getX(), event.getY()))
        {

            State.isJoy(joystick.get_Circle_Direction());
        }

        if(ButtonA.check_Circle(event.getX(), event.getY()))
        {
            State.isClickingA();
        }
        if(ButtonB.check_Circle(event.getX(), event.getY()))
        {

        }
        if(ButtonC.check_Circle(event.getX(), event.getY()))
        {

        }
        this.requestRender();
        return true;
    }


}

