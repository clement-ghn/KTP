package com.example.ktp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAccess {

    private DatabaseOpenHelper openHelper;//Declaration de DatabaseOpenHelper
    private SQLiteDatabase BaseDeDonnees;//Objet SQLite db
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
        this.BaseDeDonnees=openHelper.getWritableDatabase();
    }

    public void close(){//Fermeture de la BDD
        if(BaseDeDonnees!=null){
            this.BaseDeDonnees.close();
        }
    }


    //Requête vers la BDD

    public String getpartie(String partie){
        c=BaseDeDonnees.rawQuery("select nombre_rep from Exercices where partie = ?",new String[]{partie});

        if(c.getCount()!=1){
            return "erreur";
        }
        c.moveToFirst();
        return  c.getString(0);
    }

}