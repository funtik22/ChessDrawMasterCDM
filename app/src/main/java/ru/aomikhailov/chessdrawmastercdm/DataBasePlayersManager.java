package ru.aomikhailov.chessdrawmastercdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;


public class DataBasePlayersManager {

    private Context context;
    private DataBasePlayers dbPlayers;
    private SQLiteDatabase db;


    public DataBasePlayersManager(Context context){
        this.context = context;
        dbPlayers = new DataBasePlayers(context);
    }

    public void openDb(){
        db = dbPlayers.getWritableDatabase();
    }

    public void insertToDb(String name, String surname, String patronymic, Integer YearOfBirth){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("surname", surname);
        cv.put("patronymic", patronymic);
         cv.put("YearOfBirth", YearOfBirth);
       // cv.put("male", male);
        db.insert("playerstable", null, cv);
    }

    public List<String> getFromDb(){
        List<String> names = new ArrayList<>();
        Cursor cursor = db.query("playerstable", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            names.add(name);
        }
        cursor.close();
        return names;
    }

    public int NumEntries(){
        Cursor cursor = db.query("playerstable", null, null, null, null, null, null);
        int k = 0;
        while (cursor.moveToNext()){
            k++;
        }
        return k;
    }

    public void delete(String name){
        db.delete("playerstable", "name" + " = ?", new String[] { String.valueOf(name) });
    }


    public void closeDb(){
        dbPlayers.close();
    }


}
