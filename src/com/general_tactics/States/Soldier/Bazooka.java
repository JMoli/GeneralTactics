package com.general_tactics.States.Soldier;

import com.general_tactics.Engine.Rules;
import com.general_tactics.States.HUD.XMarkSpot;
import com.general_tactics.States.State;

/**
 * Created by root on 8/9/13.
 */

public class Bazooka {
   private static float moveSpeed = Rules.BAZOOKA_MOVE_SPEED;
    private static float moveSpeedY = 0.0f;
    private static float moveSpeedX = 0.0f;

    public static void set_moveSpeedX(float speedX)
    {
        moveSpeedX = speedX;

    }
    public static void set_moveSpeedY(float speedY)
    {
        moveSpeedY = speedY;
    }
    public static void set_bazooka_bankpos_x()
    {
        if(bazooka_bankpos_x != bazooka_targetpos_x )
        {
            bazooka_bankpos_x += moveSpeedX;
        }
    }

    public static void set_bazooka_bankpos_y()
    {
        if(bazooka_bankpos_y != bazooka_targetpos_y )
        {
            bazooka_bankpos_y += moveSpeedY;
        }

    }

    private static float bazooka_bankpos_y = 0.0f;
    private static float bazooka_bankpos_x = 0.0f;


    public static float get_bazooka_bankpos_x()
    {
        return bazooka_bankpos_x;
    }

    public static float get_bazooka_bankpos_y()
    {
        return bazooka_bankpos_y;
    }

    private static float bazooka_targetpos_x = 0.0f;
    private static float bazooka_targetpos_y = 0.0f;

    public static void set_bazooka_targetpos_x()
    {
        bazooka_targetpos_x = XMarkSpot.get_xMark_bankpos_x();

    }
    public static void set_bazooka_targetpos_y ()
    {
        bazooka_targetpos_y = XMarkSpot.get_xMark_bankpos_y();

    }

    public static float get_bazooka_targetpos_x()
    {
        return bazooka_targetpos_x;
    }

    public static float get_bazooka_targetpos_y()
    {
        return bazooka_targetpos_y;
    }

    public static void setMoving(int i)
    {
        set_bazooka_targetpos_x();
        set_bazooka_targetpos_y();
        switch(i)

        {
            case(Rules._MOVE_N):
                //set_moveSpeedX(0.0f);
                set_moveSpeedY(moveSpeed);
                break;
            case(Rules._MOVE_NE):
                set_moveSpeedX(moveSpeed);
                set_moveSpeedY(moveSpeed);
                break;
            case(Rules._MOVE_E):
                set_moveSpeedX(moveSpeed);
               // set_moveSpeedY(0.0f);
                break;
            case(Rules._MOVE_SE):
                set_moveSpeedX(moveSpeed);
                set_moveSpeedY(-1*(moveSpeed));
                break;
            case(Rules._MOVE_S):
                //set_moveSpeedX(0.0f);
                set_moveSpeedY(-1*(moveSpeed));
                break;
            case(Rules._MOVE_SW):
                set_moveSpeedX(-1*(moveSpeed));
                set_moveSpeedY(-1*(moveSpeed));
                break;
            case(Rules._MOVE_W):
                set_moveSpeedX(-1*(moveSpeed));
                //set_moveSpeedY(0.0f);
                break;
            case(Rules._MOVE_NW):
                set_moveSpeedX(-1*(moveSpeed));
                set_moveSpeedY(moveSpeed);
                break;
            default:
               // set_moveSpeedX(0.0f);
               // set_moveSpeedX(0.0f);
                break;

        }
    }













    public boolean getState()
    {
        return false;
    }

    public boolean isMoving()
    {

        return false;
    }

    public boolean isAttacking()
    {

        return false;
    }

    public boolean isJumping()
    {

        return false;
    }

    public boolean isDying()
    {

        return false;
    }

    public boolean isFalling()
    {
        return false;
    }
}
