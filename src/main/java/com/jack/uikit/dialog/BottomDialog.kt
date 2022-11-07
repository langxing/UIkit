package com.jack.uikit.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding

/**
 * 底部弹窗，宽度充满屏幕
 *
 * @author Jack 2022-11-07 22:22
 */
open class BottomDialog<VB : ViewBinding>(inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB) : BaseDialog<VB>(inflate)  {

    override fun onStart() {
        super.onStart()
        contentView.layoutParams = FrameLayout.LayoutParams(
            ViewGroup.MarginLayoutParams.MATCH_PARENT,
            ViewGroup.MarginLayoutParams.MATCH_PARENT
        )
        dialog?.window?.setLayout(
            ViewGroup.MarginLayoutParams.MATCH_PARENT,
            ViewGroup.MarginLayoutParams.MATCH_PARENT
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}