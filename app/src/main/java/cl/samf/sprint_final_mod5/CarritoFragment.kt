package cl.samf.sprint_final_mod5

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.samf.sprint_final_mod5.databinding.FragmentCarritoBinding
import androidx.navigation.fragment.findNavController
import cl.samf.sprint_final_mod5.databinding.FragmentDescripcionBinding
import coil.load
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception

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
    private lateinit var compraList : MutableList<Producto>
    private lateinit var adapter: AdaptaderProductos




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarritoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        compraList = getSelectedProductsFromSharedPreferences()
        adapter = AdaptaderProductos(compraList, object : AdaptaderProductos.OnClickItemListener {
            override fun onClickItem(item: Producto) {
            }
        })
        binding.recyclerViewCarrito.adapter = adapter



        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_carritoFragment_to_inicioFragment)
        }
    }


        private fun getSelectedProductsFromSharedPreferences(): MutableList<Producto> {
            val gson = Gson()
            val sharedPref =
                requireContext().getSharedPreferences("Myprefs", Context.MODE_PRIVATE)
            val json = sharedPref.getString("SelectedProducts", null)
            val type = object : TypeToken<MutableList<Producto>>() {}.type
            return gson.fromJson(json, type) ?: mutableListOf()
        }
    }





