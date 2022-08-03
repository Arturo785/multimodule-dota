package com.example.hero_datasource_test.cache

import com.example.hero_domain.Hero

// this is basically a way to soft save data
class HeroDatabaseFake {

    val heros: MutableList<Hero> = mutableListOf()
}