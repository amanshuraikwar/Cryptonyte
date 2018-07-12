package io.github.amanshuraikwar.cryptonyte.ui.main

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import io.github.amanshuraikwar.cryptonyte.di.ActivityContext
import io.github.amanshuraikwar.cryptonyte.di.ActivityScope

/**
 * Dagger Module to provide MainActivity related instances.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
@Module abstract class MainModule {

    @ActivityScope @Binds
    abstract fun prsntr(presenter: MainPresenter): MainContract.Presenter

    @ActivityScope @Binds @ActivityContext
    abstract fun activity(activity: AppCompatActivity): AppCompatActivity
}