package com.kabalak.tomasz.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

                "  performed      integer" +
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
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = initValues(task);
        db.update("task", values , whereId(task.getId()), null);
    }

    public TaskEntity getTaskById(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from task where id = ? ", new String[]{id + ""});
        TaskEntity task = new TaskEntity();
        task.setId(getInt(cursor, TaskEntity.ID));
        task.setParentId(getInt(cursor, TaskEntity.TASKPARENT));
        task.setTitle(getString(cursor, TaskEntity.TITLE));
        task.setDescriprion(getString(cursor, TaskEntity.DESCRIPTION));
        task.setAddedDate(getString(cursor, TaskEntity.ADDDATE));
        task.setExpiredDate(getString(cursor, TaskEntity.EXPIREDDATE));
        task.setLastEditedDate(getString(cursor, TaskEntity.LASTEDITEDDATE));
        task.setPerformed(getInt(cursor, TaskEntity.PERFORMED));
        return task;
    }

    public void editTask(TaskEntity task){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = initValues(task);
        db.update("task", values , whereId(task.getId()), null);
    }

    public void deleteTask(TaskEntity task){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("task", whereId(task.getId()), null);
    }


    private ContentValues initValues(TaskEntity taskEntity){
        ContentValues values = new ContentValues();
        if (taskEntity != null){
            values.put(TaskEntity.TITLE, taskEntity.getTitle());
            values.put(TaskEntity.DESCRIPTION, taskEntity.getDescriprion());
            values.put(TaskEntity.TASKPARENT, taskEntity.getParentId());
            values.put(TaskEntity.ADDDATE, taskEntity.getAddedDateS());
            values.put(TaskEntity.EXPIREDDATE, taskEntity.getExpiredDateS());
        }
        return values;
    }


//    util method: helpers
    private String whereId(int conditionParam) {
        return TaskEntity.ID + "=" + conditionParam;
    }

    private String getString(Cursor cursor, String colName){
        return cursor.getString(cursor.getColumnIndex(colName));
    }

    private int getInt(Cursor cursor, String colName){
        return cursor.getInt(cursor.getColumnIndex(colName));
    }

}
