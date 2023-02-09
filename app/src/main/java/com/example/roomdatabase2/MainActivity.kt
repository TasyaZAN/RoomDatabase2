package com.example.roomdatabase2

import com.example.roomdatabase2.room.Constant
import com.example.roomdatabase2.room.dbsmksa
import com.example.roomdatabase2.room.tbsiswa



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val db by lazy { dbsmksa(this) }
    private lateinit var siswaAdapter: SiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        halEdit()
        setupRecyclerView()
    }
    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val siswa = db.tbsisDao().tampilsemua()
            Log.d("MainActivity","dbResponse:$siswa")
            withContext(Dispatchers.Main) {
                siswaAdapter.setData(siswa)
            }

        }
    }

    private fun halEdit() {
        BtnInput.setOnClickListener {
            intentEdit(0, Constant.TYPE_CREATE)
        }
    }

    fun intentEdit(tbsisNis: Int,intentType: Int){
        startActivity(
            Intent(applicationContext, EditActivity::class.java)
                .putExtra("intent_nis",tbsisNis)
                .putExtra("intent_type",intentType)
        )
    }

    private fun setupRecyclerView () {
        siswaAdapter = SiswaAdapter(arrayListOf(),object : SiswaAdapter.OnAdapterListener{
            override fun onClick(tbsis: tbsiswa) {
                intentEdit(tbsis.nis,1)


            }

        })
        listdatasiswa.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = siswaAdapter
        }
    }

}
