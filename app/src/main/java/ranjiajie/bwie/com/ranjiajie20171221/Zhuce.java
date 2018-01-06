package ranjiajie.bwie.com.ranjiajie20171221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ranjiajie.bwie.com.ranjiajie20171221.bean.ZcBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.zhuc.Zcpresents;
import ranjiajie.bwie.com.ranjiajie20171221.view.zhuc.Zcview;

public class Zhuce extends AppCompatActivity implements Zcview {

    @BindView(R.id.zc_name)
    EditText mZcName;
    @BindView(R.id.zc_pass)
    EditText mZcPass;
    @BindView(R.id.zhuce)
    Button mZhuce;
    private Zcpresents zcpresents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
        zcpresents = new Zcpresents(this);
    }
    @OnClick(R.id.zhuce)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zhuce:
                String s = mZcName.getText().toString();
                String s1 = mZcPass.getText().toString();
                zcpresents.oncont(s,s1);
                break;
        }
    }
    @Override
    public void showmsg(ZcBean zcBean) {
        Toast.makeText(this,zcBean.getMsg().toString(),Toast.LENGTH_SHORT).show();
        if (zcBean.getMsg().toString().equals("注册成功")){
            finish();
        }else {
            Toast.makeText(this,zcBean.getMsg().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
