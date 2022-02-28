package com.example.homeproject.sqlite

import android.annotation.SuppressLint
import android.app.Person
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "MyDb"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "person"
        const val COL_NAME = "name"
        const val COL_ID = "id"
        const val COL_EMAIL = "email"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            ("CREATE TABLE$ TABLE_NAME($COL_ID INTEGER PRIMARY KEY ,$COL_NAME TEXT,$COL_EMAIL TEXT)")
        db!!.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    //CRUD
    val allPerson:List<SqliteModel>
    @SuppressLint("Range")
    get() {
        val listPerson=ArrayList<SqliteModel>()
        val sqliteQuery="SELECT *FROM $TABLE_NAME"
        val db:SQLiteDatabase=this.writableDatabase
        val cursor:Cursor=db.rawQuery(sqliteQuery,null)
        if (cursor.moveToFirst()) {
            do {
                val person = SqliteModel()
                person.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                person.name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                person.email = cursor.getString(cursor.getColumnIndex(COL_EMAIL))

                listPerson.add(person)

            } while (cursor.moveToNext())

        }
        db.close()
        return listPerson
    }

    fun addPerson(sqliteModel: SqliteModel){
        val db:SQLiteDatabase=this.writableDatabase
        val values=ContentValues()
        values.put(COL_ID,sqliteModel.id)
        values.put(COL_NAME,sqliteModel.name)
        values.put(COL_EMAIL,sqliteModel.email)

        db.insert(TABLE_NAME,null,values)
        db.close()
    }
    fun updatePerson(sqliteModel: SqliteModel):Int{
        val db:SQLiteDatabase=this.writableDatabase
        val values=ContentValues()
        values.put(COL_ID,sqliteModel.id)
        values.put(COL_NAME,sqliteModel.name)
        values.put(COL_EMAIL,sqliteModel.email)
        return db.update(TABLE_NAME,values,"$COL_ID=?", arrayOf(sqliteModel.id.toString()))

    }
    fun deletePerson(sqliteModel: SqliteModel){
        val db:SQLiteDatabase=this.writableDatabase
        db.delete(TABLE_NAME,"$COL_ID=?", arrayOf(sqliteModel.id.toString()))
        db.close()

    }

}