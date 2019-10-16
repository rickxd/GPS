package br.com.rick.meugps;

import android.provider.BaseColumns;

public class HelpDeskContract {
    private HelpDeskContract(){}

    public static class LocalizacaoContract implements BaseColumns {
        public static final String TABLE_NAME = "tb_localizacao";
        public static final String COLUMN_NAME_ID = "id_localizacao";
        public static final String COLUMN_NAME_LAT = "lat";
        public static final String COLUMN_NAME_LON = "lon";

        public static final String DROP_TABLE = String.format("DROP TABLE %s", LocalizacaoContract.TABLE_NAME);
    }

    public static String createTableLocalizacao (){
        return String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s REAL, %s REAL);",
                LocalizacaoContract.TABLE_NAME,
                LocalizacaoContract.COLUMN_NAME_ID,
                LocalizacaoContract.COLUMN_NAME_LAT,
                LocalizacaoContract.COLUMN_NAME_LON);
    }
}
