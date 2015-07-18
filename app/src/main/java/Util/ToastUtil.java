package Util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by SuoXiongZhi on 2015-7-14.
 */
public class ToastUtil{

    private static Toast toast = null;

    public static void TextShowLong(Context context,String string){
        toast.makeText(context,string,Toast.LENGTH_LONG).show();
    }
    public static void TextShowShort(Context context,String string){
        toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }

}
