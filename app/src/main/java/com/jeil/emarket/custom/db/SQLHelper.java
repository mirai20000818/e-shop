package com.jeil.emarket.custom.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import com.jeil.emarket.activities.baseactivity.BaseActivity;

/* renamed from: b.f.a.e.b */

public class SQLHelper {


    public static SQLHelper f8842a;


    public static SQLiteDatabase f8843b;


    public static Context f8844c;


    public static a f8845d;

    /* renamed from: b.f.a.e.b$a */
    public static class a extends SQLiteOpenHelper {
        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public SQLHelper() {
        Context context = f8844c;
        f8845d = new a(context, context.getDatabasePath("images.db").getPath(), null, 1);
    }


    public static SQLHelper m4772b() {
        if (f8842a == null) {
            File file = new File(BaseActivity.string + "/images.db");
            File file2 = new File(f8844c.getDatabasePath("images.db").getPath());
            if (!file.exists() && !file2.exists()) {
                return null;
            }
            if (file.exists()) {
                try {
                    FileChannel channel = new FileInputStream(file).getChannel();
                    FileChannel channel2 = new FileOutputStream(f8844c.getDatabasePath("images.db")).getChannel();
                    channel2.transferFrom(channel, 0L, channel.size());
                    channel.close();
                    channel2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            synchronized (DBManager.class) {
                if (f8842a == null) {
                    f8842a = new SQLHelper();
                }
            }
        }
        return f8842a;
    }


    public final synchronized void m4773a() {
        if (f8843b == null) {
            f8843b = f8845d.getReadableDatabase();
        }
    }
}
