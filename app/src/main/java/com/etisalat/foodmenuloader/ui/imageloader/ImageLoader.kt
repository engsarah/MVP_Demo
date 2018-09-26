package com.etisalat.foodmenuloader.ui.imageloader

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.etisalat.foodmenuloader.R
import kotlinx.android.synthetic.main.content_image_loader.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

/**
 * ImageLoader class implemented in kotlin, it displays a default
 * image and other wise user is able to capture a new image
 */
class ImageLoader : AppCompatActivity() {

    private var imageview: ImageView? = null
    private var toolbar: Toolbar? = null
    private val CAMERA = 2


    /**
     * Callback method upon Activity Creation
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_loader)
        setSupportActionBar(findViewById(R.id.toolbar))

        val textView: TextView = findViewById(R.id.toolbar_title) as TextView
        textView.setOnClickListener {
            textView.text = getString(R.string.title_toolbar_Image_Loader)
        }
        //titleTv.setText(getText(R.string.title_toolbar_Image_Loader))

        //binding view from xml layout.
        imageview = findViewById<ImageView>(R.id.imageView)


        /*//Using Glide to download and load the default image.
        Glide.with(this)
                .load("https://s3.amazonaws.com/appsdeveloperblog/Micky.jpg")
                .into(imageView);*/
        /**
         * handle image click event
         * open camera to the user
         */
        imageView.setOnClickListener {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA)

        }

    }


    /**
     * Callback Method to retrieve image captured by the user
     */
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA) {
            val thumbnail = data!!.extras!!.get("data") as Bitmap
            imageview!!.setImageBitmap(thumbnail)
            saveImage(thumbnail)
            Toast.makeText(this@ImageLoader, "Image Saved!", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * This Method is used to save captured image on external storage
     */
    fun saveImage(myBitmap: Bitmap): String {
        val bytes = ByteArrayOutputStream()
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
        val wallpaperDirectory = File(
                (Environment.getExternalStorageDirectory()).toString() + IMAGE_DIRECTORY)
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {

            wallpaperDirectory.mkdirs()
        }

        try {
            val f = File(wallpaperDirectory, ((Calendar.getInstance()
                    .getTimeInMillis()).toString() + ".jpg"))
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
            MediaScannerConnection.scanFile(this,
                    arrayOf(f.getPath()),
                    arrayOf("image/jpeg"), null)
            fo.close()

            return f.getAbsolutePath()
        } catch (e1: IOException) {
            e1.printStackTrace()
        }

        return ""
    }

    companion object {
        private val IMAGE_DIRECTORY = "/imageDir"
    }

    // Extension function to show toast message
    fun Context.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
