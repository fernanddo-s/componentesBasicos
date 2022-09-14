package br.ufc.quixada.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {

    GridView gridView;
    String[] numero = new String[39];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        for(int i = 0; i < numero.length; i++){
            numero[i] = " número "+i;
        }

        gridView = (GridView)findViewById(R.id.gridView);
        ArrayAdapter<String> adpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numero);
        gridView.setAdapter(adpter);
    }
}