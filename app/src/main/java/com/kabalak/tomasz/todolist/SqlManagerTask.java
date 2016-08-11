package com.kabalak.tomasz.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kabalak.tomasz.todolist.dto.TaskEntity;

/**
 * Created by tkabalak on 2016-08-11.
 */
public class SqlManagerTask extends SQLiteOpenHelper {

    public SqlManagerTask(Context context){
        super(context, "task.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable =
                "create table task (" +
                "  id             integer autoincrement," +
                "  taskParent     integer," +

                "  title          text," +
                "  description    text," +

                "  addDate        text," +
                "  lastEditedDate text, " +
                "  expiredDate    text," +

                "  performed      boolean" +
                "  " +
                ")";
        db.execSQL(sqlCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean addTask(TaskEntity task){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = initValues(task);
        db.insertOrThrow("task", null, values);
        return false;
    }

    public void markTaskPerformed(TaskEntity task){


    }




    private ContentValues initValues(TaskEntity taskEntity){
        ContentValues values = new ContentValues();
        if (taskEntity != null){
            values.put("title", taskEntity.getTitle());
            values.put("description", taskEntity.getDescriprion());
            values.put("taskParent", taskEntity.getParentId());
            values.put("addDate", taskEntity.getAddedDateS());
            values.put("expiredDate", taskEntity.getExpiredDateS());
        }
        return values;
    }

}
