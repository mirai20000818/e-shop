package com.jeil.emarket.custom.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.jeil.emarket.custom.CustomString;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: b.f.a.e.a */

public class DBManager {


    public static DBManager dbManager;


    public static SQLiteDatabase sqLiteDatabase;


    public static MySqlite mySqlite;


    public static Context context;

    /* renamed from: b.f.a.e.a$a */
    public static class MySqlite extends SQLiteOpenHelper {
        public MySqlite(Context context, java.lang.String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE cache(id INTEGER PRIMARY KEY,name TEXT,value TEXT,expired_at DATETIME DEFAULT CURRENT_TIMESTAMP)");
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cache");
            onCreate(sQLiteDatabase);
        }
    }

    public DBManager() {
        mySqlite = new MySqlite(context, "jeil_market.db", null, 1);
    }


    public static DBManager getDB() {
        if (dbManager == null) {
            synchronized (DBManager.class) {
                if (dbManager == null) {
                    dbManager = new DBManager();
                }
            }
        }
        return dbManager;
    }


    public java.lang.String Delete(java.lang.String str) {
        initReadable();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        StringBuilder m3163a = CustomString.format("DELETE FROM cache WHERE expired_at <> '' AND expired_at < '");
        m3163a.append(simpleDateFormat.format(new Date()));
        m3163a.append("'");
        sqLiteDatabase.execSQL(m3163a.toString());
        Cursor rawQuery = sqLiteDatabase.rawQuery("SELECT value FROM cache WHERE name = '" + str + "'", null);
        @SuppressLint("Range") java.lang.String string = rawQuery.moveToFirst() ? rawQuery.getString(rawQuery.getColumnIndex("value")) : "";
        rawQuery.close();
        return string;
    }


    public final synchronized void initReadable() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = mySqlite.getReadableDatabase();
        }
    }


    public void update(java.lang.String str, java.lang.String str2, int i) {
        java.lang.String sb;
        getWritable();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("value", str2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        StringBuilder m3163a = CustomString.format("DELETE FROM cache WHERE expired_at <> '' AND expired_at < '");
        m3163a.append(simpleDateFormat.format(new Date()));
        m3163a.append("'");
        sqLiteDatabase.execSQL(m3163a.toString());
        Cursor rawQuery = sqLiteDatabase.rawQuery("SELECT value FROM cache WHERE name = '" + str + "'", null);
        @SuppressLint("Range") java.lang.String string = rawQuery.moveToFirst() ? rawQuery.getString(rawQuery.getColumnIndex("value")) : "";
        rawQuery.close();
        if (i < 0) {
            contentValues.put("expired_at", simpleDateFormat.format(Long.valueOf(new Date().getTime() + 7200000)));
        }
        if (i == 0) {
            contentValues.put("expired_at", "");
        } else {
            contentValues.put("expired_at", simpleDateFormat.format(Long.valueOf(new Date().getTime() + i)));
        }
        if (string.isEmpty()) {
            sqLiteDatabase.insert("cache", null, contentValues);
            return;
        }
        if (i > 0) {
            StringBuilder m3163a2 = CustomString.format("UPDATE cache SET value = '");
            m3163a2.append(contentValues.getAsString("value"));
            m3163a2.append("', ");
            m3163a2.append("expired_at");
            m3163a2.append(" = '");
            m3163a2.append(contentValues.getAsString("expired_at"));
            m3163a2.append("' WHERE ");
            m3163a2.append("name");
            m3163a2.append(" = '");
            m3163a2.append(contentValues.getAsString("name"));
            m3163a2.append("'");
            sb = m3163a2.toString();
        } else {
            StringBuilder m3163a3 = CustomString.format("UPDATE cache SET value = '");
            m3163a3.append(contentValues.getAsString("value"));
            m3163a3.append("' WHERE ");
            m3163a3.append("name");
            m3163a3.append(" = '");
            m3163a3.append(contentValues.getAsString("name"));
            m3163a3.append("'");
            sb = m3163a3.toString();
        }
        sqLiteDatabase.execSQL(sb);
    }


    public final synchronized void getWritable() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = mySqlite.getWritableDatabase();
        }
    }
}
