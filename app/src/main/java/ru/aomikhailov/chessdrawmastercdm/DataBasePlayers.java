package ru.aomikhailov.chessdrawmastercdm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBasePlayers extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "databaseplayers5.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "playerstable";

    public static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SURNAME = "surname";
    private static final String COLUMN_PATRONYMIC = "patronymic";
    private static final String COLUMN_YEAR_OF_BIRTH = "YearOfBirth";
    private static final String COLUMN_MALE = "male";

    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_NAME = 1;
    private static final int NUM_COLUMN_SURNAME = 2;
    private static final int NUM_COLUMN_PATRONYMIC = 3;
    private static final int NUM_COLUMN_YEAR_OF_BIRTH = 4;
    private static final int NUM_COLUMN_MALE = 5;

    public DataBasePlayers(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME+ " TEXT, " +
                COLUMN_SURNAME + " TEXT, " +
                COLUMN_PATRONYMIC + " TEXT,"+
                COLUMN_YEAR_OF_BIRTH + " INT,"+
                COLUMN_MALE+" INT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
