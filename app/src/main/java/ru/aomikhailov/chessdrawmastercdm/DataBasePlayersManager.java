package ru.aomikhailov.chessdrawmastercdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void insertToDb(String name, String surname, String patronymic, Integer YearOfBirth, String male){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("surname", surname);
        cv.put("patronymic", patronymic);
        cv.put("YearOfBirth", YearOfBirth);
      //  cv.put("male", male);
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
    public void closeDb(){
        dbPlayers.close();
    }


}
