package com.example.adjective.data.repository

import android.bluetooth.le.AdvertiseCallback
import android.content.ContentValues.TAG
import android.util.Log
import com.example.adjective.data.model.Adjective
import com.google.firebase.firestore.FirebaseFirestore

class AdjectiveRepositoryImpl() : AdjectiveRepository {

    private val adverbs = ArrayList<Adjective?>()

    override fun getAdverbs(): List<Adjective?> = adverbs

    init {
        FirebaseFirestore.getInstance().collection("adverbs")
            .addSnapshotListener { snapshot, exception ->
                if(exception != null) {
                    Log.w(TAG, "Listen failed.", exception)
                    return@addSnapshotListener
                }
                if (snapshot != null && !snapshot.isEmpty) {
                    snapshot.documents.map { doc -> adverbs.add(doc.toObject(Adjective::class.java)) }
                } else {
                    Log.d(TAG, "Current data: null")
                }
            }
    }

}