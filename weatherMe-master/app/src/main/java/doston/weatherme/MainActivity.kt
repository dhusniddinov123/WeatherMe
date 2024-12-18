package doston.weatherme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import doston.weatherme.databinding.ActivityMainBinding
import doston.weatherme.ui.Weather2Fragment
import doston.weatherme.ui.WeatherFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().add(R.id.main,Weather2Fragment()).commit()

        setContentView(binding.root)
    }
}