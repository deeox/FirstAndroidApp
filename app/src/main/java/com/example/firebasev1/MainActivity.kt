package com.example.firebasev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var buttonView: Button
    lateinit var buttonAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonView = findViewById(R.id.buttonView)
        buttonAdd = findViewById(R.id.buttonAdd)

        buttonView.setOnClickListener {
            val viewAct = Intent(applicationContext, ViewActivity::class.java)
            startActivity(viewAct)
        }

        buttonAdd.setOnClickListener {
            val addAct = Intent(applicationContext, AddActivity::class.java)
            startActivity(addAct)
        }
    }
/*
    lateinit var editText: EditText
    lateinit var ratingBar: RatingBar
    lateinit var button: Button
    lateinit var listView: ListView
    lateinit var heroList: MutableList<Hero>
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("heroes")

        listView = findViewById(R.id.listView)
        editText = findViewById(R.id.editText)
        ratingBar = findViewById(R.id.ratingBar)
        button = findViewById(R.id.buttonView)

        button.setOnClickListener {
            saveHero()
        }

        ref.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()) {
                    for (h in p0.children) {
                        val hero = h.getValue(Hero::class.java)
                        heroList.add(hero!!)
                    }

                    val adapter = HeroAdapter(applicationContext, R.layout.heroes, heroList)
                    listView.adapter = adapter
                }
            }

        })
    }

    private fun saveHero() {
        val name = editText.text.toString().trim()

        if(name.isEmpty()) {
            editText.error = "Enter name!"
            return
        }


        val heroId = ref.push().key.toString()

        val hero = Hero(heroId, name, ratingBar.numStars)

        ref.child(heroId).setValue(hero).addOnCompleteListener {
            Toast.makeText(applicationContext, "Saved!", Toast.LENGTH_LONG).show()
        }
    }

 */
}
