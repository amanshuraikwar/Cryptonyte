package io.github.amanshuraikwar.cryptonyte.di

import javax.inject.Qualifier

/**
 * Created by amanshuraikwar on 07/03/18.
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Qualifier @Retention annotation class ActivityContext