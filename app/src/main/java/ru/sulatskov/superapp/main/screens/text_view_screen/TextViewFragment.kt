package ru.sulatskov.superapp.main.screens.text_view_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.sulatskov.superapp.R
import ru.sulatskov.superapp.base.view.BaseFragment
import ru.sulatskov.superapp.base.view.BaseViewInterface
import ru.sulatskov.superapp.databinding.FragmentTextViewBinding
import ru.sulatskov.superapp.di.component.DaggerMainComponent
import javax.inject.Inject

class TextViewFragment : BaseFragment(), BaseViewInterface {

    companion object {
        const val TAG = "TextViewFragmentTag"
    }

    @Inject
    lateinit var presenter: TextViewPresenter

    private var fragmentTextViewBinding: FragmentTextViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTextViewBinding.inflate(inflater, container, false)
        fragmentTextViewBinding = binding
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentTextViewBinding?.longText?.post {
            fragmentTextViewBinding?.longText?.lineCount?.let { lineCount ->
                if (lineCount <= 4) {
                    fragmentTextViewBinding?.readFull?.visibility = View.GONE
                } else {
                    fragmentTextViewBinding?.readFull?.visibility = View.VISIBLE
                }

            }
        }

        val collapseListener: (View) -> Unit = {
            fragmentTextViewBinding?.longText?.maxLines = Int.MAX_VALUE
            fragmentTextViewBinding?.readFull?.visibility = View.GONE
        }

        fragmentTextViewBinding?.readFull?.setOnClickListener(collapseListener)
    }

    override fun injectDependency() {
        DaggerMainComponent.builder().build().inject(this)
    }

    override fun attachPresenter() {
        presenter.attach(this)
    }

    override fun initToolbar() {
        fragmentTextViewBinding?.toolbar?.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        fragmentTextViewBinding?.toolbar?.title = getString(R.string.text_view)

    }

    override fun onDestroyView() {
        fragmentTextViewBinding = null
        super.onDestroyView()
    }
}