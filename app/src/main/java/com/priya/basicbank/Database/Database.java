package com.priya.basicbank.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper
{
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public Database(@Nullable Context context) {
        super(context, "User.db1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db1.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db1.execSQL("insert into user_table values(1234567890,'Akriti',1000.00,'akriti00@gamil.com','XXXXXXXXXXXX6421','NSP01234567')");
        db1.execSQL("insert into user_table values(8877666666,'Aisha',24000.00,'aish77@gmail.com','XXXXXXXXXXXX6528','IOP36749102')");
        db1.execSQL("insert into user_table values(9876543210,'Aaron',10900.00,'aaron123gmail.com','XXXXXXXXXXXX7451','PSB12345678')");
        db1.execSQL("insert into user_table values(9373753282,'Sheetal',40440.00,'dshe12@gmail.com','XXXXXXXXXXXX5201','INP00000001')");
        db1.execSQL("insert into user_table values(8989898989,'Naman',1340.00,'naman89@gmail.com','XXXXXXXXXXXX7433','SBI82826374')");
        db1.execSQL("insert into user_table values(9898988998,'Tulika',1234.00,'tulika55@gmail.com','XXXXXXXXXXXX5214','SBI76419201')");
        db1.execSQL("insert into user_table values(1265333333,'Vikas',635421.00,'VikasKumar@gmail.com','XXXXXXXXXXXX3021','NSP73624102')");
        db1.execSQL("insert into user_table values(5372728283,'Kartik ',1500.00,'Kartik5@gmail.com','XXXXXXXXXXXX5734','SBI72016565')");
        db1.execSQL("insert into user_table values(2746832928,'Shivam',5000.00,'shiv20@gmail.com','XXXXXXXXXXXX3496','IOP55551111')");
        db1.execSQL("insert into user_table values(7436732873, 'Vini',7010.00,'vinisharma@gmail.com','XXXXXXXXXXXX4593','IOP77667766')");
        db1.execSQL("insert into user_table values(7174647393,'Shweta',81382.00,'shweta42@gmail.com','XXXXXXXXXXXX4893','PIN88778877')");
        db1.execSQL("insert into user_table values(2374308457,'Naina',7384.00,'naina76@gmail.com','XXXXXXXXXXXX4533','PIN12890324')");
        db1.execSQL("insert into user_table values(2163934747,'Disha',27623.00,'disha7@gmail.com','XXXXXXXXXXXX1593','NSP774628103')");
        db1.execSQL("insert into user_table values(2376378474,'Krish',1111.00,'K1rish@gmail.com','XXXXXXXXXXXX4693','NSP662514378')");
        db1.execSQL("insert into user_table values(8326421038,'Sonam',2839.00,'sonam41@gmail.com','XXXXXXXXXXXX4693','SBI76767688')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {
        db1.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db1.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db1);
    }

    public Cursor readalldata(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor cursor = db1.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor cursor = db1.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor cursor = db1.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db1 = this.getWritableDatabase();
        db1.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor cursor = db1.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db1.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}