package cl.samf.sprint_final_mod5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.samf.sprint_final_mod5.databinding.FragmentCarritoBinding
import androidx.navigation.fragment.findNavController
import cl.samf.sprint_final_mod5.databinding.FragmentDescripcionBinding
import coil.load

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarritoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarritoFragment : Fragment() {

    private lateinit var binding: FragmentCarritoBinding
    private var compraList = mutableListOf<Producto>()
    private lateinit var adapter: AdaptaderProductos

    interface OnItemAddedListener {
        fun onItemAdded(item: Producto)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarritoBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val nombre = arguments?.getString("nombre")
            val url = arguments?.getString("url")
            val precio = arguments?.getInt("precio")

        compraList = mutableListOf(Producto(nombre!!,url!!,precio!!))

        val adapter = AdaptaderProductos(compraList, object : AdaptaderProductos.OnClickItemListener {
            override fun onClickItem(item: Producto) {
            }
        })

        binding.recyclerViewCarrito.adapter=adapter

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_carritoFragment_to_inicioFragment)
        }

        }

    }

