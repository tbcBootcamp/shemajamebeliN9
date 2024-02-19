package com.example.shemajamebelin9.presentation.screen.choose_image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shemajamebelin9.databinding.FragmentChooseImageBinding
import com.example.shemajamebelin9.presentation.screen.mainFragment.OnTakePhotoListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ChooseImageFragment : BottomSheetDialogFragment() {


    private var _binding: FragmentChooseImageBinding? = null
    private val binding get() = _binding!!

    interface BottomSheetListener {
        fun onOptionSelected(option: String)
    }

    private var listener: BottomSheetListener? = null

    var onTakePhotoListener: OnTakePhotoListener? = null

    fun setListener(listener: BottomSheetListener) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnTakePicture.setOnClickListener {
            onTakePhotoListener?.onTakePicture()
            dismiss()
        }
        binding.btnChooseFromGallery.setOnClickListener {
            listener?.onOptionSelected("CHOOSE_GALLERY")
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
