package widget.praisewidget.clickable;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 大灯泡 on 2015/11/21.
 */
public class PraiseClick extends ClickableSpan{
    private static final int DEFAULT_COLOR=0xff517fae;

    private int color;
    private int userID;
    private String userNick;
    private Context mContext;

    public PraiseClick(Context context, String userNick, int userID, int color) {
        mContext = context;
        this.userNick = userNick;
        this.userID = userID;
        this.color = color;
    }

    public PraiseClick(Context context, int userID, int color) {
       this(context,"",userID,color);
    }

    public PraiseClick(Context context, int userID) {
       this(context,"",userID,0);
    }

    public PraiseClick(Context context, String userNick, int userID) {
       this(context,userNick,userID,0);
    }

    @Override
    public void onClick(View widget) {
        Toast.makeText(mContext,"当前用户名是： "+userNick+"   它的ID是： "+userID,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        //去掉下划线
        if (color == 0) {
            ds.setColor(DEFAULT_COLOR);
        } else {
            ds.setColor(color);
        }
        ds.setUnderlineText(false);
    }
}
