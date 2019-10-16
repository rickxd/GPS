package br.com.rick.meugps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaLocaisActivity extends AppCompatActivity {
    LocalizacaoDAO dao;
    private ArrayList<Localizacao> lista;
    private ListView locaisListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);
        dao = new LocalizacaoDAO(this);
        locaisListView = findViewById(R.id.locaisListView);
        Intent origemIntent = getIntent();
        lista = dao.busca();
        ArrayAdapter<Localizacao> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        locaisListView.setAdapter(adapter);

        locaisListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intent = new Intent (ListaChamadosActivity.this, DetalhesChamadoActivity.class );
                //intent.putExtra("chamado_escolhido", chamados.get(position));
                //startActivity(intent);
                Uri gmmIntentUri = Uri.parse("geo:"+lista.get(position));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
