package com.kabalak.tomasz.todolist.dto;

import java.util.Date;

/**
 * Created by Wiesiek on 2016-08-11.
 */
public class TaskEntity {
    private int id;

    private int parentId;

    private String title;
    private String descriprion;

    private String addedDate;
    private String lastEditedDate;
    private String expiredDate;

    private boolean isPerformed;


    public static Date createDate(String encodedDate){
        return new Date(new Long(encodedDate));
    }

    public static String  dateToString(Date date){
        return ((Long) date.getTime()).toString();
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }


    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setLastEditedDate(String lastEditedDate) {
        this.lastEditedDate = lastEditedDate;
    }


    //get as string
    public String getAddedDateS() {
        return addedDate;
    }

    public String getLastEditedDateS() {
        return lastEditedDate;
    }

    public String getExpiredDateS() {
        return expiredDate;
    }


    // get as Date
    public Date getAddedDateD() {
        return createDate(addedDate);
    }

    public Date getLastEditedDateD() {
        return createDate(lastEditedDate);
    }

    public Date getExpiredDateD() {
        return createDate(expiredDate);
    }




    public boolean isPerformed() {
        return isPerformed;
    }

    public void setPerformed(boolean performed) {
        isPerformed = performed;
    }


}
