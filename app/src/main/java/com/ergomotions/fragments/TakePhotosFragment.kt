package com.ergomotions.fragments

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.ergomotions.R
import kotlinx.android.synthetic.main.fragment_photos.*

const val CAMERA_REQUEST_CODE = 12345
const val REQUEST_GALLERY_CAMERA = 54654

class TakePhotosFragment : Fragment() {

    private var takenPhotos = 0

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater?.inflate(R.layout.fragment_photos, container, false)
        v?.findViewById<Button>(R.id.buttonAddPhoto)?.setOnClickListener{
            if (takenPhotos != 3) {
                makeCameraLogic()
            } else {
                Toast.makeText(activity, getString(R.string.photos_already_taken), Toast.LENGTH_LONG).show()
            }
        }
        v?.findViewById<ImageView>(R.id.photo)?.setOnClickListener{
            if (takenPhotos != 3) {
                makeCameraLogic()
            } else {
                Toast.makeText(activity, getString(R.string.photos_already_taken), Toast.LENGTH_LONG).show()
            }
        }
        v?.findViewById<TextView>(R.id.photosTaken)?.text = String.format(getString(R.string.taken_photos), takenPhotos.toString())
        return v
    }

    private fun makeCameraLogic() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity,
                            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        activity,
                        arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_GALLERY_CAMERA)
            } else {
                openCamera()
            }
        } else {
            openCamera()
        }
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    fun getInfo() = takenPhotos

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_GALLERY_CAMERA) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                Toast.makeText(activity, getString(R.string.permission_denied), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                CAMERA_REQUEST_CODE -> {
                    takenPhotos++
                    photosTaken.text = String.format(getString(R.string.taken_photos), takenPhotos.toString())
                }
            }
        }
    }
}