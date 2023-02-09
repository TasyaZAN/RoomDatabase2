package com.example.roomdatabase2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase2.room.tbsiswa
import kotlinx.android.synthetic.main.activity_siswa_adapter.view.*

class SiswaAdapter (private val siswa:ArrayList<tbsiswa>, private val listener:OnAdapterListener)
    : RecyclerView.Adapter<SiswaAdapter.SiswaViewHolder> (){

    class SiswaViewHolder( val view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiswaViewHolder{
        return SiswaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_siswa_adapter,parent,false)
        )
    }
    override fun getItemCount() = siswa.size

    override fun onBindViewHolder(holder: SiswaViewHolder, position: Int) {
        val sis = siswa[position]
        holder.view.T_nama.text = sis.nama
        holder.view.T_nama.setOnClickListener{
            listener.onClick(sis)
        }
    }



    fun setData(list: List<tbsiswa>) {
        siswa.clear()
        siswa.addAll(list)
        notifyDataSetChanged()

    }
    interface OnAdapterListener {
        fun onClick(tbsis: tbsiswa)
    }
}
