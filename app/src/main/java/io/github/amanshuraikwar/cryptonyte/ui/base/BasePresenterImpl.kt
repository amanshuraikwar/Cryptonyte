package io.github.amanshuraikwar.cryptonyte.ui.base

import io.github.amanshuraikwar.cryptonyte.bus.AppBus
import io.github.amanshuraikwar.cryptonyte.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by amanshuraikwar on 06/03/18.
 */
abstract class BasePresenterImpl<View: BaseView>
constructor(private val appBus: AppBus,
            private val dataManager: DataManager)
    : BasePresenter<View> {

    private var view: View? = null

    private var disposables: CompositeDisposable = CompositeDisposable()

    protected fun Disposable.addToCleanup() {
        disposables.add(this)
    }

    protected fun Disposable.removeFromCleanup() {
        disposables.remove(this)
    }

    override fun attachView(view: View, wasViewRecreated: Boolean) {
        this.view = view
        onAttach(wasViewRecreated)
    }

    override fun detachView() {
        view = null
        onDetach()
    }

    override fun getView(): View? = view

    override fun isViewAttached(): Boolean = view != null

    protected fun getAppBus(): AppBus = appBus

    protected fun getDataManager(): DataManager = dataManager

    protected open fun onAttach(wasViewRecreated: Boolean) {
        // do nothing
    }

    protected open fun onDetach() {

        // disposing all disposables
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }
}