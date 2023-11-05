import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.giorgi_kurdadze_5.ColorsData
import com.example.giorgi_kurdadze_5.R

class ColorAdapter(private val colorList: MutableList<ColorsData>) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorName: TextView = itemView.findViewById(R.id.colorName)
        val colorCode: TextView = itemView.findViewById(R.id.colorCode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.color, parent, false)
        return ColorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val currentItem = colorList[position]
        holder.colorName.text = currentItem.name
        holder.colorCode.text = currentItem.color
    }

    override fun getItemCount(): Int {
        return colorList.size
    }
}
