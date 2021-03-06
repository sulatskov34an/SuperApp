package ru.sulatskov.superapp.main.screens.recycler_view

import ru.sulatskov.superapp.base.presenter.BasePresenterInterface
import ru.sulatskov.superapp.base.view.BaseViewInterface

interface RecyclerViewContractInterface {

    interface View : BaseViewInterface {
        fun showList(data: MutableList<Pair<Any, Type>>)
    }

    interface Presenter : BasePresenterInterface<View> {
    }
}