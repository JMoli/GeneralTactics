package com.general_tactics.Engine;

import android.opengl.GLU;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by root on 8/21/13.
 */
public class Camera {

    //Constants
    private static float zoomSpeed = 0.2f;
    private static float moveSpeed = 0.2f;

    //Fields
    private static float eyeX = 0.0f;
    private static float eyeY = 0.0f;
    private static float eyeZ = 2.0f;
    private static float centerX = 0.0f;
    private static float centerY = 0.0f;
    private static float centerZ = 0.0f;
    private static float upX = 0.0f;
    private static float upY = 1.0f;
    private static float upZ = 0.0f;

    private static float zoom = 45.0f;


    //Getter Setter
    public static void setEyeX(){}
    public static float getEyeX()
    {
        return eyeX;
    }
    public static void setEyeY(){}
    public static float getEyeY()
    {
        return eyeY;
    }
    public static void setEyeZ(){}
    public static float getEyeZ()
    {
        return eyeZ;
    }

    public static void setCenterX(){}
    public static float getCenterX()
    {
        return centerX;
    }
    public static void setCenterY(){}
    public static float getCenterY()
    {
        return centerY;
    }
    public static void setCenterZ(){}
    public static float getCenterZ()
    {
        return centerZ;
    }

    public static void setUpX(){}
    public static float getUpX()
    {
        return upX;
    }
    public static void setUpY(){}
    public static float getUpY()
    {
        return upY;
    }
    public static void setUpZ(){}
    public static float getUpZ()
    {
        return upZ;
    }

    public static void setZoom(float z)
    {
        zoom = z;
    }
    public static float getZoom()
    {
        return zoom;
    }



    //Methods


    public static void draw(GL10 gl)
    {
        GLU.gluPerspective(gl, 180, 3, 0, 180);

    }

    public static void lookRight()
    {
        centerX -= moveSpeed;
    }

    public static void lookLeft()
    {
        centerX += moveSpeed;
    }

    public static void lookUp()
    {
        centerY += moveSpeed;
    }

    public static void lookDown()
    {
        centerY -= moveSpeed;
    }

    public static void moveLeft()
    {
        eyeX -= moveSpeed;
    }

    public static void moveRight()
    {
        eyeX += moveSpeed;
    } //translate +x

    public static void moveUp()
    {
        eyeY += moveSpeed;
    } //translate  +y

    public static void moveDown()
    {
        eyeY -= moveSpeed;
    } //translate -y

    public static void moveFor()
    {
        eyeZ += moveSpeed;
    }//translate +z

    public static void moveBack()
    {
        eyeZ -= moveSpeed;
    } //translate -z

    public static void zoomIn()
    {
        zoom += zoomSpeed;
        setZoom(zoom);
    }

    public static void zoomOut()
    {
        zoom -= zoomSpeed;
        setZoom(zoom);

    }


}