package ru.aomikhailov.chessdrawmastercdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
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

    public void insertToDb(String name, String surname, String patronymic, Integer YearOfBirth, Integer rating){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("surname", surname);
        cv.put("patronymic", patronymic);
         cv.put("YearOfBirth", YearOfBirth);
        cv.put("rating", rating);
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
    public List<Player> getFromDbPlayers(ArrayList <String> PlayerToAddOrDelete){
        List<Player> players = new ArrayList<>();
        Cursor cursor = db.query("playerstable", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String surname = cursor.getString(cursor.getColumnIndex("surname"));
            String patronymic = cursor.getString(cursor.getColumnIndex("patronymic"));
            Integer YearOfBirth = cursor.getInt(cursor.getColumnIndex("YearOfBirth"));
            Integer rating = cursor.getInt(cursor.getColumnIndex("rating"));

            if(Collections.binarySearch(PlayerToAddOrDelete, name)>=0)
            {
                players.add(new Player(name, surname, patronymic, YearOfBirth, rating, 0.));
            }
        }
        cursor.close();
        return players;
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
