package com.example.custommenu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.custommenu.MainActivity
import com.example.custommenu.R
import com.example.custommenu.databinding.FragmentDashboardBinding
import com.example.custommenu.util.firstOpenning
import com.example.spicyanimation.SpicyAnimation

class DashboardFragment : Fragment() {
    lateinit var pCL: ConstraintLayout
    lateinit var fCL: ConstraintLayout
    lateinit var sCL: ConstraintLayout

    lateinit var bin: FragmentDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        pCL = root.findViewById(R.id.profile_cl)
        fCL = root.findViewById(R.id.favourite_cl)
        sCL = root.findViewById(R.id.setting_cl)
        animateLayout()
        initComponents()

        // hide menu Icon
        if (!firstOpenning) MainActivity.activityInstance.menuIcon.visibility = View.GONE
        firstOpenning = false

        return root
    }

    private fun initComponents() {
        pCL.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
        fCL.setOnClickListener {
            findNavController().navigate(R.id.favouriteFragment)
        }
        sCL.setOnClickListener {
            findNavController().navigate(R.id.settingFragment)
        }
    }

    private fun animateLayout() {
        SpicyAnimation().fadeToDown(pCL, 50F, 600)
        SpicyAnimation().fadeToDown(fCL, 50F, 800)
        SpicyAnimation().fadeToDown(sCL, 50F, 1000)
    }
}
