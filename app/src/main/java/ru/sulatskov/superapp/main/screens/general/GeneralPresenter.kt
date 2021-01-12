package ru.sulatskov.superapp.main.screens.general

import ru.sulatskov.superapp.base.presenter.BasePresenter

class GeneralPresenter : BasePresenter<GeneralFragment>() {

    fun onServiceButtonClick() {
        view?.openServiceScreen()
    }

    fun onContentProviderButtonClick() {
        view?.openContentProviderScreen()
    }

    fun onTextViewButtonClick() {
        view?.openTextViewScreen()
    }

    fun onEditTextButtonClick() {
        view?.openEditTextScreen()
    }
}