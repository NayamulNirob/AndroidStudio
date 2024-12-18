package com.labs.healthify;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper{

public static final String DATABASE_NAME = "healthify.db";
    public static final int DATABASE_VERSION = 1;

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text , email text , password text)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "create table cart(username text,product text,price float,otype text )";
        sqLiteDatabase.execSQL(qry2);

        String qry3 = "create table orderplace(username text,name text,address text,connum text , pin int , date text , time text , amount float,otype text)";
        sqLiteDatabase.execSQL(qry3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void register(String username , String email , String password){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }




    public int login(String username , String password){
        int result=0;
        String[] str =new String[]{username, password};
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        c.close();
        return result;
    }

    public void addCart(String username , String product , float price , String otype){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("product",product);
        cv.put("price",price);
        cv.put("otype",otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart",null,cv);
        db.close();
    }

    public int checkCart(String username,String product){
        int result=0;
        String[] str = new String[]{username,product};
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart where username=? and product=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        c.close();
        return result;
    }


    public void removeCart(String username , String otype){
        String[] str =new String[]{username,otype};
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart","username=? and otype=?",str);
        db.close();
    }

    public void addOrder(String username , String name , String address , String connum ,int pin , String date , String time , float price , String otype ){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("name",name);
        cv.put("address",address);
        cv.put("connum",connum);
        cv.put("pin",pin);
        cv.put("date",date);
        cv.put("time",time);
        cv.put("amount",price);
        cv.put("otype",otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("orderplace",null,cv);
        db.close();
    }

    public ArrayList<String> getCartData(String username , String otype){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] str = new String[]{username,otype};
        Cursor c = db.rawQuery("select * from cart where username=? and otype=?",str);
        if (c.moveToFirst()){
            do {
                String product = c.getString(1);
                String price = c.getString(2);
                arr.add(product+"$"+price);
            }while (c.moveToNext());
        }
        c.close();
        return arr;
    }




    public ArrayList<String> getOrderData(String username){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] str = new String[]{username};
        Cursor c = db.rawQuery("select * from orderplace where username = ?",str);
        if (c.moveToFirst()){
            do {
                arr.add(c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getString(4)+"$"+c.getString(5)+"$"+c.getString(6)+"$"+c.getString(7)+"$"+c.getString(8));
            }while (c.moveToNext());
        }
        c.close();
        return arr;
    }




    public int checkappontmentExists(String username , String ed1 , String ed2 , String ed3 , String date , String time){
        int result = 0;
        String[] str =new String[]{username,ed1,ed2,ed3,date,time};

        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.rawQuery("select * from orderplace where username=? and ed1=? and ed2=? and ed3=? and date=? and time=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        c.close();
        return result;
    }

    public User getUser(String username) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=?", new String[]{username});
        User user = null;
        if (c.moveToFirst()) {
            user = new User(c.getString(0), c.getString(1), c.getString(2));
        }
        c.close();
        return user;
    }

}
