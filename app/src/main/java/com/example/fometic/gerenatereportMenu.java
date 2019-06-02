package com.example.fometic;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gerenatereportMenu extends AppCompatActivity {

    Spinner teamA;
    Spinner teamB;
    String formationteama;
    String formationteamb;
    String ballpossesionteama;
    String ballpossesionteamb;
    int passingteama;
    int passingteamb;
    int tacklingteama;
    int tacklingteamb;
    int interceptteama;
    int interceptteamb;
    int savesteama;
    int savesteamb;
    int yellowcardteama;
    int yellowcardteamb;
    int redcardteama;
    int redcardteamb;
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
    String venue;
    String event;
    ArrayList<String> cetakgoalteama = new ArrayList<>();
    ArrayAdapter<String> arrayAdaptercetakgoalteama;
    ArrayList<String> cetakgoalteamb = new ArrayList<>();
    ArrayAdapter<String> arrayAdaptercetakgoalteamb;

    PertandinganDBHandler dbpertandingan=new PertandinganDBHandler(this);
    goalDBHandler dbgoal=new goalDBHandler(this);
    PemainDBHandler dbpemain=new PemainDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenatereport_menu);
        Button search= findViewById(R.id.buttonsearch);
        getTeamData();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamachoosen=teamA.getSelectedItem().toString();
                String teambchoosen=teamB.getSelectedItem().toString();
                getdatapertandingan(teamachoosen,teambchoosen);
            }
        });
    }

    public void getTeamData(){
        TeamDBHandler db = new TeamDBHandler(this);
        Cursor loadDataTeam=db.loaddatateam();
        List<String> spinnerArray=new ArrayList<String>();
        loadDataTeam.moveToFirst();
        while (!loadDataTeam.isAfterLast()) {
            spinnerArray.add(loadDataTeam.getString(1));
            Log.d("Data spinner ",loadDataTeam.getString(1));
            loadDataTeam.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
        teamA= findViewById(R.id.spinnerteamhome);
        teamA.setAdapter(arrayAdapter);

        teamB= findViewById(R.id.spinnerteamaway);
        teamB.setAdapter(arrayAdapter);
    }

    public void getdatapertandingan(String teama, String teamb){
        ArrayList<HashMap<String, String>> data=dbpertandingan.loaddatapertandinganreport(teama,teamb);
        final ListView lv = (ListView) findViewById(R.id.listpertandingan);
        ListAdapter adapter = new SimpleAdapter(gerenatereportMenu.this, data, R.layout.list_row,new String[]{"idpertandingan","timtandingskor","babak","tanggal"}, new int[]{R.id.babakid,R.id.timtandingskor, R.id.babak, R.id.tanggal});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String UserInfo = lv.getItemAtPosition(position).toString();
                String userId = UserInfo.substring(UserInfo.indexOf("=")+1, UserInfo.indexOf(","));
                int babak = Integer.parseInt(userId.substring(0,1));
                int idpertandingan= Integer.valueOf(userId.substring(1,userId.length()));
                Cursor datapertandingan=dbpertandingan.loaddatapertandinganshow(idpertandingan,babak);
                datapertandingan.moveToFirst();
                formationteama=datapertandingan.getString(2);
                formationteamb=datapertandingan.getString(18);
                venue=datapertandingan.getString(40);
                event=datapertandingan.getString(39);
                passingteama=datapertandingan.getInt(3);
                passingteamb=datapertandingan.getInt(19);
                tacklingteama=datapertandingan.getInt(4);
                tacklingteamb=datapertandingan.getInt(20);
                interceptteama=datapertandingan.getInt(8);
                interceptteamb=datapertandingan.getInt(24);
                savesteama=datapertandingan.getInt(9);
                savesteamb=datapertandingan.getInt(25);
                throwinteama=datapertandingan.getInt(10);
                throwinteamb=datapertandingan.getInt(26);
                cornerkickteama=datapertandingan.getInt(14);
                cornerkickteamb=datapertandingan.getInt(30);
                ballpossesionteama=datapertandingan.getString(36);
                ballpossesionteamb=datapertandingan.getString(37);
                foulteama=datapertandingan.getInt(43);
                foulteamb=datapertandingan.getInt(44);
                offsideteama=datapertandingan.getInt(41);
                offsideteamb=datapertandingan.getInt(42);
                goalteama=datapertandingan.getInt(5);
                goalteamb=datapertandingan.getInt(21);
                shootontargetteama=datapertandingan.getInt(6);
                shootontargetteamb=datapertandingan.getInt(22);
                shootofftargetteama=datapertandingan.getInt(7);
                shootofftargetteamb=datapertandingan.getInt(23);
                yellowcardteama=datapertandingan.getInt(15);
                yellowcardteamb=datapertandingan.getInt(31);
                redcardteama=datapertandingan.getInt(16);
                redcardteamb=datapertandingan.getInt(32);
                ballpossesionteama=datapertandingan.getString(36);
                ballpossesionteamb=datapertandingan.getString(37);
                Cursor goalpemainteama=dbgoal.loaddatagoal(String.valueOf(idpertandingan));
                goalpemainteama.moveToFirst();
                while(!goalpemainteama.isAfterLast()){
                    String a= dbpemain.loadnamapemain(goalpemainteama.getInt(2))+" ("+goalpemainteama.getString(3)+") "+goalpemainteama.getString(4);
                    cetakgoalteama.add(a);
                    goalpemainteama.moveToNext();
                }

                Cursor goalpemainteamb=dbgoal.loaddatagoal(String.valueOf(idpertandingan));
                goalpemainteamb.moveToFirst();
                while(!goalpemainteamb.isAfterLast()){
                    String a= dbpemain.loadnamapemain(goalpemainteamb.getInt(2))+" ("+goalpemainteamb.getString(3)+") "+goalpemainteamb.getString(4);
                    cetakgoalteama.add(a);
                    goalpemainteamb.moveToNext();
                }

                Intent intent = new Intent(gerenatereportMenu.this, generatereport.class);
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
                intent.putExtra("possesionteama", ballpossesionteama);
                intent.putExtra("possesionteamb", ballpossesionteamb);
                intent.putStringArrayListExtra("cetakgoalteama", cetakgoalteama);
                intent.putStringArrayListExtra("cetakgoalteamb", cetakgoalteamb);
                startActivity(intent);

                //Toast.makeText(getBaseContext(), lv.getItemAtPosition(position).toString()+userId+","+babak+","+idpertandingan, Toast.LENGTH_LONG).show();
            }
        });
    }
}