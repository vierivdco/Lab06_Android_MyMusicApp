package com.cervantes.mymusicapp.adapter

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cervantes.mymusicapp.databinding.ActivityMusicBinding
import com.cervantes.mymusicapp.model.Music
import de.hdodenhof.circleimageview.CircleImageView

class AdapterMusic(private val dataSet: List<Music>) : RecyclerView.Adapter<AdapterMusic.ViewHolder>() {

    class ViewHolder(private val binding: ActivityMusicBinding) : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView = binding.pictureImage
        var nameMusic: TextView = binding.nameMusic
        var nameArtist: TextView = binding.nameArtist
        var nameGenero: TextView = binding.nameGenero
        var picturePlay: CircleImageView = binding.picturePlay
        var picturePause: CircleImageView = binding.picturePause
        var pictureShare: CircleImageView = binding.pictureShare
        var pictureStar: CircleImageView = binding.pictureStar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ActivityMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(binding: ViewHolder, position: Int) {
        val music: Music = this.dataSet[position]

        val context = binding.itemView.context

        val idRes = context.resources.getIdentifier(music.picture, "drawable", context.packageName)

        binding.nameMusic.text = music.musicName
        binding.nameArtist.text = music.artistName
        binding.picture.setImageResource(idRes)
        binding.nameGenero.text = music.genero

        binding.picture.setOnClickListener {
            TODO()
        }
        if(music.genero=="rock"){
            binding.pictureStar.visibility=VISIBLE
        }
        binding.picturePlay.setOnClickListener {
            Toast.makeText(context, "PLAY "+music.musicName, Toast.LENGTH_SHORT).show()
        }
        binding.picturePause.setOnClickListener {
            Toast.makeText(context, "PAUSE "+music.musicName, Toast.LENGTH_SHORT).show()
        }

        binding.pictureShare.setOnClickListener {

            var mobileNumber=943870289


            val url =
                "https://api.whatsapp.com/send?phone=${mobileNumber}&text=El%20Nombre%20de%20la%20Musica%20es%20"+music.musicName

            val intent = Intent(Intent.ACTION_VIEW).apply {
                this.data = Uri.parse(url)
                this.`package` = "com.whatsapp"
            }

            try {
                context.startActivity(intent)
            } catch (ex : ActivityNotFoundException){
                Toast.makeText(context, "Whatsapp no esta instalado", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int = dataSet.size
}