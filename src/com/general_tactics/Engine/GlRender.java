package com.general_tactics.Engine;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import com.general_tactics.Graphics.Graphics;


public class GlRender implements GLSurfaceView.Renderer {

	private Context context;
    private Graphics graphics = new Graphics();

	
	public GlRender(Context context)
	{
		this.context = context;
		
	}
	
	@Override
	public void onDrawFrame(GL10 gl)
	{
		graphics.onDraw(gl);
	
	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height)
	{

        GTEngine.set_SCREEN_HEIGHT(height);
        GTEngine.set_SCREEN_WIDTH(width);
        gl.glViewport(0, 0, width, height);
        // make adjustments for screen ratio

       float ratio = (float) width / height;
        GTEngine.set_SCREEN_ADJUSTMENT(ratio);
        gl.glMatrixMode(GL10.GL_PROJECTION);        // set matrix to projection mode
        gl.glLoadIdentity();                        // reset the matrix to its default state
        //GLU.gluPerspective(gl, 45, ratio, 0.1f, 1.f);
        GLU.gluOrtho2D(gl, -ratio, ratio, -1.0f, 1.0f);  // apply the projection matrix

    }


	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config)
	{

        //Load ALL Textures Here
        graphics.loadTextures(gl, context);

        //Starter implementation
		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	

	}

}
