package com.example.countrylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val context: Context, private val countryList: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImageView: ImageView = itemView.findViewById(R.id.flagImageView)
        val countryNameTextView: TextView = itemView.findViewById(R.id.countryNameTextView)
        val populationTextView: TextView = itemView.findViewById(R.id.populationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]

        holder.countryNameTextView.text = country.countryName
        holder.populationTextView.text = "Population: ${country.population}"

        val imageId = getMipmapResIdByName(context, country.flagName) // Use the helper function
        holder.flagImageView.setImageResource(imageId)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Selected: ${country.countryName} (Population: ${country.population})", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = countryList.size

    private fun getMipmapResIdByName(context: Context, resName: String): Int {
        val pkgName = context.packageName
        return context.resources.getIdentifier(resName, "mipmap", pkgName)
    }
}
