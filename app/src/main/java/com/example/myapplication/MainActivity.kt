package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utils.MySharedPreference

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreference.init(this)

        if (MySharedPreference.myCounter != 0 || MySharedPreference.myCounter2 !=0)
        {
            binding.countDisplay.text = MySharedPreference.myCounter.toString()
            binding.natural.text = MySharedPreference.myCounter2.toString()
        }

        binding.counter.setOnClickListener {
            var count1 = MySharedPreference.myCounter
            var count2 = MySharedPreference.myCounter2
            count1++
            if (count1 == 33)
            {
                count1 = 0
                binding.countDisplay.text = ""
                count2++
                binding.natural.text = count2.toString()
                MySharedPreference.myCounter2 = count2
            }
            binding.countDisplay.text = count1.toString()
            MySharedPreference.myCounter = count1
        }

        binding.reset.setOnClickListener {
            MySharedPreference.myCounter = 0
            MySharedPreference.myCounter2 = 0
            binding.countDisplay.text = ""
            binding.natural.text = ""
        }
    }
}