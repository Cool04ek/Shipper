package demo.shipper.base

interface BasePresenter {

    fun attachView(view: BaseView)

    fun detachView()

}
