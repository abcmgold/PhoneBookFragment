package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: Fragment() {
    lateinit var recyclerView: RecyclerView
    var listData: ArrayList<Contacts> = dataList()
    lateinit var myAdapter: ContactAdapter
    lateinit var addContact: ImageButton
    private lateinit var onClickItem: OnClickItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.content_main, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.onClickItem = activity as OnClickItem
        addContact = view.findViewById<ImageButton>(R.id.addContact)
        recyclerView = view.findViewById(R.id.recyclerView)
        //listData = dataList()
        myAdapter = ContactAdapter(listData, view.context)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            view.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        this.addContact.setOnClickListener{
            onClickItem.ButtonClicked()
        }
        this.myAdapter.setOnClickListener(
            object :
                ContactAdapter.OnClickListener {
                override fun onClick(position: Int, model: Contacts) {
                    onClickItem.ItemClicked(model)
                }
            }
        )
    }


    fun UpdateContent(item: Contacts) {
        this.listData.add(item)
        this.myAdapter.notifyItemInserted(listData.size -1 )
    }
    fun dataList() : ArrayList<Contacts>{
        var list: ArrayList<Contacts> = ArrayList<Contacts>()
        list.add(Contacts("Tuấn Bùi", "0000001", "v123@gmail.com", "0916059063"))
        list.add(Contacts("Bùi Tuấn", "0000003", "vh123@gmail.com", "091787063"))
        list.add(Contacts("Phương", "0009701", "vhjk123@gmail.com", "0452059063"))
        list.add(Contacts("ABCXYZ", "0234001", "vher3@gmail.com", "0916059034"))
        list.add(Contacts("123", "0432001", "verf3@gmail.com", "0916000063"))
        list.add(Contacts("Hello", "0056701", "vve3@gmail.com", "0912059063"))
        list.add(Contacts("World", "0012801", "vwe333@gmail.com", "0916023463"))
        list.add(Contacts("Bùi Anh Tuấn", "0666601", "v12d3@gmail.com", "0923059063"))
        list.add(Contacts("Viet", "0834501", "dfe23@gmail.com", "0913489063"))
        list.add(Contacts("Hoang", "0035001", "5563@gmail.com", "0911234063"))
        list.add(Contacts("1234", "0056321", "ghu23@gmail.com", "0986059063"))
        list.add(Contacts("12345", "0023401", "5423@gmail.com", "0923679063"))
        return list
    }
}