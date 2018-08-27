package com.ergomotions.util

import android.databinding.ObservableBoolean
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

fun ObservableBoolean.toObservable(): Observable<Boolean> {
    return Observable.create { e ->
        e.onNext(get())
        val callback = object : android.databinding.Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(observable: android.databinding.Observable, i: Int) {
                e.onNext(get())
            }
        }
        addOnPropertyChangedCallback(callback)
        e.setCancellable { removeOnPropertyChangedCallback(callback) }
    }
}

fun Disposable.disposeWithoutFear() = this.let {
    if (it.isDisposed.not()) {
        it.dispose()
    }
}
