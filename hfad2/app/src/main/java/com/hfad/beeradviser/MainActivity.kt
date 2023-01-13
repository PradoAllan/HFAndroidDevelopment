package com.hfad.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //The first part os the chapter

//        val findBeer = findViewById<Button>(R.id.find_beer)
//        findBeer.setOnClickListener {
//            val beerColor = findViewById<Spinner>(R.id.beer_color)
//            val color = beerColor.selectedItem
//            val brands = findViewById<TextView>(R.id.brands)
//            brands.text = "Beer color is $color"
//        }

        //This both works.

//        val findBeer = findViewById<Button>(R.id.find_beer)
//        findBeer.setOnClickListener {
//            val beerColor = findViewById<Spinner>(R.id.beer_color)
//            val brands = findViewById<TextView>(R.id.brands)
//            brands.text = beerColor.selectedItem.toString()
//        }

        //The second part of the chapter

        fun getBeers (color: String): List<String> {
            return when (color) {
                "Light" -> listOf("Jail Pale Ale", "Larger Lite", "Bud")
                "Amber" -> listOf("Jack Amber", "Red Moose", "Testing")
                "Brown" -> listOf("Brown Bear Beer", "Bock Brownie", "Testing2")
                else -> listOf("Gout Stout", "Dark Daniel", "Testing3")
            }
        }

        //This is the method I created to show the list of beers. But I didn't know
        //that I could use a reduce function, because I didn't thought it exist.

//        val findBeer = findViewById<Button>(R.id.find_beer)
//        findBeer.setOnClickListener {
//            val beerColor = findViewById<Spinner>(R.id.beer_color)
//            //val color = beerColor.selectedItem.toString()
//            val brands = findViewById<TextView>(R.id.brands)
//            //brands.text = getBeers(color).toString()
//            brands.text = getBeers(beerColor.selectedItem.toString()).toString()
//        }

        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem

            val beerList = getBeers(color.toString())

            val beers = beerList.reduce { str, item -> str + '\n' + item  }
            //Look for the REDUCE function later.
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beers
        }

    }
}