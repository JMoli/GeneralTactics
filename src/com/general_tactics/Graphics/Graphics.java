package com.general_tactics.Graphics;

import android.content.Context;
import android.opengl.GLU;

import com.general_tactics.Engine.GTEngine;
import com.general_tactics.Graphics.Background.GTBackground;
import com.general_tactics.Graphics.HUD.GCursor;
import com.general_tactics.Graphics.HUD.Buttons;
import com.general_tactics.Graphics.HUD.MotionPad;
import com.general_tactics.Graphics.HUD.GXMarkSpot;
import com.general_tactics.Graphics.Soldier.GBazooka;
import com.general_tactics.R;
import com.general_tactics.States.HUD.Cursor;
import com.general_tactics.States.HUD.XMarkSpot;
import com.general_tactics.States.Soldier.Bazooka;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by root on 8/8/13.
 */
public class Graphics {

    public static final int D_PAD = R.drawable.d_pad;
    public static final int ARROW = R.drawable.arrow;
    public static final int BUTTONS = R.drawable.buttons;
    public static final int BACKGROUND = R.drawable.background_1;
    public static final int X_MARK = R.drawable.xmark;
    public static final int BAZOOKA_SPRITE = R.drawable.bazookasprite;

    private MotionPad MotionPad = new MotionPad();
    private GTBackground Background = new GTBackground();
    private GBazooka play_Bazooka = new GBazooka();
    private GCursor cursor = new GCursor();
    private Buttons buttons = new Buttons();
    private GXMarkSpot mark = new GXMarkSpot();



public void loadTextures(GL10 gl, Context context)
{
    Background.loadTexture(gl, BACKGROUND , context);
    MotionPad.loadTexture(gl, D_PAD, context);
   // cursor.loadTexture(gl, BAZOOKA_SPRITE, context);
    play_Bazooka.loadTexture(gl, BAZOOKA_SPRITE, context);
    buttons.loadTexture(gl, BUTTONS, context);
    mark.loadTexture(gl, X_MARK, context);
}

public void onDraw(GL10 gl)
{

    //clear screen and depth buffer
    gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

    //Draw
    gl.glMatrixMode(GL10.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.glTranslatef(-Cursor.get_cursor_bankpos_x(), -Cursor.get_cursor_bankpos_y(), 0f);
    gl.glMatrixMode(GL10.GL_TEXTURE);
    gl.glLoadIdentity();
    Background.draw(gl);


    gl.glMatrixMode(GL10.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.glPushMatrix();
    gl.glTranslatef(GTEngine.get_SCREEN_ADJUSTMENT(), 0f, 0f);
    gl.glMatrixMode(GL10.GL_TEXTURE);
    gl.glLoadIdentity();
    MotionPad.draw(gl);
    gl.glPopMatrix();

    gl.glMatrixMode(GL10.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.glPushMatrix();
    gl.glTranslatef(-GTEngine.get_SCREEN_ADJUSTMENT(), 0f, 0f);
    gl.glMatrixMode(GL10.GL_TEXTURE);
    gl.glLoadIdentity();
    buttons.draw(gl);
    gl.glPopMatrix();
    gl.glLoadIdentity();

   play_Bazooka.draw(gl, Bazooka.get_bazooka_bankpos_x(), Bazooka.get_bazooka_bankpos_y());

    if(XMarkSpot.isMarked())
    {
        mark.draw(gl);
    }

   // cursor.draw(gl);

}


}
