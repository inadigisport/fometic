package com.example.fometic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    public static final String kata_kunci = "inadigisport";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openinputteam();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openinputsquad();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openinputgame();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openchooseteam();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengeneratereport();
            }
        });

    }

    public void openinputteam() {
            Intent intent = new Intent(this, InputTeam.class);
            startActivity(intent);

        }

    public void openinputsquad() {
        Intent intent = new Intent(this, InputSquad.class);
        startActivity(intent);

    }

    public void openinputgame() {
        Intent intent = new Intent(this, InputGame.class);
        startActivity(intent);

    }

    public void openrecordstat() {
        Intent intent = new Intent(this, RecordStat.class);
        startActivity(intent);

    }

    public void opengeneratereport() {
        Intent intent = new Intent(this, GenerateReport.class);
        startActivity(intent);

    }

    public void openchooseteam() {
        Intent intent = new Intent(this, ChooseTeam.class);
        startActivity(intent);

    }
}
