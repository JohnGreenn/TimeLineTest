package com.hpkj.timelinetest;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TimeDividerActivity extends BaseRvActivity {
    private List<LogisticsInfoBean> dataBeanList = new ArrayList<>();
    private TimeDividerAdapter adapter;
    @Override
    protected void setAdapter() {
        adapter = new TimeDividerAdapter(dataBeanList,this);
        rvCommon.setAdapter(adapter);
    }

    /**
     * 设置分割线样式
     * @return
     */
    @Override
    protected RecyclerView.ItemDecoration setDivider() {
        return new TimeAxisDivider(this,dataBeanList);
    }

    @Override
    public String setTitle() {
        return "时间轴布局" ;
    }

    @Override
    protected void initData() {
        dataBeanList.add(new LogisticsInfoBean("[收货地址，xxxxxxx]",LogisticsStatus.RECEIVING,"02-11","10:00"));
        dataBeanList.add(new LogisticsInfoBean("小主，运输中x1",LogisticsStatus.TRANSPORTING,"02-10","12:00"));
        dataBeanList.add(new LogisticsInfoBean("小主，\n运输中x2",LogisticsStatus.TRANSPORTING,"02-10","12:10"));
        dataBeanList.add(new LogisticsInfoBean("小主，\n\n运输中x3",LogisticsStatus.TRANSPORTING,"02-10","12:20"));
        dataBeanList.add(new LogisticsInfoBean("小主，\n运输中x4",LogisticsStatus.TRANSPORTING,"02-10","12:30"));
        dataBeanList.add(new LogisticsInfoBean("小主，已发货",LogisticsStatus.DELIVERED,"02-10","10:00"));
        dataBeanList.add(new LogisticsInfoBean("小主，备货中",LogisticsStatus.STOCK_UP,"02-09","12:00"));
        dataBeanList.add(new LogisticsInfoBean("订单支付成功，系统正在处理",LogisticsStatus.ORDERED,"02-09","10:10"));
        dataBeanList.add(new LogisticsInfoBean("订单创建成功，等待支付",LogisticsStatus.TIPS,"02-09","10:00"));

        adapter.notifyDataSetChanged();

    }
}
