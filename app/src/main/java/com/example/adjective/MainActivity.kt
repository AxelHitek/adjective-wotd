package com.example.adjective

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adjective.data.adapter.AdjectiveAdapter
import com.example.adjective.data.model.Adjective
import com.example.adjective.data.repository.AdjectiveRepository
import com.example.adjective.data.repository.AdjectiveRepositoryImpl
import kotlinx.android.synthetic.main.scrollable_list_view.*


class MainActivity : AppCompatActivity() {

    val adjectiveRepo: AdjectiveRepository = AdjectiveRepositoryImpl()
    var adjectiveList: List<Adjective?> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrollable_list_view)

        adjectiveList = adjectiveRepo.getAdverbs()
        adjectiveListView.adapter = AdjectiveAdapter(applicationContext, adjectiveList)

        testBtn.setOnClickListener {
            adjectiveListView.adapter = AdjectiveAdapter(applicationContext, adjectiveList)
        }


    }

}
