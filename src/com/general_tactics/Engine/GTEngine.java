package com.general_tactics.Engine;

/**
 * Created by root on 7/27/13.
 */
import android.graphics.Point;

import com.general_tactics.R;

public class GTEngine {
    public static float DPI = 0.0f;
    private static Point X_MARK_POINT = new Point(0,0);
    private static boolean MARK_X = false;
    public static void set_MARK_X_BOOL(boolean b)
    {
        MARK_X = b;
    }
    public static boolean get_MARK_X_BOOL()
    {
        return MARK_X;
    }
    public static void set_X_MARK(Point p)
    {
        X_MARK_POINT = p;
    }
    public static Point get_X_MARK()
    {
        return X_MARK_POINT;
    }

    private static int playerMoveAction = 0;

    public static void set_playerMoveAction(int action)
    {
        playerMoveAction = action;
    }
    public static int get_playerMoveAction()
    {
        return playerMoveAction;
    }



    public static final float PLAYER_MOVE_SPEED = 0.1f;
    public static final int PLAYER_RELEASE = 5;
    public static final int PLAYER_FRAMES_TO_SPRITE = 9;

    private static int HEIGHT = 0;
    public static void set_SCREEN_HEIGHT(int height)
    {
        HEIGHT = height;
    }
    public static int get_SCREEN_HEIGHT()
    {
        return HEIGHT;
    }
    private static int WIDTH = 0;

    public static void set_SCREEN_WIDTH(int width)
    {
       WIDTH = width;
    }
    public static int get_SCREEN_WIDTH()
    {
        return WIDTH;
    }
    private static float SCREEN_RATIO = 0f;
    public static void set_SCREEN_ADJUSTMENT(float ratio){

        ratio = 1.0f - ratio;
        SCREEN_RATIO = ratio;
    }
    public static float get_SCREEN_ADJUSTMENT()
    {
        return SCREEN_RATIO;
    }

    private static float BAZOOKA_BANKPOS_X = 0;
    public static void set_bazooka_bankpos_x(float x)
    {
        BAZOOKA_BANKPOS_X = x;
    }
    public static float get_bazooka_bankpos_x()
    {
        return BAZOOKA_BANKPOS_X;
    }



    public static final Point JOYSTICK_POINT = new Point(60, 262);
    public static final int JOYSTICK_RADIUS = 60;
    public static final Point BUTTON_A_POINT = new Point(380, 280);
    public static final Point BUTTON_B_POINT = new Point(445, 280);
    public static final Point BUTTON_C_POINT = new Point(445, 220);
    public static final int BUTTON_RADIUS = 30;

    private static float mark_x_bankpos_x = 0f;
    private static float mark_x_bankpos_y = 0f;
    public static void set_mark_x_bankpos_x(float x)
    {
        mark_x_bankpos_x = x;
    }
    public static void set_mark_x_bankpos_y(float y)
    {
        mark_x_bankpos_y = y;
    }
    public static float get_mark_x_bankpos_x()
    {
     return mark_x_bankpos_x;
    }
    public static float get_mark_x_bankpos_y()
    {
        return mark_x_bankpos_y;
    }


}
