package com.example.rpg.hero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TestViewModel : ViewModel() {
    private var _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result

    private var _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    private var _tested = MutableLiveData<Int>()
    val tested: LiveData<Int>
        get() = _tested

    init {
        _result.value = "TEST RESULT"
        _number.value = 0
    }

    fun doTest(difficulty: Int, tested: Int) {
        _tested.value = tested
        if(difficulty==1){
            _number.value = Random().nextInt(6) + 1
        }
        else if(difficulty==2){
            _number.value = Random().nextInt(10) + 1
        }
        else{
            _number.value = Random().nextInt(20) + 1
        }
        if(tested >= _number.value!!){
            _result.value = "PASSED"
        }
        else{
            _result.value = "FAILED"
        }
    }
}
