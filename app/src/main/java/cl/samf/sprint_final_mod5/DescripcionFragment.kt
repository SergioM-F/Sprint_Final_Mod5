package cl.samf.sprint_final_mod5

import android.content.Context
import android.content.SharedPreferences
import android.os.Binder
import android.os.Bundle
import android.provider.Settings.Global.putString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import cl.samf.sprint_final_mod5.databinding.FragmentDescripcionBinding
import coil.load
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DescripcionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DescripcionFragment : Fragment() {
    private lateinit var binding: FragmentDescripcionBinding
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescripcionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        editor = sharedPrefs.edit()

        val nombre = arguments?.getString("nomProducto")
        val url = arguments?.getString("urlProducto")
        val precio = arguments?.getInt("valorProducto")

        binding.textViewNombreDescrip.text = nombre
        binding.imageViewProductDescrip.load(url)
        binding.textViewPrecioDescrip.text = precio.toString()
        val navController = findNavController()
        
        binding.imageButtonVolver.setOnClickListener{
            navController.popBackStack()
        }
        binding.imageButtonAgregar.setOnClickListener {
            val item = Producto(nombre!!, url!!, precio?: 0)
            saveSelectedProductToSharedPreferences(item)

            navController.navigate(R.id.action_descripcionFragment_to_carritoFragment)

        }

        }

    private fun saveSelectedProductToSharedPreferences(item: Producto) {

        val gson = Gson()
        val sharedPref = requireContext().getSharedPreferences("Myprefs", Context.MODE_PRIVATE)
        val compraList = getSelectedProductsFromSharedPreferences()
        compraList.add(item)
        val json = gson.toJson(compraList)
        with(sharedPref.edit()) {
            putString("SelectedProducts", json)
            apply ()
        }
    }

    private fun getSelectedProductsFromSharedPreferences(): MutableList<Producto> {

        val gson = Gson()
        val sharedPref = requireContext().getSharedPreferences("Myprefs", Context.MODE_PRIVATE)
        val json = sharedPref.getString("SelectedProduct", null)
        val type = object : TypeToken<MutableList<Producto>>(){}.type
        return gson.fromJson(json,type) ?: mutableListOf()
    }


}



