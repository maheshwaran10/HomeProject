


package com.example.homeproject.diffutil

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


class DiffUtilActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var diffAdapter: DiffAdapter
    lateinit var nu:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util)
        initView()


    }
    companion object{
        val name:String="Mahesh"
    }

    fun getData():ArrayList<DiffModel>{


        val diffList:ArrayList<DiffModel> = ArrayList()
        diffList.add(DiffModel(1,"Ashok",45))
        diffList.add(DiffModel(2,"Prem",58))
        diffList.add(DiffModel(3,"Yogesh",98))
        diffList.add(DiffModel(3,"Siva",67))
        diffList.add(DiffModel(3,"Nitheesh",69))
        return diffList
    }


    private fun initView() {
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val ascend=findViewById<Button>(R.id.asc)
        val descend=findViewById<Button>(R.id.desc)
        val friends=findViewById<Button>(R.id.friends)
        diffAdapter= DiffAdapter(this,getData())
        recyclerView.adapter=diffAdapter
        ascend.setOnClickListener(this)
        descend.setOnClickListener(this)
        friends.setOnClickListener(this)
    }


    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.asc -> diffAdapter.dispatch(getstoredByAsc())
            R.id.desc -> diffAdapter.dispatch(getStoredByDecc())
            R.id.friends -> diffAdapter.dispatch(getStoredByFriends())
        }

    }

    private fun getstoredByAsc(): List<DiffModel> {
        val list:List<DiffModel> = getData()
        Collections.sort(list,Comparator<DiffModel> { o1, o2 -> o1.name.compareTo(o2.name) })
        return list

    }
    private fun getStoredByDecc(): List<DiffModel> {
        val list:List<DiffModel> = getData()
        Collections.sort(list,Comparator<DiffModel> { o1, o2 -> o2.name.compareTo(o1.name) })
        return list

    }
    private fun getStoredByFriends(): List<DiffModel> {
        val list:List<DiffModel> = getData()
        Collections.sort(list,Comparator<DiffModel> { o1, o2 -> o1.friendsCount-o2.friendsCount })
        return list

    }

}