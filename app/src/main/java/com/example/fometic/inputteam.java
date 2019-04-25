package com.example.fometic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class inputteam extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button button;
    EditText editText;
    EditText textjumlahsquad;
    String teamname;
    int jumlahSquad;
    public static final String kata_kunci = "inadigisport";
    MyDBHandler db=new MyDBHandler(this);
    TeamBola teambola = new TeamBola();



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputteam);

        button = (Button) findViewById(R.id.button6);
        editText = (EditText) findViewById(R.id.namaTeam);
        textjumlahsquad= (EditText) findViewById(R.id.jumlahSquad);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = findViewById(R.id.spinner);
                String formation = spinner.getSelectedItem().toString();

                Spinner spinner2 = findViewById(R.id.spinner5);
                String statusteam=spinner2.getSelectedItem().toString();

                teamname = editText.getText().toString();
                jumlahSquad = Integer.valueOf(textjumlahsquad.getText().toString());
                teambola.setNamaTeam(teamname);
                teambola.setJumlahTeam(jumlahSquad);
                teambola.setFormasiTeam(formation);
                teambola.setStatusTeam(statusteam);
                db.addHandler(teambola);

                //Intent intent2 = new Intent(inputteam.this, inputsquad.class);
                //intent2.putExtra(kata_kunci,teamname);
                //startActivity(intent2);
                openMainActivity();
                Log.d("Data formasi : ", formation);
                Log.d("Data Status : ",statusteam);
            }
        });



    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void inputTeam(String name, String formation, int jumlahTeam, String statusTeam){
        MyDBHandler databaseTeam = new MyDBHandler(this);
        TeamBola teamBola= new TeamBola();
        teamBola.setNamaTeam(name);
        teamBola.setFormasiTeam(formation);
        teamBola.setJumlahAnggotaTeam(jumlahTeam);
        teamBola.setStatusTeam(statusTeam);
        databaseTeam.addHandler(teamBola);
    }
}