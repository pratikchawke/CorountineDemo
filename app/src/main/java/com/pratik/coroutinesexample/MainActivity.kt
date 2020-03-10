package com.pratik.coroutinesexample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pratik.coroutinesexample.model.User

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var viewModel: MyViewModel
    lateinit var name: TextView
    lateinit var email: TextView
    lateinit var image: ImageView
    lateinit var id: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)


        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.user.observe(this, Observer { response ->
            println("Pratik: $response")
            updateView(response)
        })

        println("Pratik : " + SingletonClass.singletonUser.hashCode())
    }

    private fun initUI() {
        
    }

    private fun updateView(user: User?) {
        findViewById<TextView>(R.id.nameView).setText(user?.username)
        findViewById<TextView>(R.id.emailView).setText(user?.email)
        findViewById<TextView>(R.id.idView).setText(""+user?.id)
        com.bumptech.glide.Glide.with(this)
            .load(user?.image)
            .into(findViewById(R.id.imageView))
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }

    override fun onClick(p0: View?) {
        var btnId = 1
        println("Pratik: "+(p0?.id))
        println("Pratik: "+(R.id.btn1))
        println("Pratik: "+(R.id.btn2))
        println("Pratik: "+(R.id.btn3))
        when (p0?.id) {

            R.id.btn1 -> btnId = 1
            R.id.btn2 -> btnId = 2
            R.id.btn3 -> btnId = 3


        }
        println("Pratik: $btnId")
        viewModel.setUserId(btnId)
    }
}
