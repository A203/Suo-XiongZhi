package util;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.cn.spotplayer.R;

/**
 * Created by XiaoSuo on 2015-7-13.
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置为没有标题的格式
    }

    //滑动效果一
    public void animPush(){
        overridePendingTransition(R.anim.activity_anim_push_in, R.anim.activity_anim_push_out);
    }

    //滑动效果二
    public void animPop(){
        overridePendingTransition(R.anim.activity_anim_pop_in,R.anim.activity_anim_pop_out);
    }

}
