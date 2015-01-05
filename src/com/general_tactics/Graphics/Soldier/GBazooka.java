package com.general_tactics.Graphics.Soldier;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLU;
import android.opengl.GLUtils;

import com.general_tactics.States.HUD.Cursor;
import com.general_tactics.States.Soldier.Bazooka;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by root on 7/27/13.
 */
public class GBazooka {



    private FloatBuffer vb;
    private FloatBuffer tb;
    private ByteBuffer id;

    private int[] textures = new int[1];

    private float vertices[] = {
            -1.0f,0.5f,0.0f,
            -0.5f,0.5f,0.0f,
            -0.5f,1.0f,0.0f,
            -1.0f,1.0f,0.0f
    };

    private float texture[] = {
            0.0f,0.0f,
            0.0625f,0.0f,
            0.0625f,0.0625f,
            0.0f,0.0625f
    };

    private byte indicies[] ={
            0,1,2,
            0,2,3
    };

    public GBazooka()
    {
        //populate vertex buffer (vb)
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vb = bb.asFloatBuffer();
        vb.put(vertices);
        vb.position(0);

        //populate texture buffer into bb (tb)
        bb = ByteBuffer.allocateDirect(texture.length * 4);
        bb.order(ByteOrder.nativeOrder());
        tb = bb.asFloatBuffer();
        tb.put(texture);
        tb.position(0);

        //populates indexbuffer (id)
        id = bb.allocateDirect(indicies.length);
        id.put(indicies);
        id.position(0);

    }

    public void draw(GL10 gl, float bank_x, float bank_y)
    {
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        GLU.gluLookAt(gl, 0, 0, -5, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        gl.glLoadIdentity();
        gl.glPushMatrix();
        gl.glScalef(0.5f,0.5f, 1f);
        gl.glTranslatef(bank_x, bank_y, 0f);
        gl.glMatrixMode(GL10.GL_TEXTURE);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, 0.0f);

        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

        gl.glFrontFace(GL10.GL_CCW); //directive to only draw front face
        gl.glEnable(GL10.GL_CULL_FACE); //enable cull
        gl.glCullFace(GL10.GL_BACK); //cull back face

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);//enables state
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);//enables state
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vb);//loads verticies into GL
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, tb); //loads texture buffers into GL

        //elements are drawn as triangles, for each indicie, as unsigned, data is the index buffer
        gl.glDrawElements(GL10.GL_TRIANGLES, indicies.length, GL10.GL_UNSIGNED_BYTE, id);

        //final clean up
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);

        gl.glPopMatrix();
        gl.glLoadIdentity();
    }

    public void loadTexture(GL10 gl, int texture, Context context)
    {
       // InputStream is = context.getResources().openRawResource(texture);
        Bitmap bm = null;
        try{
            bm = decodeSampledBitmapFromResource(context.getResources(), texture, 256, 256);
        }finally { //fail gracefully
           // try{
                //is.close();
                //is = null;
           // }catch (IOException e){}
        }
        //(num of textures, array for texture pointer, offset for pointer into array)
        gl.glGenTextures(1, textures, 0);

        //needs separate call for each texture to bind
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

        //indicates how to map the textures
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);


         gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_CLAMP_TO_EDGE);
         gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_CLAMP_TO_EDGE);

        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bm, 0);
        bm.recycle();

    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }


}

