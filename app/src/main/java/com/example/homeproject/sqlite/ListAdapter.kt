package com.example.homeproject.sqlite

import android.app.Person
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText

class ListAdapter(
    internal var activity: SqliteActivity,
    internal var listPerson: Person,
    internal var edt_id: EditText,
    internal var edt_name: EditText,
    internal var edt_email: EditText
) : BaseAdapter() {

    internal var inflater:LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {

    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}