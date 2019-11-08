package com.example.firebasev1

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import com.google.firebase.database.*

class ViewActivity : Activity() {

    lateinit var listView: ListView
    lateinit var heroList: MutableList<Hero>
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        heroList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("heroes")
        listView = findViewById(R.id.listView)

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
}