package cl.samf.sprint_final_mod5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.samf.sprint_final_mod5.databinding.ItemBinding
import coil.load


class AdaptaderProductos(private val productos: MutableList<Producto> ,private val clickListener: OnClickItemListener) : RecyclerView.Adapter<AdaptaderProductos.ViewHolder>() {

   // private var productos = mutableListOf<Producto>()



    //var callback: OnClickItemListener ?=null

    /*var callback: ProductoBack ?=null*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptaderProductos.ViewHolder {
        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdaptaderProductos.ViewHolder, position: Int) {
        val item = productos[position]
        holder.bind(item)
        }


    override fun getItemCount(): Int {
        return productos.size
    }

    /*fun setData(productos: List<Producto>) {
    this.productos = productos.toMutableList()
    }*/

  inner class ViewHolder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root) {

       fun bind(item: Producto) {
            binding.textViewNombreCard.text = item.nomProducto
            binding.imageViewProducItem.load(item.urlProducto)
            binding.textViewPrecioCard.text = item.valorProducto.toString()

           binding.root.setOnClickListener { clickListener.onClickItem(item)}


            }


        }


    interface OnClickItemListener {
        fun onClickItem(item: Producto)
    }

}

/*interface ProductoBack {
    fun mostrarProducto(mostrar: String)

}*/
