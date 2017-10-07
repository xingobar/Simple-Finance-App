package com.example.administrator.ufinance;

import android.content.ContentValues;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/10/6.
 */

public class AddFinanceActivity extends AppCompatActivity {

    private EditText dateEdit;
    private EditText descriptionEdit;
    private EditText moneyEdit;
    private DBHelper dbHelper;
    private Button addBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "teststsetse", Toast.LENGTH_SHORT).show();
                //addFinance(v);
                try{
                    String date = dateEdit.getText().toString();
                    String description = descriptionEdit.getText().toString();
                    int money = Integer.parseInt(moneyEdit.getText().toString());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("cdate",date);
                    contentValues.put("info",description);
                    contentValues.put("amount",money);
                    long id = dbHelper.getWritableDatabase().insert("exp",null,contentValues);
                    Log.d("_id", String.valueOf(id));
                    Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),String.valueOf(id),Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("error","Error");
                }
            }
        });
      //  dbHelper = new DBHelper(this,"finance.db",null,1);
        dbHelper = DBHelper.getInstance(this);
    }

    /*
    *   元件初始化
    * */
    private void initView()
    {
        dateEdit = (EditText)findViewById(R.id.dateEdit);
        descriptionEdit = (EditText)findViewById(R.id.descriptionEdit);
        moneyEdit = (EditText)findViewById(R.id.moneyEdit);
        addBtn = (Button)findViewById(R.id.addFinance);
    }

    public void addFinance(View view)
    {
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateEdit.getText().toString();
            String description = descriptionEdit.getText().toString();
            int money = Integer.parseInt(moneyEdit.getText().toString());
            ContentValues contentValues = new ContentValues();
            contentValues.put("date_time", formatter.format(date));
            contentValues.put("description",description);
            contentValues.put("money",money);
            long id = dbHelper.getWritableDatabase().insert("finance",null,contentValues);
            Log.d("_id", String.valueOf(id));
            Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),String.valueOf(id),Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("error",ex.getMessage());
        }

    }
}
