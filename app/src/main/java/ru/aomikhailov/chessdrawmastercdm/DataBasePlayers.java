package ru.aomikhailov.chessdrawmastercdm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBasePlayers extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "databaseplayers6.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "playerstable";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SURNAME = "surname";
    private static final String COLUMN_PATRONYMIC = "patronymic";
    private static final String COLUMN_YEAR_OF_BIRTH = "YearOfBirth";
    private static final String COLUMN_RATING = "rating";
    private static final String COLUMN_MALE = "male";

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
                COLUMN_RATING + " INT,"+
                COLUMN_MALE+" INT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
