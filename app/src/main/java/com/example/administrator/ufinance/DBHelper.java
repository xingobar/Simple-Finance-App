package com.example.administrator.ufinance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.DhcpInfo;

/**
 * Created by Administrator on 2017/10/6.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static  DBHelper instance = null;

    public static DBHelper getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new DBHelper(context,"finance.db",null,1);
        }
        return instance;
    }

    private DBHelper(Context context,
                     String name,// 資料庫檔案名稱
                     SQLiteDatabase.CursorFactory factory,
                     int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // 建立資料表
        db.execSQL("CREATE  TABLE main.exp " +
                "(_id INTEGER PRIMARY KEY  NOT NULL , " +
                "cdate DATETIME NOT NULL , " +
                "info VARCHAR, " +
                "amount INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
