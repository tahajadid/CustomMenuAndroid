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
    lateinit var profileCL: ConstraintLayout
    lateinit var favouriteCL: ConstraintLayout
    lateinit var settingCL: ConstraintLayout

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

        profileCL = root.findViewById(R.id.profile_cl)
        favouriteCL = root.findViewById(R.id.favourite_cl)
        settingCL = root.findViewById(R.id.setting_cl)

        animateLayout()
        initComponents()

        // hide menu Icon in Dashboard view
        if (!firstOpenning) MainActivity.activityInstance.menuIcon.visibility = View.GONE
        firstOpenning = false

        return root
    }

    /**
     * function to init the click on the sections
     */
    private fun initComponents() {
        profileCL.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
        favouriteCL.setOnClickListener {
            findNavController().navigate(R.id.favouriteFragment)
        }
        settingCL.setOnClickListener {
            findNavController().navigate(R.id.settingFragment)
        }
    }

    /**
     * function to do animation on Constraint Layout (sections)
     */
    private fun animateLayout() {
        SpicyAnimation().fadeToDown(profileCL, 50F, 600)
        SpicyAnimation().fadeToDown(favouriteCL, 50F, 800)
        SpicyAnimation().fadeToDown(settingCL, 50F, 1000)
    }
}
