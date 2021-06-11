package ru.sulatskov.superapp.main.screens.work_manager_screen

import ru.sulatskov.superapp.base.presenter.BasePresenterInterface
import ru.sulatskov.superapp.base.view.BaseViewInterface

interface WorkManagerContractInterface {
    interface View : BaseViewInterface

    interface Presenter : BasePresenterInterface<View>

}