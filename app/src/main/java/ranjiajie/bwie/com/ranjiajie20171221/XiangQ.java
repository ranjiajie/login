package ranjiajie.bwie.com.ranjiajie20171221;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ranjiajie.bwie.com.ranjiajie20171221.bean.XqBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.xqpresent.Xqpresents;
import ranjiajie.bwie.com.ranjiajie20171221.view.xqview.Xqview;

public class XiangQ extends AppCompatActivity implements Xqview{

    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.xq_price)
    TextView mXqPrice;
    @BindView(R.id.xq_title)
    TextView mXqTitle;
    @BindView(R.id.jiaru)
    Button mJiaru;
    private Xqpresents xqpresents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_q);
//        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        int pid = intent.getIntExtra("pid", 1);
        xqpresents = new Xqpresents(this);
        xqpresents.oncont(pid);
    }

//    @Subscribe(sticky = true)
//    public void helloEventBus(Pidevent pidevent) {
//        Log.i("===", "helloEventBus"+pidevent.getPid());
//        String s = Integer.toString(pidevent.getPid());
//    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.jiaru)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.jiaru:
                Intent intent = new Intent(XiangQ.this, Gouwuche.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showdata(XqBean xqBean) {
        XqBean.DataBean data = xqBean.getData();
        String[] split = data.getImages().split("\\|");
        List<String> list=new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        mBanner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Uri uri = Uri.parse((String) path);
                imageView.setImageURI(uri);
            }
            //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
            @Override
            public ImageView createImageView(Context context) {
                //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
                SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
                return simpleDraweeView;
            }
        }).start();
        mXqPrice.setText(data.getPrice());
        mXqTitle.setText(data.getTitle());
    }
}
