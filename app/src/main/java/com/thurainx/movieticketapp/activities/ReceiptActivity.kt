package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.thurainx.movieticketapp.R
import kotlinx.android.synthetic.main.activity_receipt.*


class ReceiptActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,ReceiptActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        setupListeners()
        setupQr()
    }

    private fun setupQr() {
        val text = "GC12345678"
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.CODE_128, 500, 100)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            ivReceiptQr.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }

    private fun setupListeners() {
        ivReceiptClose.setOnClickListener {
            super.onBackPressed()
        }
    }
}