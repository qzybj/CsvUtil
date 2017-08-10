package com.brady.csvutil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brady.csvutil.model.ProductInfo;
import com.brady.csvutil.util.CsvHelper;
import com.brady.libutil.view.ViewUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    private View rootView;
    private TextView tv_show;
    private Button btn_import;
    private Button btn_export;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI(){
        rootView = getWindow().getDecorView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tv_show = ViewUtil.getView(rootView,R.id.tv_show);
        btn_import = ViewUtil.getView(rootView,R.id.btn_import);
        btn_export = ViewUtil.getView(rootView,R.id.btn_export);

        btn_import.setOnClickListener(this);
        btn_export.setOnClickListener(this);

        fab = ViewUtil.getView(rootView,R.id.fab);
        fab.setOnClickListener(this);
    }

    private void initData(){

    }

    @Override
    public void onClick(View view) {
        if(fab == view){
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }else if(btn_import == view){
            showData();
        }else if(btn_export == view){
            CsvHelper.export2CSV(getProductList(1000));
        }
    }

    private void showData() {
        String filePath = CsvHelper.getCacheFilePath("20170809"+"182708");
        List<ProductInfo> list = CsvHelper.importCSV(filePath);
        if(list!=null){
            StringBuilder sb = new StringBuilder();
            for (ProductInfo item : list) {
                sb.append(item.getName());
                sb.append(CsvHelper.CSV_SEPARATOR_SYMBOL);
                sb.append(item.getProperty());
                sb.append(CsvHelper.CSV_SEPARATOR_SYMBOL);
                sb.append(item.getArtNo());
                sb.append(CsvHelper.CSV_SEPARATOR_SYMBOL);
                sb.append(item.getBarcode());
                sb.append(CsvHelper.NEW_LINE_SYMBOL);
            }
            tv_show.setText(sb.toString());
        }
    }

    private List<ProductInfo> getProductList(int size) {
        List<ProductInfo> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ProductInfo item = new ProductInfo();
            item.setName("name"+i);
            item.setProperty("property"+i);
            item.setArtNo("artNo"+i);
            item.setBarcode("barCode"+i);

            list.add(item);
        }
        return list;
    }
}