package com.sanwenyu.stemplate.db;

import com.sanwenyu.stemplate.app.AppApplication;
import com.sanwenyu.stemplate.db.dao.DaoMaster;
import com.sanwenyu.stemplate.db.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * <pre>
 *     author: lzc
 *     time  : 2020/1/27
 *     desc  :今年过年躲避新型冠状病毒，感觉宅着真好呀
 * </pre>
 *
 */

public class DbHelper {
    /** 数据库是否加密的标识 */
    public static final boolean ENCRYPTED = true;

    private DaoSession mDaoSession;

    private DbHelper() {
        createDao();
    }

    private static class SingletonHolder {
        private static final DbHelper INSTANCE = new DbHelper();
    }

    //获取单例
    public static DbHelper getInstance() {
        return DbHelper.SingletonHolder.INSTANCE;
    }


    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    private void createDao(){
        //创建数据库
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(AppApplication.getAppicationContext(), ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        //获取数据库读写的权限，如果进行加密调用helper.getEncryptedWritableDb("super-secret")，参数为设置的密码
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }


}