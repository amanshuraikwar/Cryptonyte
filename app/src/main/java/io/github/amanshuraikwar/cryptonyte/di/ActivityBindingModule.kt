package io.github.amanshuraikwar.cryptonyte.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.amanshuraikwar.cryptonyte.ui.main.MainActivity
import io.github.amanshuraikwar.cryptonyte.ui.main.MainModule

/**
 * Created by amanshuraikwar on 07/03/18.
 */

@Module abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun main(): MainActivity
}