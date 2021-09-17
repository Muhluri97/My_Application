package com.example.functionalityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.functionalityapp.R
import com.example.functionalityapp.core.model.User
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.squareup.picasso.Picasso

class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        val actionBar = supportActionBar

        actionBar!!.title = "Users"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val profileName = findViewById<TextView>(R.id.profileName)
        val imageView = findViewById<ImageView>(R.id.profileImage)
        val user = intent.getParcelableExtra<User>("User")
        val takePicture = findViewById<Button>(R.id.takePicture)
        val shareProfile = findViewById<ImageView>(R.id.shareProfile)
        val location = findViewById<Button>(R.id.location)
        val bannerView = findViewById<AdView>(R.id.adView)

        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        bannerView.loadAd(adRequest)

        profileName.text = user?.name


        takePicture.setOnClickListener{
            val intent = Intent(this, TakePicture::class.java)
            startActivity(intent)
        }

        shareProfile.setOnClickListener{
            if (user != null) {
                this.shareProfile(user)
            }
        }

        location.setOnClickListener{
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }

    }

    fun shareProfile (user: User){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, user.name)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}