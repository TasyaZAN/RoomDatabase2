package com.example.roomdatabase2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase2.room.Constant
import com.example.roomdatabase2.room.dbsmksa
import com.example.roomdatabase2.room.tbsiswa
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity(){
    val db by lazy { dbsmksa(this) }
    private var tbsisNis: Int =0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setupView()
        simpandata()
        tbsisNis = intent.getIntExtra("intent_nis",0)
        Toast.makeText(this,tbsisNis.toString(), Toast.LENGTH_SHORT).show()
    }
    fun setupView(){
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val intentType = intent.getIntExtra("intent_type",0)
        when (intentType) {
            Constant.TYPE_CREATE -> {

            }
            Constant.TYPE_READ -> {
                BtnSimpan.visibility = View.GONE

            }
        }
    }


    fun simpandata(){
        BtnSimpan.setOnClickListener{
            CoroutineScope (Dispatchers.IO).launch {
                db.tbsisDao().addtbsiswa(
                    tbsiswa(ETnis.text.toString().toInt(),ETnama.text.toString(),ETkelas.text.toString(),ETalamat.text.toString())
                )
                finish()
            }
        }
    }
}
