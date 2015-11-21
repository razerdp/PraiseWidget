package widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;
import widget.praisewidget.widget.PraiseWidget;
import widget.praisewidget.R;
import widget.praisewidget.bean.PraiseBean;

public class Demo extends AppCompatActivity implements View.OnClickListener{
    private List<PraiseBean> testBeans;

    private PraiseWidget mPraiseWidget;
    private Button mAddButton;
    private Button mSubButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mPraiseWidget.setDataByArray(testBeans);
    }

    private void initView() {
        mPraiseWidget= (PraiseWidget) findViewById(R.id.praise_widget);
        mAddButton= (Button) findViewById(R.id.btn_add);
        mSubButton= (Button) findViewById(R.id.btn_sub);

        mAddButton.setOnClickListener(this);
        mSubButton.setOnClickListener(this);
    }

    private void initData() {
        testBeans=new ArrayList<PraiseBean>();
        for (int i=0;i<50;i++){
            PraiseBean bean=new PraiseBean();
            bean.userNick="测试点赞 "+i+" 号";
            bean.userId=i;
            testBeans.add(bean);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PraiseWidget.clearPraiseWidgetCache();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                add();
                break;
            case R.id.btn_sub:
                sub();
                break;
            default:
                break;
        }

    }

    private void sub() {
        if (testBeans!=null&&testBeans.size()>0){
            testBeans.remove(testBeans.size()-1);
        }
        mPraiseWidget.setDataByArray(testBeans);
    }

    private void add() {
        if (testBeans!=null){
            PraiseBean newBean=new PraiseBean();
            newBean.userId=testBeans.size()+1;
            newBean.userNick="新加入的哦";
            testBeans.add(newBean);
        }
        mPraiseWidget.setDataByArray(testBeans);
    }
}
