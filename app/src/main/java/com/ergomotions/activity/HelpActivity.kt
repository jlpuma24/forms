package com.ergomotions.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        pdfView.fromAsset("help.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .load()
    }

}