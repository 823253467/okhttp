package com.bwei.zhanghaoqing1509d20171120;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bwei.zhanghaoqing1509d20171120.adapter.MyAdapter;
import com.bwei.zhanghaoqing1509d20171120.bean.JavaBean;
import com.bwei.zhanghaoqing1509d20171120.presenter.MyPresenter;
import com.bwei.zhanghaoqing1509d20171120.view.MyView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView {

    private RecyclerView recyclerView;
    private MyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewid);

        presenter = new MyPresenter(this);
        presenter.add("71","1","1","android");

    }

    @Override
    public void getData(JavaBean bean) {
        Log.i("----",bean.getMsg());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter adapter = new MyAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);

        List<JavaBean.DataBean> list = bean.getData();
        adapter.addList(list);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.cancal();
    }
}
