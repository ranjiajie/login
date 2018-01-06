package ranjiajie.bwie.com.ranjiajie20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ranjiajie.bwie.com.ranjiajie20171221.bean.DlBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.dengl.Dlpresents;
import ranjiajie.bwie.com.ranjiajie20171221.view.dengl.Dlview;

public class MainActivity extends AppCompatActivity implements Dlview{

    @BindView(R.id.dl_name)
    EditText mDlName;
    @BindView(R.id.dl_pass)
    EditText mDlPass;
    @BindView(R.id.dengl)
    Button mDengl;
    @BindView(R.id.d_zhuce)
    Button mDZhuce;
    private Dlpresents dlpresents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dlpresents = new Dlpresents(this);
    }

    @OnClick({R.id.dengl, R.id.d_zhuce})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.dengl:
                String s = mDlName.getText().toString();
                String s1 = mDlPass.getText().toString();
                dlpresents.oncont(s,s1);
                break;
            case R.id.d_zhuce:
                Intent intent = new Intent(this, Zhuce.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showdata(DlBean dlBean) {
        if (dlBean.getMsg().toString().equals("登录成功")){
            Toast.makeText(this,dlBean.getMsg().toString(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, LieBiaoActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this,dlBean.getMsg().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
