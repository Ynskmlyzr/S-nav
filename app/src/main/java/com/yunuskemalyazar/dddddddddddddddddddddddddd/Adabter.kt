package com.yunuskemalyazar.dddddddddddddddddddddddddd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yunuskemalyazar.dddddddddddddddddddddddddd.databinding.OrnekBinding

class Adabter:RecyclerView.Adapter<Adabter.ListeHolder>() {

    var liste : ArrayList<Listeler> = arrayListOf()

    class ListeHolder(var binding: OrnekBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListeHolder {
      var binding=OrnekBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListeHolder(binding)
    }

    override fun onBindViewHolder(holder: ListeHolder, position: Int) {
        holder.binding.tvIsim.text=liste.get(position).isim
        holder.binding.tvSoyisim.text=liste.get(position).soyisim
        holder.binding.tvEmail.text=liste.get(position).email
    }

    override fun getItemCount(): Int {
        return liste.size
    }
    fun listeyiDoldur(mesajListesi : ArrayList<Listeler>){
        liste.clear()
        liste.addAll(mesajListesi)
        notifyDataSetChanged()
    }
}