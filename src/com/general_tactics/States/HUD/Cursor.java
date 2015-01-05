package com.general_tactics.States.HUD;

import com.general_tactics.Engine.GTEngine;
import com.general_tactics.Engine.Rules;

import java.util.zip.CRC32;

/**
 * Created by root on 8/9/13.
 */
public class Cursor {


    private static int cursorMoveAction = 0;
    public static void set_CursorDirection(int action)
    {
        cursorMoveAction = action;
    }
    public static int get_MoveAction()
    {
        return cursorMoveAction;
    }

    private static float CURSOR_BANKPOS_X = 0;
    public static void set_cursor_bankpos_x(float x)
    {
        if (x <= 3.6 + GTEngine.get_SCREEN_ADJUSTMENT() &&  x >= -3.6 + GTEngine.get_SCREEN_ADJUSTMENT())
        {
            CURSOR_BANKPOS_X = x;
        }

    }
    public static float get_cursor_bankpos_x()
    {
        return CURSOR_BANKPOS_X;
    }

    private static float CURSOR_BANKPOS_Y = 0;
    public static void set_cursor_bankpos_y(float y)
    {
        if (y <= 3.5  &&  y >= -3.8  )
        {
            CURSOR_BANKPOS_Y = y;
        }

    }
    public static float get_cursor_bankpos_y()
    {
        return CURSOR_BANKPOS_Y;
    }



    public static void isMoving(int direction)
    {
        switch(direction)
        {
            case(Rules._MOVE_N):
                set_cursor_bankpos_y(get_cursor_bankpos_y() + Rules.CURSOR_MOVE_SPEED);
                break;
            case(Rules._MOVE_NE):
                set_cursor_bankpos_x(get_cursor_bankpos_x() + Rules.CURSOR_MOVE_SPEED);
                set_cursor_bankpos_y(get_cursor_bankpos_y() + Rules.CURSOR_MOVE_SPEED);
                break;
            case(Rules._MOVE_E):
                set_cursor_bankpos_x(get_cursor_bankpos_x() + Rules.CURSOR_MOVE_SPEED);
                break;
            case(Rules._MOVE_SE):
                set_cursor_bankpos_x(get_cursor_bankpos_x() + Rules.CURSOR_MOVE_SPEED);
                set_cursor_bankpos_y(get_cursor_bankpos_y() - Rules.CURSOR_MOVE_SPEED);
                break;
            case(Rules._MOVE_S):
                set_cursor_bankpos_y(get_cursor_bankpos_y() - Rules.CURSOR_MOVE_SPEED);
                break;
            case(Rules._MOVE_SW):
                set_cursor_bankpos_x(get_cursor_bankpos_x() - Rules.CURSOR_MOVE_SPEED);
                set_cursor_bankpos_y(get_cursor_bankpos_y() - Rules.CURSOR_MOVE_SPEED);
                break;
            case(Rules._MOVE_W):
                set_cursor_bankpos_x(get_cursor_bankpos_x() - Rules.CURSOR_MOVE_SPEED);
                break;
            case(Rules._MOVE_NW):
                set_cursor_bankpos_x(get_cursor_bankpos_x() - Rules.CURSOR_MOVE_SPEED);
                set_cursor_bankpos_y(get_cursor_bankpos_y() + Rules.CURSOR_MOVE_SPEED);
                break;
            default:

                break;

        }

    }

}
