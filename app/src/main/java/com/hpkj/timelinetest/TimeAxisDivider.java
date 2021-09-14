package com.hpkj.timelinetest;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


/**
 *  时光轴样式分割线
 */
public class TimeAxisDivider extends RecyclerView.ItemDecoration {

    private static final String TAG = "TimeAxisDivider";
    /**
     * 设置 item  lef他方向的偏移量
     */
    private int leftOffset = 120;
    /**
     * 画的小圆点的半径
     */
    private int circleRadius = 10;
    /**
     * 画的小图标的宽度
     */
    private int iconWidth = 50;
    /**
     * 分割线宽度
     */
    private int dividerLine =1 ;
    private Context context;
    private int padding  ;

    private Paint paint;
    private List<LogisticsInfoBean> dataBeanList;
    public TimeAxisDivider(Context context, List<LogisticsInfoBean> logisticsInfoBeans) {
        this.context = context;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(context.getResources().getColor(R.color.gray_deep));
        paint.setTextSize(16);
        paint.setTextAlign(Paint.Align.RIGHT);
        padding = ScreenUtil.dip2px(context,12);
        this.dataBeanList = logisticsInfoBeans;
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        Log.d(TAG,"----onDraw---");
        canvas.save();
        //先画分割线整体背景色
        canvas.drawColor(context.getResources().getColor(R.color.white));
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            //1.先画 1 px 的竖线
            int startX = leftOffset-30;
            int startY = child.getTop();
            int lineStopY = startY + padding;
            paint.setColor(context.getResources().getColor(R.color.gray_deep));
            //画图形上半部分竖线
            canvas.drawLine(startX,startY,startX,lineStopY,paint);
            //2.画图形
            int positon = parent.getChildAdapterPosition(child);
            LogisticsInfoBean bean = dataBeanList.get(positon);
            Rect dst = new Rect(startX-iconWidth/2,lineStopY,startX+iconWidth/2,lineStopY+iconWidth);
            switch (bean.getStatus()){
                case TIPS:
                    canvas.drawCircle(startX,lineStopY+circleRadius,circleRadius,paint);
                    break;
                case ORDERED:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_order),null,dst,null);
                    break;
                case STOCK_UP:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_stockup),null,dst,null);
                    break;
                case DELIVERED:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_diliver),null,dst,null);
                    break;
                case TRANSPORTING:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_transporting),null,dst,null);
                    break;
                case RECEIVING:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_receive),null,dst,null);
                    break;
                default:
                    canvas.drawCircle(startX,lineStopY+circleRadius,circleRadius,paint);
                    break;
            }
            //画下半部分竖线
            if (positon != dataBeanList.size() -1){
                if (bean.getStatus() == LogisticsStatus.TIPS){
                    canvas.drawLine(startX,lineStopY+2*circleRadius,startX,child.getBottom(),paint);
                }else {
                    canvas.drawLine(startX,lineStopY+iconWidth,startX,child.getBottom(),paint);
                }
            }
            //3.画日期
            canvas.drawText(bean.getDate(),startX-iconWidth/2-10,lineStopY+iconWidth/2,paint);
            canvas.drawText(bean.getTime(),startX-iconWidth/2-10,lineStopY+iconWidth/2+20,paint);

        }


        canvas.restore();
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = leftOffset;
    }
}
