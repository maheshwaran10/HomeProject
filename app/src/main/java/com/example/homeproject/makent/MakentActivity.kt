package com.example.homeproject.makent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homeproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MakentActivity : AppCompatActivity() {

    lateinit var homeFragment: FirstFragment
    lateinit var profileFragment: SecondFragment
    lateinit var favFragment: ThirdFragment
    lateinit var settingsFragment: FourthFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makent)
        var bottomnav = findViewById<BottomNavigationView>(R.id.BottomNavMenu)
        var frame = findViewById<FrameLayout>(R.id.frameLayout)
        //Now let's the deffault Fragment
        homeFragment = FirstFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
        //now we will need to create our different fragemnts
        //Now let's add the menu evenet listener
        bottomnav.setOnNavigationItemSelectedListener { item ->
            //we will select each menu item and add an event when it's selected
            when(item.itemId){
                R.id.home -> {
                    homeFragment = FirstFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,homeFragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.favorite -> {
                    favFragment = ThirdFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,favFragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.profile -> {
                    profileFragment = SecondFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,profileFragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.settings -> {
                    settingsFragment = FourthFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,settingsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true
        }
        //Now let's Run our App
    }
}