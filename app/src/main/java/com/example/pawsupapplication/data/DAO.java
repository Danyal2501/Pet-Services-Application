package com.example.pawsupapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.pawsupapplication.data.model.PetCard;

import java.util.ArrayList;

public class DAO extends SQLiteOpenHelper {
    public DAO(@Nullable Context context ) {
        super(context, "pawsup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTableStatement = "CREATE TABLE " +
            "PETCARD_TABLE (PetID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Gender TEXT," +
            " Ns Text, Type TEXT, Weight TEXT, Information TEXT, Picture TEXT, UserId INTEGER)";
    db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addPetCard(PetCard pet){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Name", pet.getName());
        cv.put("Gender", pet.getGender());
        cv.put("Ns", pet.getNs());
        cv.put("Type", pet.getType());
        cv.put("Weight", pet.getWeight());
        cv.put("Information", pet.getInformation());
        cv.put("Picture", pet.getProfilePic());
        cv.put("UserId", 1);

        long report = db.insert("PETCARD_TABLE", null, cv);

        return (report != -1);
    }

    public ArrayList<String> getPetsInfo(){
        ArrayList<String> cards = new ArrayList<>();
        String q = "Select * From PETCARD_TABLE";
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

    public ArrayList<String> getPetsPic(){
        ArrayList<String> cards = new ArrayList<>();
        String q = "Select * From PETCARD_TABLE";
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

}
