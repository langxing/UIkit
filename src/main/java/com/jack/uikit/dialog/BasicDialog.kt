package com.jack.uikit.dialog

import android.os.Bundle
import android.view.View
import com.jack.uikit.databinding.DialogBasicBinding

/**
 * 带确认的dialog
 *
 * @author Jack 2022-11-06 10:25
 */
class BasicDialog : BaseDialog<DialogBasicBinding>(DialogBasicBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvConfirm.text = "删除"
        binding.tvCancel.setOnClickListener {
            dismiss()
        }
        binding.tvConfirm.setOnClickListener {
            dismiss()
        }
    }

}