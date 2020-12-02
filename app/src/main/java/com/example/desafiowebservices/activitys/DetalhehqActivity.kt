package com.example.desafiowebservices.activitys

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiowebservices.R
import com.example.desafiowebservices.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhehq.*
import java.text.SimpleDateFormat
import java.util.*


class DetalhehqActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhehq)

        imageview_voltar_listahqs.setOnClickListener {
            finish()
        }
        imageview_poster.setOnClickListener {
            materialcardview_detalheposter.visibility = VISIBLE
        }
        imageview_fecharposter.setOnClickListener {
            materialcardview_detalheposter.visibility = INVISIBLE
        }

        var itemAtual = intent.getSerializableExtra("itemClick") as? Results
        var fundo = "${itemAtual?.thumbnail?.path}.${itemAtual?.thumbnail?.extension}"
        var descricao = itemAtual?.description
        if (descricao==null)
        {
            descricao="API appear to be incomplete, no description for this comic."
        }
        var titulo = itemAtual?.title
        var published = itemAtual?.dates?.get(0)?.date
        var price = itemAtual?.prices?.get(0)?.price
        var pages = itemAtual?.pageCount

        textview_titulo.text = titulo
        textview_decricao.text = descricao
        textview_pages.text = pages.toString()
        textview_price.text = "$ $price"
        val formatter: SimpleDateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        textview_published.text = formatter.format(published)
        Picasso.get().load(Uri.parse(fundo)).into(imageview_fundo)
        Picasso.get().load(Uri.parse(fundo)).into(imageview_poster)
        Picasso.get().load(Uri.parse(fundo)).into(imageview_detalheposter)
    }

}