package com.kotlinweather.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kotlinweather.R
import com.kotlinweather.WeatherData
import com.kotlinweather.WeatherService
import com.kotlinweather.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("ALO ALO")
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        getData()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getData() {
        val request = WeatherService.api.getWeather("451782")

        request.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                var temp = response.body()?.results?.temp
                var src_image : String

                binding.textTemp.text = temp.toString() + "°C"
                binding.textCity.text = response.body()?.results?.city.toString()
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}