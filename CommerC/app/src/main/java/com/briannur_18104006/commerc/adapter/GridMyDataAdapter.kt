package com.briannur_18104006.praktikum6.adapter

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.briannur_18104006.commerc.MyData
import com.briannur_18104006.commerc.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class GridMyDataAdapter(val listMyDatas: ArrayList<MyData>, val context: Context) :
    RecyclerView.Adapter<GridMyDataAdapter.GridViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_grid,
            viewGroup,
            false
        )
        return GridViewHolder(view)
    }
    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listMyDatas[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.itemView.setOnClickListener {
        }
        holder.txtPhoto.text = listMyDatas[position].name
    }
    override fun getItemCount(): Int {
        return listMyDatas.size
    }
    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var txtPhoto: TextView = itemView.findViewById(R.id.text_photo)
    }

/*    fun showImage() {
        val builder = Dialog(this)
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.getWindow().setBackgroundDrawable(
            ColorDrawable(Color.TRANSPARENT)
        )
        builder.setOnDismissListener(DialogInterface.OnDismissListener {
        })
        val imageView = ImageView(this)
        imageView.setImageURI()
        builder.addContentView(
            imageView, RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        builder.show()
    }*/
}