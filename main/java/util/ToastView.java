package util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by SuoXIongZhi on 2015-7-13.
 */

public class ToastView {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    /**
     * 较长时间显示提示
     *
     * @param s 显示信息
     */
    public static void toastLong(String s) {
        Toast.makeText(mContext, s, Toast.LENGTH_LONG).show();
    }

    /**
     * 较短时间显示提示
     *
     * @param s 显示信息
     */
    public static void toastShort(String s) {
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * 较短时间显示提示
     *
     * @param res 显示信息
     */
    public static void toastShort(int res) {
        toastShort(mContext.getString(res));
    }

    /**
     * 较长时间显示提示
     *
     * @param res 显示信息
     */
    public static void toastLong(int res) {
        toastLong(mContext.getString(res));
    }

}
