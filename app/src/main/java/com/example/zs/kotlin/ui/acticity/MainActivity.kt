package com.example.zs.kotlin.ui.acticity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.zs.kotlin.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Description: Hello World !
 * Created by zs on 2017/12/26.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_hello_world.text = "Hello World !"
    }
}
