package com.example.homeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var mainMenu:Menu? =null
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var multiDeleteAdapter: MultiDeleteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView =findViewById(R.id.multiDeleteRecycler)
        editText=findViewById(R.id.editText)
        button=findViewById(R.id.addRecycler)
        val dataSet= ArrayList<MultiDeleteModel>()
        dataSet.add(MultiDeleteModel("Mango",false))
        dataSet.add(MultiDeleteModel("PineApple",false))
        dataSet.add(MultiDeleteModel("Papaya",false))
        dataSet.add(MultiDeleteModel("Grapes",false))
        dataSet.add(MultiDeleteModel("Apple",false))
        dataSet.add(MultiDeleteModel("Strawberry",false))
        dataSet.add(MultiDeleteModel("Bomagranet",false))
        dataSet.add(MultiDeleteModel("cashewNut",false))
        dataSet.add(MultiDeleteModel("Lemon",false))
        dataSet.add(MultiDeleteModel("Watermelon",false))
        multiDeleteAdapter= MultiDeleteAdapter(dataSet){show->showDeleteMenu(show)}
        recyclerView.adapter=multiDeleteAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        button.setOnClickListener {
            val text=editText.text.toString().trim()
            if (TextUtils.isEmpty(text)){
                Toast.makeText(this,"Please Insert Fruit Name",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            dataSet.add(MultiDeleteModel(text,false))
            Toast.makeText(this,"Data Added",Toast.LENGTH_SHORT).show()
            multiDeleteAdapter.notifyItemInserted(dataSet.size-1)
            recyclerView.scrollToPosition(dataSet.size-1 )

        }
    }
    private fun showDeleteMenu(show:Boolean){
    mainMenu?.findItem(R.id.deleteBtn)?.isVisible=show

}
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        mainMenu=menu
        menuInflater.inflate(R.menu.delete_menu,mainMenu)
        showDeleteMenu(false)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.deleteBtn->{delete()}
        }
        return super.onOptionsItemSelected(item)
    }
    private fun delete(){
        val alertDialog=AlertDialog.Builder(this)
        alertDialog.setTitle("Delete")
        alertDialog.setMessage("Do you want to delete the item?")
        alertDialog.setPositiveButton("Delete"){_,_->
            multiDeleteAdapter.deleteSelectedItem()
            showDeleteMenu(false)
        }
        alertDialog.setNegativeButton("Cancel"){_,_-> }
        alertDialog.show()
    }
}