package com.example.adjective

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.adjective.data.model.Adjective
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_word_of_the_day.*
import kotlinx.android.synthetic.main.content_word_of_the_day.*

class WordOfTheDayActivity : AppCompatActivity() {

    lateinit var wotd: Adjective


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_of_the_day)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "WOOOOOOOOHOOOOO", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        FirebaseFirestore.getInstance().collection("/word_of_the_day")
            .document("current_word")
            .addSnapshotListener { snapshot, exception ->
                if (snapshot != null) {
                    wotd = snapshot.toObject(Adjective::class.java)!!
                    setWOTD(wotd)
                }
            }
    }

    private fun setWOTD(adjective: Adjective) {
        adjName.text = adjective.name
        adjVeryList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, adjective.veryList.toArray())
        adjBarelyList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, adjective.barelyList.toArray())
    }

}
