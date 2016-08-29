package DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hades on 2016/2/22.
 */
public class AiniDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "AINI";

    private static final int version = 1;

    public AiniDatabaseHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //创建库存表
        db.execSQL("CREATE TABLE IF NOT EXISTS storage(id integer primary key autoincrement, " + // 库存的物品id自增长
                "name varchar(20), " + // 物品名
                "count INTEGER)"); // 库存数量

        // 库存使用明细表
        db.execSQL("CREATE TABLE IF NOT EXISTS detail(" +
                "id integer primary key autoincrement, " + // 记录的id
                "count INTEGER, " + // 使用物品数量
                "time INTEGER, " + // 使用时间
                "cid INTEGER" +    // 使用物品id
                "remark varchar(20))"); // 备注

        // 类型表 例如：理发，染发
        db.execSQL("CREATE TABLE IF NOT EXISTS type(id integer primary key autoincrement," + // 类型id
                " name varchar(20))"); // 类型名

        // 账目明细
        db.execSQL("CREATE TABLE IF NOT EXISTS storage(id integer primary key autoincrement, " + // 账目id
                "typeid INTEGER, " + // 类型id
                "time INTEGER, " + //操作时间
                "money FLOAT," +  // 钱
                "isvip INTEGER" +  // 是不是会员
                "vipid INTEGER)"); // 会员id

        // 会员信息表
        db.execSQL("CREATE TABLE IF NOT EXISTS type(id integer primary key autoincrement," + // 类型id
                " name varchar(20)," + // 会员名
                " tel varchar(15))"); // 电话
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
