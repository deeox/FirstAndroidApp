package com.example.firebasev1

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddActivity : Activity() {

    lateinit var nameText: EditText
    lateinit var idText: EditText
    lateinit var button: Button
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        nameText = findViewById(R.id.nameText)
        idText = findViewById(R.id.idText)
        button = findViewById(R.id.buttonSubmit)
        ref = FirebaseDatabase.getInstance().getReference("heroes")
        button.setOnClickListener {
            saveHero()
        }
    }

    private fun saveHero() {
        val name = nameText.text.toString().trim()
        val id = idText.text.toString().trim()

        if(name.isEmpty()) {
            nameText.error = "Enter name!"
            return
        }

        if(id.isEmpty()) {
            idText.error = "Enter ID!"
            return
        }

        val heroId = ref.push().key.toString()

        val hero = Hero(heroId, name, id)

        ref.child(heroId).setValue(hero).addOnCompleteListener {
            Toast.makeText(applicationContext, "Saved!", Toast.LENGTH_LONG).show()
        }
    }
}