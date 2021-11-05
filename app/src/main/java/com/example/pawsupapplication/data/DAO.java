package com.example.pawsupapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.pawsupapplication.data.model.History;
import com.example.pawsupapplication.data.model.LoggedInUser;
import com.example.pawsupapplication.data.model.PetCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DAO extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pawsup.db";

    public DAO(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement1 = "CREATE TABLE " +
                "USER_TABLE (UserID INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT, Id TEXT)";
        db.execSQL(createTableStatement1);
        String createTableStatement2 = "CREATE TABLE " +
                "PETCARD_TABLE (PetID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Gender TEXT," +
                " Ns Text, Type TEXT, Weight TEXT, Information TEXT, Picture TEXT, Email TEXT)";
        db.execSQL(createTableStatement2);
        String createTableStatement3 = "CREATE TABLE " +
                "HISTORY_TABLE (HisID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Amount INTEGER," +
                " Price Text, Date TEXT, Image TEXT, Email TEXT)";
    db.execSQL(createTableStatement3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "USER_TABLE");
        db.execSQL("DROP TABLE IF EXISTS " + "PETCARD_TABLE");
        db.execSQL("DROP TABLE IF EXISTS " + "HISTORY_TABLE");
        onCreate(db);
    }

    public boolean addUser(LoggedInUser user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("email", user.getEmail());
        cv.put("password", user.getPassword());
        cv.put("Id", user.getUserId());

        long report = db.insert("USER_TABLE", null, cv);

        return (report != -1);
    }

    public Map<String,ArrayList<String>> getUsers(){
        Map<String,ArrayList<String>> users = new HashMap<>();
        String q = "Select * From USER_TABLE";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(q, null);

        if(cursor.moveToFirst()){
            do{
                //int ID = cursor.getInt(0);
                String email = cursor.getString(1);
                String password = cursor.getString(2);
                String UserId = cursor.getString(3);

                ArrayList<String> userInfo = new ArrayList<>();
                userInfo.add(password);
                userInfo.add(UserId);

                users.put(email, userInfo);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return users;
    }

    public boolean addPetCard(PetCard pet, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Name", pet.getName());
        cv.put("Gender", pet.getGender());
        cv.put("Ns", pet.getNs());
        cv.put("Type", pet.getType());
        cv.put("Weight", pet.getWeight());
        cv.put("Information", pet.getInformation());
        cv.put("Picture", pet.getProfilePic());
        cv.put("Email", email);

        long report = db.insert("PETCARD_TABLE", null, cv);

        return (report != -1);
    }

    public ArrayList<String> getPetsInfo(String email){
        ArrayList<String> cards = new ArrayList<>();
        String q = "Select * From PETCARD_TABLE Where Email = \"" + email + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(q, null);

        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(1);
                String gender = cursor.getString(2);
                String ns = cursor.getString(3);
                String type = cursor.getString(4);
                String weight = cursor.getString(5);
                String information = cursor.getString(6);
               // String picture = cursor.getString(7);

                String card = "Name: " + name + "\n Gender: " + gender +
                        "\n Neutered/Spayed: " + ns + "\nType: " + type +
                        "\nWeight: " + weight + "\nInformation: " + information;

                cards.add(card);
            }while (cursor.moveToNext());
        }

    cursor.close();
        db.close();
        return cards;
    }

    public ArrayList<String> getPetsPic(String email){
        ArrayList<String> cards = new ArrayList<>();
        String q = "Select * From PETCARD_TABLE Where Email = \"" + email + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(q, null);

        if(cursor.moveToFirst()){
            do{
                String pic = cursor.getString(7);
                // String picture = cursor.getString(7);



                cards.add(pic);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return cards;
    }
    
    public boolean addHistory(History his, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Name", his.getName());
        cv.put("Amount", his.getAmount());
        cv.put("Price", his.getPrice());
        cv.put("Date", his.getDate());
        cv.put("Image", his.getImage());
        cv.put("Email", email);

        long report = db.insert("HISTORY_TABLE", null, cv);

        return (report != -1);
    }

    public ArrayList<String> getHistoryInfo(String email){
        ArrayList<String> cards = new ArrayList<>();
        String q = "Select * From HISTORY_TABLE Where Email = \"" + email + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(q, null);

        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(1);
                int amount = cursor.getInt(2);
                String price = cursor.getString(3);
                String date = cursor.getString(4);
                // String picture = cursor.getString(7);

                String card = "Transaction: " + name + "\nAmount: " + amount +
                        "\nPrice $: " + price + "\nDate: " + date;

                cards.add(card);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return cards;
    }


    public ArrayList<String> getHistoryPic(String email){
        ArrayList<String> cards = new ArrayList<>();
        String q = "Select * From HISTORY_TABLE Where Email = \"" + email + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(q, null);

        if(cursor.moveToFirst()){
            do{
                String pic = cursor.getString(5);
                // String picture = cursor.getString(7);



                cards.add(pic);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return cards;
    }

}
