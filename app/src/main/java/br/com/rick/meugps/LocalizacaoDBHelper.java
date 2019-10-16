package br.com.rick.meugps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalizacaoDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "materias.db";
    private static final int DB_VERSION = 1;
    LocalizacaoDBHelper (Context context){
        super (context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HelpDeskContract.createTableLocalizacao());

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        db.execSQL(HelpDeskContract.LocalizacaoContract.DROP_TABLE);
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int a, int b) {
    }
}
