package com.example.spiderhacker.farmaonline;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscar_reg();
        }

    public void buscar_reg(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"dbusuarios", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        if (db!=null){
            Cursor c = db.rawQuery("SELECT * FROM user_farma",null);
            if(c.moveToFirst()){
                Toast.makeText(getApplicationContext(),"Si hay registros",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getApplicationContext(),"No hay registros",Toast.LENGTH_SHORT).show();
                Intent reg = new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(reg);

            }
        }

    }

}
