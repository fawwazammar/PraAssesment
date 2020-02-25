package org.d3if1079.praassesment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.d3if1079.praassesment.databinding.FragmentPersegiPanjangBinding

private const val LUAS = "key_luas"
private const val KELILING = "key_keliling"

/**
 * A simple [Fragment] subclass.
 *
 */
class PersegiPanjangFragment : Fragment() {

    private var luas = 0
    private var keliling = 0

    private lateinit var binding: FragmentPersegiPanjangBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentPersegiPanjangBinding>(inflater, R.layout.fragment_persegi_panjang, container, false)

        binding.bHitung.setOnClickListener {
            luas = binding.tvPanjang.text.toString().toInt() * binding.tvLebar.text.toString().toInt()
            binding.tvLuasPP.text = "Luas : " + luas.toString()

            keliling = (2*binding.tvPanjang.text.toString().toInt()) + 2*(binding.tvLebar.text.toString().toInt())
            binding.tvKelilingPP.text = "Keliling : " +keliling.toString()

        }
        if (savedInstanceState != null) {
            // Get all the game state information from the bundle, set it
            luas = savedInstanceState.getInt(LUAS, 0)
            keliling = savedInstanceState.getInt(KELILING, 0)
        }

        // Set the TextViews to the right values
        binding.tvLuasPP.text = "Luas : " +luas.toString()
        binding.tvKelilingPP.text = "Keliling : " +keliling.toString()


        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LUAS, luas)
        outState.putInt(KELILING, keliling)
        super.onSaveInstanceState(outState)
    }

}
