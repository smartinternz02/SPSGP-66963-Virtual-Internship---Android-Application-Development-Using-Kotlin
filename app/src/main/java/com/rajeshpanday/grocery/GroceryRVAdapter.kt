package com.rajeshpanday.grocery

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.lifecycle.ViewModel
class GroceryRVAdapter (
    var list:List<GroceryItems>,
    val  groceryItemClickInterface: GroceryItemClickInterface
): RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>(){
         inner class GroceryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
             val nameTV = itemView.findViewById<TextView>(R.id.TVItemName)
             val quantityTV = itemView.findViewById<TextView>(R.id.TVQuantity)
             val rateTV = itemView.findViewById<TextView>(R.id.idTVRate)
             val amountTV = itemView.findViewById<TextView>(R.id.idTVTotalAmt)
             val deleteTV = itemView.findViewById<ImageView>(R.id.idTVDelete)
         }


    interface GroceryItemClickInterface{
            fun OnItemClick(groceryItems: GroceryItems)

        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item,parent,false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.nameTV.text = list.get(position).itemName
        holder.quantityTV.text = list.get(position).itemQuantity.toString()
        holder.rateTV.text = "Rs. " + list.get(position).itemPrice.toString()
        val itemTotal : Int = list . get (position).itemPrice * list.get(position).itemQuantity
        holder.amountTV.text = "Rs. " + itemTotal.toString()
        holder.deleteTV.setOnClickListener {
            groceryItemClickInterface.OnItemClick(list.get(position))
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }
}