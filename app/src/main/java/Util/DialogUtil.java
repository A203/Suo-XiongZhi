package Util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by SuoXiongZhi on 2015-7-14.
 */

public class DialogUtil {

    private static AlertDialog.Builder builder = null;

    public static void showDialog(Context context,String title,String message,String positiveBtn){
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveBtn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

}
