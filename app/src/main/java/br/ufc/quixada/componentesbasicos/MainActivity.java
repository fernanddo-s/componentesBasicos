package br.ufc.quixada.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] ESTADOS = new String[]{"Acre","Alagoas","Amapá","Amazonas","Bahia",
            "Ceará","Distrito Federal","Espirito Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul",
            "Minas Gerais","Pará","Paraíba","Paraná", "Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte",
            "Rio Grande do Sul","Rondônia","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"};

    private Button button1;
    private Button btnSegundaTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView editText = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> estados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ESTADOS);
        editText.setAdapter(estados);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //Navegação para a segunda tela
        btnSegundaTela = (Button) findViewById(R.id.btnSegundaTela);
        btnSegundaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SegundaTela.class);
                startActivity(intent1);
            }
        });

    }

}