package com.general_tactics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class SoldierAnt {
	
	private FloatBuffer vertexBuffer;
	private FloatBuffer textureBuffer;
	private int[] texturePointer = new int[1];
	private float vertices[] = {
			
			-0.75f, 0.0f, 0.0f,
			-0.75f, 1.0f, 0.0f,
			0.0f, 0.0f, 0.0f,
			0.0f, 1.0f, 0.0f
		
	};
	private float texture[] =
			{
			-0.75f, 1.0f,
			-0.75f, 0.0f, 
			0.0f, 1.0f, 
			0.0f, 0.0f
			
			};

	
	public SoldierAnt()
	{
		//Creates a direct byte buffer based on a newly allocated memory block.
		ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
		
		//Returns the byte order used by this buffer when converting bytes from/to other primitive types.
		bb.order(ByteOrder.nativeOrder());
		
		//Returns a float buffer which is based on the remaining content of this byte buffer.
		vertexBuffer = bb.asFloatBuffer();
		
		//Writes all the remaining floats of the src float buffer to this buffer's current position, 
		// and increases both buffers' position by the number of floats copied.
		vertexBuffer.put(vertices);
		
		vertexBuffer.position(0);
		
		
		bb = ByteBuffer.allocateDirect(texture.length * 4);
		bb.order(ByteOrder.nativeOrder());
		textureBuffer = bb.asFloatBuffer()	;
		textureBuffer.put(texture);
		textureBuffer.position(0);		
	}
	
	public void loadGLTexture(GL10 gl, Context context)
	{
		Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.s_ant);
		
		gl.glGenTextures(1, texturePointer, 0);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texturePointer[0]);
		
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
		
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0 , bm, 0);
		bm.recycle();
		
		
	}
	
	public void draw(GL10 gl)
	{
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texturePointer[0]);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		
		gl.glFrontFace(GL10.GL_CW);
		
		
		//(int size, int type, int stride, Buffer pointer)
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
		
		//Draw the vertices as a triangle strip
		// (int mode, int first, int count)
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);
		
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		
	}

}
