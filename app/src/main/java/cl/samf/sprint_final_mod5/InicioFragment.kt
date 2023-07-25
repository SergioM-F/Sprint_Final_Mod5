package cl.samf.sprint_final_mod5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import cl.samf.sprint_final_mod5.databinding.FragmentInicioBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [InicioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InicioFragment : Fragment() {

    private lateinit var binding: FragmentInicioBinding


    private val productos: MutableList<Producto> = ProductosList.productos



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInicioBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initAdapter()

        binding.floatingActionButtonCarrito.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_inicioFragment_to_carritoFragment)
        }


    }

    private fun initAdapter() {
        val adapter =
            AdaptaderProductos(productos, object : AdaptaderProductos.OnClickItemListener {
                override fun onClickItem(item: Producto) {
                    val bundle = Bundle()
                    bundle.putString("nomProducto", item.nomProducto)
                    bundle.putString("urlProducto", item.urlProducto)
                    bundle.putInt("valorProducto", item.valorProducto)

                    val navController = findNavController()
                    navController.navigate(
                        R.id.action_inicioFragment_to_descripcionFragment,
                        bundle
                    )

                }
            })
            binding.recyclerViewInicio.adapter=adapter

    }

}









