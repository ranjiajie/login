package ranjiajie.bwie.com.ranjiajie20171221.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ranjiajie.bwie.com.ranjiajie20171221.R;
import ranjiajie.bwie.com.ranjiajie20171221.bean.LbBean;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class LiebAdapter extends RecyclerView.Adapter<LiebAdapter.Myviewholder> implements View.OnClickListener{
    private List<LbBean.TuijianBean.ListBean> list;
    private OnItemClickListener onItemClickListener = null;
    public LiebAdapter(List<LbBean.TuijianBean.ListBean> list) {
        this.list = list;
    }
    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.liebiao_item,parent,false);
        Myviewholder myviewholder = new Myviewholder(view);
        view.setOnClickListener(this);
        return myviewholder;
    }
    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        String[] split = list.get(position).getImages().split("\\|");
        holder.lieb_img.setImageURI(split[0]);
        holder.price.setText("￥"+list.get(position).getPrice());
        holder.title.setText(list.get(position).getTitle());
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return  list == null ? 0 : list.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            //注意这里使用getTag方法获取position
            onItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    class Myviewholder extends RecyclerView.ViewHolder {
        SimpleDraweeView lieb_img;
        TextView price,title;

        public Myviewholder(View view) {
            super(view);
            lieb_img=view.findViewById(R.id.lieb_img);
            price=view.findViewById(R.id.lie_price);
            title=view.findViewById(R.id.lie_title);
        }
    }
}
