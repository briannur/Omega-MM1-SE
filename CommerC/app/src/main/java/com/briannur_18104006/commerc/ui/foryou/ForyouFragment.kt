package com.briannur_18104006.commerc.ui.foryou

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.briannur_18104006.commerc.MyData
import com.briannur_18104006.commerc.R
import com.briannur_18104006.praktikum6.adapter.GridMyDataAdapter
import kotlinx.android.synthetic.main.fragment_foryou.*
import kotlinx.android.synthetic.main.item_crsl.view.*

class ForyouFragment : Fragment() {

    var sampleImages = intArrayOf(
        R.drawable.src_andhang,
        R.drawable.src_kemambang
    )

    var lokawisata = arrayOf(
        "Taman Andhang Pangrenan",
        "Taman Balai Kemambang"
    )
    private lateinit var foryouViewModel: ForyouViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        foryouViewModel =
            ViewModelProvider(this).get(ForyouViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_foryou, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselView.setViewListener { i ->
            val view = layoutInflater.inflate(R.layout.item_crsl, null)

            view.img_item_crsl.setImageResource(sampleImages[i])
            view.text_photo.text = lokawisata[i]
            view

        }
        carouselView.pageCount = sampleImages.size

        grid_view.adapter = GridMyDataAdapter(getDataPhoto(), requireContext())
    }

    fun getDataPhoto(): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listMyData = ArrayList<MyData>()
        for (position in dataPhoto.indices) {
            val myData = MyData(
                dataName[position],
                dataPhoto[position]
            )
            listMyData.add(myData)
        }
        return listMyData
    }
}


