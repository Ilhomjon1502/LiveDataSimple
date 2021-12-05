package uz.ilhomjon.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import uz.ilhomjon.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var myLiveData: MyLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            myLiveData = MyLiveData()
            myLiveData.get().observe(this@MainActivity, Observer {
                tv.text = it
            })

            edt.addTextChangedListener {
                myLiveData.set(it.toString())
            }
        }
    }
}