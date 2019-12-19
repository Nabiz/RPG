package com.example.rpg.hero

data class Hero(
    var name: String,
    // 0 - man, 1 - woman
    var sex: Boolean,
    var vit: Int,
    var str: Int,
    var dex: Int,
    var inte: Int,
    var luck: Int)
