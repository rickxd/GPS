package br.com.rick.meugps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaLocaisActivity extends AppCompatActivity {

    private ArrayList<String> lista;
    private ListView locaisListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);
        locaisListView = findViewById(R.id.locaisListView);
        Intent origemIntent = getIntent();
        lista = origemIntent.getStringArrayListExtra("lista_locais");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        locaisListView.setAdapter(adapter);

    }

    /*
    locaisListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent (ListaChamadosActivity.this, DetalhesChamadoActivity.class );
            intent.putExtra("chamado_escolhido", chamados.get(position));
            startActivity(intent);
        }
    });
     */
}
