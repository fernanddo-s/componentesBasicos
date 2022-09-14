package br.ufc.quixada.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaTela extends AppCompatActivity {
    private ListView lvSelecoesCopa;
    private Button buttonMusic;
    private Button buttonStopMusic;
    private Button buttonTelaTabs;
    MediaPlayer musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        musica = MediaPlayer.create(this, R.raw.musica);

        TextView txtView = (TextView) findViewById(R.id.txtView);
        txtView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),
                        "\n" +
                                "Você pressionou por muito tempo", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Não presionou por tempo suficiente",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //Como criar um ArrayAdapter dentro de uma ListView
        lvSelecoesCopa = (ListView) findViewById( R.id.lvSelecoesCopa );

        String itens[] = { "Alemanha", "Argentina", "Holanda", "Colombia",
                "Belgica", "Uruguai", "Brasil" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this,
                android.R.layout.simple_list_item_1, itens );

        lvSelecoesCopa.setAdapter( adapter );

        lvSelecoesCopa.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                tratarOpcoesItem( arg2 );
            }
        } );

        //Tocar musica
        buttonMusic = (Button) findViewById(R.id.buttonStartMusic);
        buttonMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musica.start();
            }
        });

        //Parar de tocar musica
        buttonStopMusic = (Button) findViewById(R.id.buttonStopMusic);
        buttonStopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musica.stop();
            }
        });


        //Navegação para a tela de tabs
        buttonTelaTabs = (Button) findViewById(R.id.btnTelaTabs);
        buttonTelaTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTelaTabs = new Intent(getApplicationContext(), ActivityTabs.class);
                startActivity(intentTelaTabs);
            }
        });

        //Navegação para a tela de Grid View
        Button buttonTelaGridView = (Button) findViewById(R.id.btnTelaGridView);
        buttonTelaGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTelaGridView = new Intent(getApplicationContext(), GridViewActivity.class);
                startActivity(intentTelaGridView);
            }
        });
    }


    protected void tratarOpcoesItem(int posicao) {
        int posFifa = posicao + 1;
        Toast.makeText( this, "Posição no Ranking: " + posFifa , Toast.LENGTH_LONG ).show();
    }
}