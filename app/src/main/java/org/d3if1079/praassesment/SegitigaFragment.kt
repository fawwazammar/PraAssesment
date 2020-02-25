package org.d3if1079.praassesment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3if1079.praassesment.databinding.FragmentPersegiPanjangBinding
import org.d3if1079.praassesment.databinding.FragmentSegitigaBinding
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.sqrt

private const val LUAS = "key_luas"
private const val KELILING = "key_keliling"

/**
 * A simple [Fragment] subclass.
 *
 */
class SegitigaFragment : Fragment() {

    private var luas = 0
    private var keliling = 0

    private lateinit var binding: FragmentSegitigaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(inflater, R.layout.fragment_segitiga, container, false)

        binding.bHitung.setOnClickListener {
            luas = binding.tvAlas.text.toString().toInt() * binding.tvTinggi.text.toString().toInt() / 2
            binding.tvLuasPP.text = "Luas : " + luas.toString()

            var sisiMiring = sqrt(binding.tvAlas.text.toString().toDouble().pow(2) + binding.tvTinggi.text.toString().toDouble().pow(2))

            keliling = binding.tvAlas.text.toString().toInt() + binding.tvTinggi.text.toString().toInt() + sisiMiring.toString().toDouble().toInt()
            binding.tvKelilingPP.text = "Keliling : " +keliling.toString()
            Log.i("aa",sisiMiring.toString()+keliling.toString())
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
