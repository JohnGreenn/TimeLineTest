package com.hpkj.timelinetest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * desc：
 * author：Glq
 * time：2021/09/13 15:34
 */
public class TimeDividerAdapter extends RecyclerView.Adapter<TimeDividerAdapter.ViewHolder> {
    private final Context context;
    private List<LogisticsInfoBean> items;

    /**
     *  事件监听
     */
    private onItemClickListener onItemClickListener;
    private onItemLongClickListener onItemLongClickListener;

    public interface onItemClickListener{
        void  onItemClick(View view, int position);
    }
    public interface onItemLongClickListener{
        void  onItemLongClick(View view, int position);
    }

    public void  setOnItemClickListener (onItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public void  setOnItemLongClickListener (onItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 构造函数
     * @param items
     * @param context
     */
    public TimeDividerAdapter(List<LogisticsInfoBean> items, Context context) {
        this.items = items;
        this.context = context;
    }

    /**
     * 实例化 ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);

        return new ViewHolder(v);
    }

    /**
     * 更新 View 内容
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        LogisticsInfoBean item = items.get(position);
        holder.tvItem.setText(item.getMessage());
        holder.llLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener !=null){
                    onItemClickListener.onItemClick(view,position);
                }
            }
        });

        holder.llLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onItemLongClickListener !=null){
                    onItemLongClickListener.onItemLongClick(view,position);
                }
                return true;
            }
        });
    }

    /**
     * 获取 item 的总数
     * @return
     */
    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        //@BindView(R.id.tv_item)
        TextView tvItem;
        //@BindView(R.id.ll_layout)
        LinearLayout llLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
            llLayout = itemView.findViewById(R.id.ll_layout);

            //ButterKnife.bind(this,itemView);
        }
    }

}
