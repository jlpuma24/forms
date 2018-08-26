package com.ergomotions.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ergomotions.databinding.FragmentGeneralFormBinding
import com.ergomotions.viewModels.GeneralViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class GeneralFragment : Fragment() {

    companion object {

        const val CERVIX = "CERVIX"
        const val SHOULDER = "SHOULDER"
        const val ELBOW = "ELBOW"
        const val FOREARM = "FOREARM"
        const val WRIST = "WRIST"
        const val HAND = "HAND"
        const val FINGER = "FINGER"
        const val LOW_BAG = "LOW_BAG"
        const val HIGH_BAG = "HIGH_BAG"
        const val HIP = "HIP"

        private const val TYPE = "TYPE"

        fun newInstance(typeName: String): GeneralFragment {
            return GeneralFragment().apply {
                arguments = typeName.toExtras()
            }
        }

        private fun String.toExtras() = Bundle().apply { putString(TYPE, this@toExtras) }

    }

    @Inject
    lateinit var viewModelMap: @JvmSuppressWildcards Map<String, GeneralViewModel>

    private val binding by lazy {
        FragmentGeneralFormBinding.inflate(LayoutInflater.from(context), null, false)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModelMap[arguments.getString(TYPE).orEmpty()]
    }

}