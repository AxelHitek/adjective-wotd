package com.example.adjective.data.repository

import com.example.adjective.data.model.Adjective

interface AdjectiveRepository {

    fun getAdverbs(): List<Adjective?>
}