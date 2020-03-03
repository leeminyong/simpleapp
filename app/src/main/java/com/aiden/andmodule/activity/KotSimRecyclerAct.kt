package com.aiden.andmodule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aiden.andmodule.R
import com.aiden.andmodule.databinding.ItemPeopleBinding
import com.aiden.andmodule.generated.callback.OnClickListener
import com.aiden.andmodule.model.Person
import kotlinx.android.synthetic.main.kotsim_recycler.*

class KotSimRecyclerAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotsim_recycler)

        val peopleList = arrayListOf<Person>()
        for (i in 0..30) {
            peopleList.add(Person("Johsua $i", 30))
        }

        kt_recyclerview.apply {
            layoutManager = LinearLayoutManager(this@KotSimRecyclerAct)
            adapter = PersonAdapter(peopleList) {Person->
                Toast.makeText(this@KotSimRecyclerAct, "${Person.name}",Toast.LENGTH_SHORT).show()
            }
        }

    }
}


class PersonAdapter(val items: List<Person>, private val clickListener: (person: Person) -> Unit) :
        RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    class PersonViewHolder(val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)

        val viewHolder = PersonViewHolder(ItemPeopleBinding.bind(view))
        view.setOnClickListener {
            clickListener.invoke(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.binding.vm = items[position]
    }
}
