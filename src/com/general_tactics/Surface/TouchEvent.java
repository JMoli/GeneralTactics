package com.general_tactics.Surface;
import android.content.Context;
import android.graphics.Point;

/**
 * Created by root on 7/31/13.
 */
public class TouchEvent {

    float dense = 0f;

    private Point Vertice_A_Final = new Point(0,0);

    private void set_Vertice_A_Final(Point p)
    {
        Vertice_A_Final.set(Convert_To_Pixel(p.x), Convert_To_Pixel(p.y));
    }


    //Square
    private Point Vertice_C_Final = new Point(0,0);


    private void set_Vertice_C_Final(Point p)
    {
        Vertice_C_Final.set(Convert_To_Pixel(p.x), Convert_To_Pixel(p.y));
    }

    //Circle
    private int CIRCLE_RADIUS;

    private void set_CIRCLE_RADIUS(int radius)
    {
        CIRCLE_RADIUS = Convert_To_Pixel(radius);
    }

    private double ANGLE = 0.0;
    private void set_ANGLE(double angle)
    {
        ANGLE = angle;
    }


    private int Convert_To_Pixel(int pixel)
    {
        pixel = (int)(pixel * dense);

        return pixel;
    }

    public TouchEvent(Context context)
    {
        dense = context.getResources().getDisplayMetrics().density;
    }

    public TouchEvent(Point pointA, Point pointC, Context context) //Square
    {
        this(context);

        set_Vertice_A_Final(pointA);
        set_Vertice_C_Final(pointC);

    }
    public TouchEvent(Point pointA, int radius, Context context) //Circle
    {
        this(context);

        set_Vertice_A_Final(pointA);
        set_CIRCLE_RADIUS(radius);

    }

    public boolean check_Square(float x, float y)
    {
        int a = (int)x;
        int b = (int)y;

        int X_MIN = Vertice_A_Final.x;
        int Y_MIN = Vertice_A_Final.y;
        int X_MAX = Vertice_C_Final.x;
        int Y_MAX = Vertice_C_Final.y;

        if(a >= X_MIN && a <= X_MAX)
        {
            if(b >= Y_MIN && b <= Y_MAX)
            {
                return true;
            }
        }
        return false;
    }

    public boolean check_Circle(float x, float y)
    {
        int a = (int)x;
        int b = (int)y;

        int distance_X = a - Vertice_A_Final.x;
        int distance_Y = b - Vertice_A_Final.y;
        int distance =(int) Math.pow(distance_X * distance_X + distance_Y * distance_Y, 0.5);

        if (distance <= CIRCLE_RADIUS)
        {

            set_ANGLE(Math.atan2(distance_Y, distance_X)/(Math.PI/180));


            return true;
        }

        return false;
    }

    public int get_Circle_Direction()
    {

        if (ANGLE >= -157.5 && ANGLE < -67.5 ) //Quadrant 1 - 8 or 1
        {
            if(ANGLE  >= -157.5 && ANGLE  < -112.5)
            {
                return 8;
            }
            else{ return 1; }

        }
        if(ANGLE  >= -67.5 && ANGLE  < 22.5 ) //Quadrant 2 - 2 or 3
        {
            if(ANGLE >= -67.5 && ANGLE < -22.5)
            {
                return 2;
            }
            else{ return 3; }
        }
        if(ANGLE  >= 22.5 && ANGLE  < 112.5 )//Quadrant 3 - 4 or 5
        {
            if(ANGLE >= 22.5 && ANGLE < 67.5)
            {
                return 4;
            }
            else { return 5; }

        }
        else //Quadrant 4 - 6 or 7
        {
            if(ANGLE >= 112.5 && ANGLE < 157.5)
            {
                return 6;
            }
            else{ return 7; }

        }

    }

}