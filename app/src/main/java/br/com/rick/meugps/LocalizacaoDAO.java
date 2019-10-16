package br.com.rick.meugps;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Locale;

public class LocalizacaoDAO {
    private Context context;
    public LocalizacaoDAO(Context context) {
        this.context = context;
    }

    public void insertLocal(Localizacao l){
        LocalizacaoDBHelper dbHelper = new LocalizacaoDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = String.format(
                Locale.getDefault(),
                "INSERT INTO %s (%s, %s, %s) VALUES (%d, %f, %f);",
                HelpDeskContract.LocalizacaoContract.TABLE_NAME,
                HelpDeskContract.LocalizacaoContract.COLUMN_NAME_ID,
                HelpDeskContract.LocalizacaoContract.COLUMN_NAME_LAT,
                HelpDeskContract.LocalizacaoContract.COLUMN_NAME_LON,
                l.getId(),
                l.getLat(),
                l.getLon());
        db.execSQL(sql);
    }

    public ArrayList<Localizacao> busca() {
        LocalizacaoDBHelper dbHelper = new LocalizacaoDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Localizacao> locais = new ArrayList<>();
        String command = String.format(
                Locale.getDefault(),
                "SELECT * FROM %s",
                HelpDeskContract.LocalizacaoContract.TABLE_NAME
        );
        Cursor cursor = db.rawQuery(command, null);
        while (cursor.moveToNext()) {
            int idLocalizacao = cursor.getInt(
                    cursor.getColumnIndex(String.format(Locale.getDefault(),
                            "%s.%s",
                            HelpDeskContract.LocalizacaoContract.TABLE_NAME,
                            HelpDeskContract.LocalizacaoContract.COLUMN_NAME_ID)
                    )
            );
            double lat =
                    cursor.getDouble(cursor.getColumnIndex(
                            String.format(
                                    Locale.getDefault(),
                                    "%s.%s",
                                    HelpDeskContract.LocalizacaoContract.TABLE_NAME,
                                    HelpDeskContract.LocalizacaoContract.COLUMN_NAME_LAT
                            )
                    ));
            double lon =
                    cursor.getDouble(cursor.getColumnIndex(
                            String.format(
                                    Locale.getDefault(),
                                    "%s.%s",
                                    HelpDeskContract.LocalizacaoContract.TABLE_NAME,
                                    HelpDeskContract.LocalizacaoContract.COLUMN_NAME_LON
                            )
                    ));
            Localizacao local = new Localizacao();
            local.setId(idLocalizacao);
            local.setLat(lat);
            local.setLon(lon);
            locais.add(local);
        }
        cursor.close();
        db.close();
        dbHelper.close();
        return locais;
    }
}
