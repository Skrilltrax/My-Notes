package me.skrilltrax.notes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import me.skrilltrax.notes.databinding.FragmentBottomSheetBinding
import me.skrilltrax.notes.helpers.AccountHelper
import me.skrilltrax.notes.helpers.FirebaseHelper

class BottomMenuFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.text = AccountHelper.firebaseUser?.displayName
        binding.email.text = AccountHelper.firebaseUser?.email
    }
}