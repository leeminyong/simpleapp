package com.aiden.andmodule.activity

import android.os.Bundle
import android.util.TypedValue
import android.widget.SeekBar
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.aiden.andmodule.R

class ImvocaKotlin : AppCompatActivity() {

    internal lateinit var tv: TextView
    private lateinit var txtEng: TextView
    private lateinit var txtPron: TextView
    private lateinit var txtKor: TextView
    private var userFont: Float = 0.toFloat()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imvoca)
        tv = findViewById(R.id.textView4)
        txtEng = findViewById(R.id.txtEng)
        txtPron = findViewById(R.id.txtPron)
        txtKor = findViewById(R.id.txtKor)

        val sb = findViewById<SeekBar>(R.id.seekBar)

        //tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.myword_day_size_basic));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.myword_day_size_step0))
        /**
         * txtEng
         * txtPron
         * txtKor
         *
         */
        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                tv.text = "onStop TrackingTouch"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                tv.text = "onStart TrackingTouch"
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                tv.text = "onProgressChanged : $progress"
                fontResize(progress)
            }
        })
    }

    private fun fontResize(pos: Int) {
        when (pos) {
            1 -> userFont = resources.getDimension(R.dimen.myword_day_size_step1)
            2 -> userFont = resources.getDimension(R.dimen.myword_day_size_step2)
            3 -> userFont = resources.getDimension(R.dimen.myword_day_size_step3)
            4 -> userFont = resources.getDimension(R.dimen.myword_day_size_step4)
            5 -> userFont = resources.getDimension(R.dimen.myword_day_size_step5)
            6 -> userFont = resources.getDimension(R.dimen.myword_day_size_step6)
            7 -> userFont = resources.getDimension(R.dimen.myword_day_size_step7)
            8 -> userFont = resources.getDimension(R.dimen.myword_day_size_step8)
            9 -> userFont = resources.getDimension(R.dimen.myword_day_size_step9)
            10 -> userFont = resources.getDimension(R.dimen.myword_day_size_step10)
        }
        txtEng.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.myword_day_size_step1))
        txtPron.setTextSize(TypedValue.COMPLEX_UNIT_PX, userFont)
        txtKor.setTextSize(TypedValue.COMPLEX_UNIT_PX, userFont)
    }
}
