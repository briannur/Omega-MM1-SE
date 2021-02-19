package com.briannur_18104006.commerc.ui.foryou

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.briannur_18104006.commerc.DescriptionActivity
import com.briannur_18104006.commerc.MyData
import com.briannur_18104006.commerc.R
import com.briannur_18104006.praktikum6.adapter.GridMyDataAdapter
import com.synnapps.carouselview.ImageClickListener
import kotlinx.android.synthetic.main.fragment_foryou.*
import kotlinx.android.synthetic.main.item_crsl.view.*


class ForyouFragment : Fragment() {

    companion object {
        const val EXTRA_TITLE = "mydata"
        const val EXTRA_IMAGE = "thisdata"
        const val EXTRA_DESC = "thedata"
    }
    var sampleImages = intArrayOf(
        R.drawable.src_andhang,
        R.drawable.src_kemambang
    )

    var lokawisata = arrayOf(
        "Taman Andhang Pangrenan",
        "Taman Balai Kemambang"
    )

    var description = arrayOf(
        "Taman Andhang Pangrenan merupakan fasilitas umum dan tempat rekreasi yang multifungsi. Merupakan ruang terbuka hijau di sisi selatan kota Purwokerto dengan fasilitas cukup lengkap dan bisa di manfaatkan untuk berbagai keperluan oleh masyarakat umum.",
        "Taman Balai Kemambang adalah salah satu obyek wisata di Purwokerto yang saat ini sedang gencar-gencarnya dipromosikan pemerintah kepada masyarakat. Rekreasi yang asik tak harus mahal yang bisa diperoleh jika jalan-jalan di Taman Rekreasi Balai Kemambang Purwokerto. Pengunjung bisa bersantai sambil menikmati danau buatan yang asri lengkap dengan taman yang cantik."
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

        carouselView.setImageClickListener(ImageClickListener { position ->
            val moveWithIntent = Intent(activity, DescriptionActivity::class.java)
            moveWithIntent.putExtra(EXTRA_TITLE, lokawisata[position])
            moveWithIntent.putExtra(EXTRA_IMAGE, sampleImages[position])
            moveWithIntent.putExtra(EXTRA_DESC, description[position])
            activity?.startActivity(moveWithIntent)
        })

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


