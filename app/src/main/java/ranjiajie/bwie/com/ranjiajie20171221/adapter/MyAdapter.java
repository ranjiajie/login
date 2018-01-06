package ranjiajie.bwie.com.ranjiajie20171221.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import ranjiajie.bwie.com.ranjiajie20171221.R;
import ranjiajie.bwie.com.ranjiajie20171221.bean.DataBean;
import ranjiajie.bwie.com.ranjiajie20171221.dingyi.AddDeleteView;
import ranjiajie.bwie.com.ranjiajie20171221.event.MessageEvent;
import ranjiajie.bwie.com.ranjiajie20171221.event.PriceAndCountEvent;
import ranjiajie.bwie.com.ranjiajie20171221.event.SomeId;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class MyAdapter  extends BaseExpandableListAdapter {
    private Context context;
    private List<DataBean> groupList;
    private List<List<DataBean.ListBean>> childList;
    public MyAdapter(Context context, List<DataBean> groupList, List<List<DataBean.ListBean>> childList) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
    }
    @Override
    public int getGroupCount() {
        return groupList.size();
    }
    @Override
    public int getChildrenCount(int i) {
        return childList.get(i).size();
    }
    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }
    @Override
    public Object getChild(int i, int i1) {
        return childList.get(i).get(i1);
    }
    @Override
    public long getGroupId(int i) {
        return i;
    }
    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        final GroupViewHolder holder;
        if (view == null) {
            holder = new GroupViewHolder();
            view = View.inflate(context, R.layout.group_item, null);
            holder.cbGroup = (CheckBox) view.findViewById(R.id.cb_parent);
            holder.tv_number = (TextView) view.findViewById(R.id.tv_number);
            view.setTag(holder);
        } else {
            holder = (GroupViewHolder) view.getTag();
        }
        final DataBean dataBean = groupList.get(i);
        holder.cbGroup.setChecked(dataBean.isChecked());
        holder.tv_number.setText(dataBean.getSellerName());
        //一级checkbox
        holder.cbGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBean.setChecked(holder.cbGroup.isChecked());
                changeChildCbState(i, holder.cbGroup.isChecked());
                EventBus.getDefault().post(compute());
                changeAllCbState(isAllGroupCbSelected());
                notifyDataSetChanged();
            }
        });
        return view;
    }
    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        final ChildViewHolder holder;
        if (view == null) {
            holder = new ChildViewHolder();
            view = View.inflate(context, R.layout.zi_item, null);
            holder.cbChild = (CheckBox) view.findViewById(R.id.cb_child);
            holder.tv_tel = (TextView) view.findViewById(R.id.tv_tel);
            holder.draweeView = (SimpleDraweeView) view.findViewById(R.id.my_image_view);
            holder.tv_price = (TextView) view.findViewById(R.id.tv_pri);
            holder.tv_del = (TextView) view.findViewById(R.id.tv_del);
            holder.adv = (AddDeleteView) view.findViewById(R.id.adv_main);
            view.setTag(holder);
        } else {
            holder = (ChildViewHolder) view.getTag();
        }
        final DataBean.ListBean datasBean = childList.get(i).get(i1);

        holder.cbChild.setChecked(datasBean.isChecked());
        holder.tv_tel.setText(datasBean.getTitle());
        holder.tv_price.setText("￥" + datasBean.getPrice());
        holder.adv.setNumber(datasBean.getNum());
        String images = datasBean.getImages().trim();
        String[] split = images.split("[|]");
        holder.draweeView.setImageURI(split[0]);

