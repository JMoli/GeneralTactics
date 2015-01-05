package com.general_tactics.States;

import com.general_tactics.States.HUD.Cursor;
import com.general_tactics.States.HUD.XMarkSpot;
import com.general_tactics.States.Soldier.Bazooka;

/**
 * Created by root on 8/9/13.
 */
public class State {

    public static void isJoy(int i)
    {
        Cursor.isMoving(i);
        Bazooka.setMoving(i);
    }

    public static void isClickingA()
    {

    }

    public static void isClickingB()
    {


    }

    public static void isClickingC()
    {


    }

    public static void isDoubleClicking()
    {


    }

    public static void isHolding()
    {


    }

    public static int getDirection(float xBank, float yBank, float xTarget, float yTarget)
    {
        int a = Math.abs((int)xBank);
        int b = Math.abs((int)yBank);
        int c = Math.abs((int)xTarget);
        int d = Math.abs((int)yTarget);

        int distance_X = c - a;
        int distance_Y = d - b;
        int distance =(int) Math.pow(distance_X * distance_X + distance_Y * distance_Y, 0.5);

        double ANGLE = Math.atan2(distance_X, distance_Y)/(Math.PI/180);
        //double ANGLE = Math.acos(distance) * 180.0 / Math.PI;


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
