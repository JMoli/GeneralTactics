package com.general_tactics.States.HUD;


/**
 * Created by root on 8/9/13.
 */
public class XMarkSpot {

    private static float xMark_bankpos_x = 0f;
    private static float xMark_bankpos_y = 0f;
    public static void set_xMark_bankpos_x()
    {
        xMark_bankpos_x = Cursor.get_cursor_bankpos_x();
    }
    public static void set_xMark_bankpos_y()
    {
        xMark_bankpos_y = Cursor.get_cursor_bankpos_y();
    }

    public static float get_xMark_bankpos_x()
    {
        return xMark_bankpos_x;
    }
    public static float get_xMark_bankpos_y()
    {
        return xMark_bankpos_y;
    }
    private static boolean isMarked = false;

    public static void set_Mark(boolean b)
    {
        set_xMark_bankpos_y();
        set_xMark_bankpos_x();
        isMarked = b;
    }

    public static boolean isMarked()
    {
        return isMarked;
    }




}
