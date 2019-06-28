package com.example.fometic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class choosegeneratereport extends AppCompatActivity {
    String teamA;
    String teamB;
    ArrayList<String > cetakgoalteama = new ArrayList<>();
    ArrayList<String > cetakgoalteamb = new ArrayList<>();
    String formationteama;
    String formationteamb;
    String venue;
    String event;
    int ballpossesionteama;
    int ballpossesionteamb;
    int passingteama;
    int passingteamb;
    int tacklingteama;
    int tacklingteamb;
    int interceptteama;
    int interceptteamb;
    int savesteama;
    int savesteamb;
    int throwinteama;
    int throwinteamb;
    int cornerkickteama;
    int cornerkickteamb;
    int foulteama;
    int foulteamb;
    int offsideteama;
    int offsideteamb;
    int goalteama;
    int goalteamb;
    int shootontargetteama;
    int shootontargetteamb;
    int shootofftargetteama;
    int shootofftargetteamb;
    int yellowcardteama;
    int yellowcardteamb;
    int redcardteama;
    int redcardteamb;

    Button buttonteam;
    Button buttonmatch;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosegeneratereport);

        teamA= getIntent().getStringExtra("teama");
        teamB= getIntent().getStringExtra("teamb");
        formationteama= getIntent().getStringExtra("formationteama");
        formationteamb= getIntent().getStringExtra("formationteamb");
        venue= getIntent().getStringExtra("venue");
        event= getIntent().getStringExtra("event");
        ballpossesionteama= getIntent().getIntExtra("ballpossesionteama",ballpossesionteama);
        ballpossesionteamb= getIntent().getIntExtra("ballpossesionteamb",ballpossesionteamb);
        passingteama= getIntent().getIntExtra("passingteama",passingteama);
        passingteamb= getIntent().getIntExtra("passingteamb",passingteamb);
        tacklingteama= getIntent().getIntExtra("tacklingteama",tacklingteama);
        tacklingteamb= getIntent().getIntExtra("tacklingteamb",tacklingteamb);
        interceptteama= getIntent().getIntExtra("interceptteama",interceptteama);
        interceptteamb= getIntent().getIntExtra("interceptteamb",interceptteamb);
        savesteama= getIntent().getIntExtra("savesteama",savesteama);
        savesteamb= getIntent().getIntExtra("savesteamb",savesteamb);
        throwinteama= getIntent().getIntExtra("throwinteama",throwinteama);
        throwinteamb= getIntent().getIntExtra("throwinteamb",throwinteamb);
        cornerkickteama= getIntent().getIntExtra("cornerkickteama",cornerkickteama);
        cornerkickteamb= getIntent().getIntExtra("cornerkickteamb",cornerkickteamb);
        foulteama= getIntent().getIntExtra("foulteama",foulteama);
        foulteamb= getIntent().getIntExtra("foulteamb",foulteamb);
        offsideteama= getIntent().getIntExtra("offsideteama",offsideteama);
        offsideteamb= getIntent().getIntExtra("offsideteamb",offsideteamb);
        goalteama= getIntent().getIntExtra("goalteama",goalteama);
        goalteamb= getIntent().getIntExtra("goalteamb",goalteamb);
        shootontargetteama= getIntent().getIntExtra("shootontargetteama",shootontargetteama);
        shootontargetteamb= getIntent().getIntExtra("shootontargetteamb",shootontargetteamb);
        shootofftargetteama= getIntent().getIntExtra("shootofftargetteama",shootofftargetteama);
        shootofftargetteamb= getIntent().getIntExtra("shootofftargetteamb",shootofftargetteamb);
        yellowcardteama= getIntent().getIntExtra("yellowcardteama",yellowcardteama);
        yellowcardteamb= getIntent().getIntExtra("yellowcardteamb",yellowcardteamb);
        redcardteama= getIntent().getIntExtra("redcardteama",redcardteama);
        redcardteamb= getIntent().getIntExtra("redcardteamb",redcardteamb);
        cetakgoalteama= getIntent().getExtras().getStringArrayList("cetakgoalteama");
        cetakgoalteamb= getIntent().getExtras().getStringArrayList("cetakgoalteamb");

        buttonmatch = findViewById(R.id.buttonmatch);
        buttonmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choosegeneratereport.this, generatereport.class);
                intent.putExtra("teama", teamA);
                intent.putExtra("teamb", teamB);
                intent.putExtra("formationteamb", formationteamb);
                intent.putExtra("formationteama", formationteama);
                intent.putExtra("formationteamb", formationteamb);
                intent.putExtra("venue", venue);
                intent.putExtra("event", event);
                intent.putExtra("passingteama", passingteama);
                intent.putExtra("passingteamb", passingteamb);
                intent.putExtra("tacklingteama", tacklingteama);
                intent.putExtra("tacklingteamb", tacklingteamb);
                intent.putExtra("interceptteama", interceptteama);
                intent.putExtra("interceptteamb", interceptteamb);
                intent.putExtra("savesteama", savesteama);
                intent.putExtra("savesteamb", savesteamb);
                intent.putExtra("throwinteama", throwinteama);
                intent.putExtra("throwinteamb", throwinteamb);
                intent.putExtra("cornerkickteama", cornerkickteama);
                intent.putExtra("cornerkickteamb", cornerkickteamb);
                intent.putExtra("ballpossesionteama", ballpossesionteama);
                intent.putExtra("ballpossesionteamb", ballpossesionteamb);
                intent.putExtra("foulteama", foulteama);
                intent.putExtra("foulteamb", foulteamb);
                intent.putExtra("offsideteama", offsideteama);
                intent.putExtra("offsideteamb", offsideteamb);
                intent.putExtra("goalteama", goalteama);
                intent.putExtra("goalteamb", goalteamb);
                intent.putExtra("shootontargetteama", shootontargetteama);
                intent.putExtra("shootontargetteamb", shootontargetteamb);
                intent.putExtra("shootofftargetteama", shootofftargetteama);
                intent.putExtra("shootofftargetteamb", shootofftargetteamb);
                intent.putExtra("yellowcardteama", yellowcardteama);
                intent.putExtra("yellowcardteamb", yellowcardteamb);
                intent.putExtra("redcardteama", redcardteama);
                intent.putExtra("redcardteamb", redcardteamb);
                intent.putExtra("ballpossesionteama", ballpossesionteama);
                intent.putExtra("ballpossesionteamb", ballpossesionteamb);
                intent.putStringArrayListExtra("cetakgoalteama", cetakgoalteama);
                intent.putStringArrayListExtra("cetakgoalteamb", cetakgoalteamb);
                startActivity(intent);
            }
        });

        buttonteam = findViewById(R.id.buttonteam);
        buttonteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choosegeneratereport.this, generatereportteam.class);
                intent.putExtra("teama", teamA);
                intent.putExtra("teamb", teamB);
                intent.putExtra("formationteamb", formationteamb);
                intent.putExtra("formationteama", formationteama);
                intent.putExtra("formationteamb", formationteamb);
                intent.putExtra("venue", venue);
                intent.putExtra("event", event);
                intent.putExtra("passingteama", passingteama);
                intent.putExtra("passingteamb", passingteamb);
                intent.putExtra("tacklingteama", tacklingteama);
                intent.putExtra("tacklingteamb", tacklingteamb);
                intent.putExtra("interceptteama", interceptteama);
                intent.putExtra("interceptteamb", interceptteamb);
                intent.putExtra("savesteama", savesteama);
                intent.putExtra("savesteamb", savesteamb);
                intent.putExtra("throwinteama", throwinteama);
                intent.putExtra("throwinteamb", throwinteamb);
                intent.putExtra("cornerkickteama", cornerkickteama);
                intent.putExtra("cornerkickteamb", cornerkickteamb);
                intent.putExtra("ballpossesionteama", ballpossesionteama);
                intent.putExtra("ballpossesionteamb", ballpossesionteamb);
                intent.putExtra("foulteama", foulteama);
                intent.putExtra("foulteamb", foulteamb);
                intent.putExtra("offsideteama", offsideteama);
                intent.putExtra("offsideteamb", offsideteamb);
                intent.putExtra("goalteama", goalteama);
                intent.putExtra("goalteamb", goalteamb);
                intent.putExtra("shootontargetteama", shootontargetteama);
                intent.putExtra("shootontargetteamb", shootontargetteamb);
                intent.putExtra("shootofftargetteama", shootofftargetteama);
                intent.putExtra("shootofftargetteamb", shootofftargetteamb);
                intent.putExtra("yellowcardteama", yellowcardteama);
                intent.putExtra("yellowcardteamb", yellowcardteamb);
                intent.putExtra("redcardteama", redcardteama);
                intent.putExtra("redcardteamb", redcardteamb);
                intent.putExtra("ballpossesionteama", ballpossesionteama);
                intent.putExtra("ballpossesionteamb", ballpossesionteamb);
                intent.putStringArrayListExtra("cetakgoalteama", cetakgoalteama);
                intent.putStringArrayListExtra("cetakgoalteamb", cetakgoalteamb);
                startActivity(intent);
            }
        });


    }
}