/*
* fresco缓存
* */
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        Uri parse = Uri.parse(split[0]);
        boolean inMemoryCache = imagePipeline.isInBitmapMemoryCache(parse);
        holder.draweeView.getDrawingCache(inMemoryCache);

        //二级checkbox
        holder.cbChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置该条目对象里的checked属性值
                datasBean.setChecked(holder.cbChild.isChecked());
                PriceAndCountEvent priceAndCountEvent = compute();
                EventBus.getDefault().post(priceAndCountEvent);
                if (holder.cbChild.isChecked()) {
                    //当前checkbox是选中状态
                    if (isAllChildCbSelected(i)) {
                        changGroupCbState(i, true);
                        changeAllCbState(isAllGroupCbSelected());
                    }
                } else {
                    changGroupCbState(i, false);
                    changeAllCbState(isAllGroupCbSelected());
                }
                notifyDataSetChanged();
            }
        });
        holder.adv.setOnAddDelClickListener(new AddDeleteView.OnAddDelClickListener() {
            @Override
            public void onAddClick(View v) {
                int origin = holder.adv.getNumber();
                origin++;
                int num = datasBean.getNum();
                num++;
                holder.adv.setNumber(num);
                datasBean.setNum(num);
                if (holder.cbChild.isChecked()) {
                    EventBus.getDefault().post(compute());
                }
            }
            @Override
            public void onDelClick(View v) {
                int origin = holder.adv.getNumber();
                origin--;
                if (origin == 0) {
                    Toast.makeText(context, "最小数量为1", Toast.LENGTH_SHORT).show();
                    return;
                }
                holder.adv.setNumber(origin);
                datasBean.setNum(origin);
                if (holder.cbChild.isChecked()) {

                    EventBus.getDefault().post(compute());
                }

            }
        });
        //删除
        holder.tv_del.setOnClickListener(new View.OnClickListener() {

            private AlertDialog dialog;

            @Override
            public void onClick(View v) {
                final List<DataBean.ListBean> datasBeen = childList.get(i);


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("提示");
                builder.setMessage("确认是否删除？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ii) {
                        DataBean.ListBean remove = datasBeen.remove(i1);
                        if (datasBeen.size() == 0) {
                            childList.remove(i);
                            groupList.remove(i);
                            int pid = datasBean.getPid();
                            SomeId someId = new SomeId();
                            someId.setPid(pid + "");
                            EventBus.getDefault().post(someId);
                        }
                        EventBus.getDefault().post(compute());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class GroupViewHolder {
        CheckBox cbGroup;
        TextView tv_number;
    }

    class ChildViewHolder {
        CheckBox cbChild;
        TextView tv_tel;
        SimpleDraweeView draweeView;
        TextView tv_price;
        TextView tv_del;
        AddDeleteView adv;
    }
    /**
     * 改变全选的状态
     *
     * @param flag
     */
    private void changeAllCbState(boolean flag) {
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setChecked(flag);
        EventBus.getDefault().post(messageEvent);
    }
    /**
     * 改变一级列表checkbox状态
     *
     * @param groupPosition
     */
    private void changGroupCbState(int groupPosition, boolean flag) {
        DataBean dataBean = groupList.get(groupPosition);
        dataBean.setChecked(flag);
        notifyDataSetChanged();
    }
    /**
     * 改变二级列表checkbox状态
     *
     * @param groupPosition
     * @param flag
     */
    private void changeChildCbState(int groupPosition, boolean flag) {
        List<DataBean.ListBean> datasBeen = childList.get(groupPosition);
        for (int i = 0; i < datasBeen.size(); i++) {
            DataBean.ListBean datasBean = datasBeen.get(i);
            datasBean.setChecked(flag);
        }
        notifyDataSetChanged();
    }
    /**
     * 判断一级列表是否全部选中
     *
     * @return
     */
    private boolean isAllGroupCbSelected() {
        for (int i = 0; i < groupList.size(); i++) {
            DataBean dataBean = groupList.get(i);
            if (!dataBean.isChecked()) {
                return false;
            }
            notifyDataSetChanged();
        }
        return true;
    }
    /**
     * 判断二级列表是否全部选中
     *
     * @param groupPosition
     * @return
     */
    private boolean isAllChildCbSelected(int groupPosition) {
        List<DataBean.ListBean> datasBeen = childList.get(groupPosition);

        for (int i = 0; i < datasBeen.size(); i++) {
            DataBean.ListBean datasBean = datasBeen.get(i);

            if (!datasBean.isChecked()) {
                return false;
            }
            notifyDataSetChanged();
        }
        return true;
    }
    /**
     * 计算列表中，选中的钱和数量
     */
    private PriceAndCountEvent compute() {
        int count = 0;
        int price = 0;
        for (int i = 0; i < childList.size(); i++) {
            List<DataBean.ListBean> datasBeen = childList.get(i);
            for (int j = 0; j < datasBeen.size(); j++) {
                DataBean.ListBean datasBean = datasBeen.get(j);
                if (datasBean.isChecked()) {
                    price += datasBean.getNum() * datasBean.getPrice();
                    count += datasBean.getNum();
                }
            }
        }
        PriceAndCountEvent priceAndCountEvent = new PriceAndCountEvent();
        priceAndCountEvent.setCount(count);
        priceAndCountEvent.setPrice(price);
        return priceAndCountEvent;
    }
    /**
     * 设置全选、反选
     * @param flag
     */
    public void changeAllListCbState(boolean flag) {
        for (int i = 0; i < groupList.size(); i++) {
            changGroupCbState(i, flag);
            changeChildCbState(i, flag);
        }
        EventBus.getDefault().post(compute());
        notifyDataSetChanged();
    }
}
