package com.yunuskemalyazar.dddddddddddddddddddddddddd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.yunuskemalyazar.dddddddddddddddddddddddddd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var liste : ArrayList<Listeler> = arrayListOf()
    private var adabter = Adabter()
    private var gameNameList: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var de : ArrayList<String> = arrayListOf()
        var isim : ArrayList<String> = arrayListOf()
        var soyisim : ArrayList<String> = arrayListOf()
        var email : ArrayList<String> = arrayListOf()
        var id : ArrayList<String> = arrayListOf()

        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        binding.recyclerview.adapter=adabter

        adabter.listeyiDoldur(liste)

        for (x in 0..LogDumpGetUnique().split(";").size-2){
            de.add(LogDumpGetUnique().toLowerCase().split(";").subList(x,x+1).toString())
        }

        for (x in 0..LogDumpGetUnique().split(";").size-2){
            isim.add(de[x].substringAfter("name").substringBefore(",").replace("=","").capitalize())
            soyisim.add(de[x].substringAfter("username").substringBefore(",").replace("=",""))
            email.add(de[x].substringAfter("email").substringBefore(",").replace("]","").replace("=",""))
            id.add(de[x].substringAfter("id").substringBefore(",").replace("=",""))
        }
        for (j in 0..LogDumpGetUnique().split(";").size-2) {
                    liste.add(Listeler(isim = isim[j], soyisim = soyisim[j], email = email[j], id = id[j]))
                    //Log.i("gizem", "name=" + isim[j] + " soyadı =" + soyisim[j] + " email=" + email[j])
        }
          adabter.listeyiDoldur(liste)


    }
    fun LogDumpGetUnique(): String {
        var log_dump : String =
                    "name=John Trust, username=john3, email=john3@gmail.com, id=434453; " +
                    "name=Hannah Smith, username=hsmith, email=hsm@test.com, id=23312; " +
                    "name=Hannah Smith, username=hsmith, id=3223423, email=hsm@test.com; " +
                    "name=Robert M, username=rm44, id=222342, email=rm@me.com; " +
                    "name=Robert M, username=rm4411, id=5535, email=rm@me.com; " +
                    "name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com; " +
                    "name=Robert Nick, username=rnick33, id=23432, email=rnick@gmail.com; " +
                    "name=Robert Nick II, username=rnickTemp34, id=23432, email=rnick@gmail.com; " +
                    "name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;" +
                    "name=Yunus Kemal, username=Yazar, id=23432, email=yns11021034@gmail.com;"

        return log_dump;
    }
}