package doston.weatherme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import farrukh.weatherme.R
import farrukh.weatherme.data_class.Day
import farrukh.weatherme.data_class.Hour


class DayAdapter(
    var array: MutableList<Day>,
    var listener: onItemClick
) : RecyclerView.Adapter<DayAdapter.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date = itemView.findViewById<TextView>(R.id.date)
        var state = itemView.findViewById<TextView>(R.id.state)
        var min_max_temp = itemView.findViewById<TextView>(R.id.day_min_max_temp)
        var img = itemView.findViewById<ImageView>(R.id.state_img)
        var onDay = itemView.findViewById<ConstraintLayout>(R.id.onDay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.day_layout, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyHolder, posit: Int) {
        var position =  array.get(posit)



        holder.date.text = position.date +","
        holder.state.text = position.state+""
        holder.min_max_temp.text = position.max_temp+" °C "+position.min_temp+" °C"
        holder.img.load("http:"+position.img)

        holder.onDay.setOnClickListener {
            listener.onDayClick(posit)
        }

    }

    interface onItemClick{
        fun onDayClick(position: Int)
    }
}

