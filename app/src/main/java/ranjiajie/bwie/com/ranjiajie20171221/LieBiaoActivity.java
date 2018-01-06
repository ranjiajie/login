package ranjiajie.bwie.com.ranjiajie20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ranjiajie.bwie.com.ranjiajie20171221.adapter.LiebAdapter;
import ranjiajie.bwie.com.ranjiajie20171221.bean.LbBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.lieb.Lbpresents;
import ranjiajie.bwie.com.ranjiajie20171221.view.lieb.Lbview;

public class LieBiaoActivity extends AppCompatActivity implements Lbview {

    @BindView(R.id.lie_recycleview)
    RecyclerView mLieRecycleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_lie_biao);
        ButterKnife.bind(this);
        Lbpresents lbpresents = new Lbpresents(this);
        lbpresents.oncont();
    }
    @Override
    public void showdata(LbBean lbBean) {
        final List<LbBean.TuijianBean.ListBean> list = lbBean.getTuijian().getList();
        LiebAdapter liebAdapter = new LiebAdapter(list);
        mLieRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mLieRecycleview.setAdapter(liebAdapter);
        liebAdapter.setOnItemClickListener(new LiebAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int pid = list.get(position).getPid();
                Intent intent = new Intent(LieBiaoActivity.this, XiangQ.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });
    }
}
