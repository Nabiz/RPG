package com.example.rpg.hero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HeroViewModel : ViewModel() {
    private var _hero = MutableLiveData<Hero>()
    val hero: LiveData<Hero>
        get() = _hero

    init {
        _hero.value = Hero("Daveth", false, 10,10,10,10,10)
    }

    fun levelUp() {
        _hero.value!!.vit += 1
        _hero.value!!.str += 1
        _hero.value!!.dex += 1
        _hero.value!!.inte += 1
        _hero.value!!.luck += 1
    }

    fun createHero(name: String, proffesion: Int, sex: Boolean){
        _hero.value!!.name = name
        _hero.value!!.sex = sex
        _hero.value!!.luck = 2
        if (proffesion == 1){
            _hero.value!!.vit = 4
            _hero.value!!.str = 5
            _hero.value!!.dex = 3
            _hero.value!!.inte = 2

        }
        else if(proffesion == 2) {
            _hero.value!!.vit = 3
            _hero.value!!.str = 2
            _hero.value!!.dex = 3
            _hero.value!!.inte = 6
        }
        else {
            _hero.value!!.vit = 3
            _hero.value!!.str = 3
            _hero.value!!.dex = 5
            _hero.value!!.inte = 3
        }
    }
}
