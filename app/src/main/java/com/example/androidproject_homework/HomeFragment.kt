package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.successfull))
            .setMessage(getString(R.string.completed))
            .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                Toast.makeText(requireContext(), getString(R.string.wl), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(getString(R.string.negative_btn)) { dialog, _ ->
                dialog.cancel()
            }
            .setCancelable(false)
        dialog.show()
    }
}