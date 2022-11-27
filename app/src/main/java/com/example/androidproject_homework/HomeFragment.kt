package com.example.androidproject_homework

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  dialog = AlertDialog.Builder(requireContext())
            .setTitle("Successful transition!")
            .setMessage("Login\\registration completed successfully")
            .setPositiveButton("OK"){dialog, _ ->
                Toast.makeText(requireContext(), "Welcome!!!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){dialog, _ ->
                dialog.cancel()
            }
            .setCancelable(false)
        dialog.show()
    }
}