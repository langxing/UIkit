package com.jack.uikit.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

/**
 * dialog基类
 *
 * @author Jack 2022-11-06 09:40
 */
open class BaseDialog<VB : ViewBinding>(private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB) : DialogFragment() {

    protected lateinit var binding: VB

    lateinit var contentView: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        contentView = FrameLayout(inflater.context)
        with(contentView) {
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                ViewGroup.MarginLayoutParams.WRAP_CONTENT
            )
            setBackgroundColor(Color.TRANSPARENT)

        }
        binding = inflate.invoke(inflater, contentView, false)
        contentView.addView(binding.root)
        return contentView
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    protected inline fun <reified VB> initBinding(): VB = VB::class.java.getMethod("bind", View::class.java)
        .invoke(null, requireView()) as VB
}