package org.d3if1079.praassesment


import android.icu.text.CaseMap
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : org.d3if1079.praassesment.databinding.FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.bPersegiPanjang.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_persegiPanjangFragmen)
        }

        binding.bSegitiga.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_segitigaFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.aboutMenu -> findNavController().navigate(R.id.action_homeFragment_to_aboutFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}
