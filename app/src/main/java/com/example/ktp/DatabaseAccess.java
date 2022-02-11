package com.example.ktp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAccess {

    private DatabaseOpenHelper openHelper;//Declaration de DatabaseOpenHelper
    private SQLiteDatabase db;//Objt SQLite db
    private static DatabaseAccess instance;
    Cursor c = null; //contient resultat de requête sur une bdd

    private DatabaseAccess(Context context){//Création d'une BDD
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){//Singleton retournant l'instance de la classe
        if(instance==null){
            instance = new DatabaseAccess(context);
        }
        return  instance;
    }

    public void open(){//Ouverture de la BDD
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){//Fermeture de la BDD
        if(db!=null){
            this.db.close();
        }
    }


    //Requête vers la BDD

    public String getnom(String exercices){
        c=db.rawQuery("select nom from exercices where partie = ?",new String[]{exercices});

        c.moveToFirst();
        return  c.getString(0);
    }





}