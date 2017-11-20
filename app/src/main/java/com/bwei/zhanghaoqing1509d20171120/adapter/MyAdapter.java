package com.bwei.zhanghaoqing1509d20171120.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bwei.zhanghaoqing1509d20171120.MainActivity;
import com.bwei.zhanghaoqing1509d20171120.R;
import com.bwei.zhanghaoqing1509d20171120.bean.JavaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 2017/11/20.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
    Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }
    List<JavaBean.DataBean> list;
    public void addList(List<JavaBean.DataBean> list){
        if (this.list==null){
            this.list = new ArrayList<>();
        }
        this.list.addAll(list);
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_item, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        holder.text_title.setText(list.get(position).getTitle());
        holder.text_price.setText("价格"+list.get(position).getPrice());
        holder.text_time.setText("创建时间"+list.get(position).getCreatetime());
        int i=1;
        String string = null;
        if (i==list.get(position).getStatus()){
            string="已支付";
        }

        holder.text_status.setText(string+"");
        holder.btn_dingdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("确定取消订单吗");
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                          list.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.create().show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private final TextView text_title;
        private final TextView text_price;
        private final TextView text_time;
        private final TextView text_status;
        private final Button btn_dingdan;

        public MyHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.text_title);
            text_price = (TextView) itemView.findViewById(R.id.text_price);
            text_time = (TextView) itemView.findViewById(R.id.text_time);
            text_status = (TextView) itemView.findViewById(R.id.text_status);
            btn_dingdan = (Button) itemView.findViewById(R.id.text_dingdan);


        }
    }
}
