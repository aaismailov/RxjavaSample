package com.example.rxjava

import io.reactivex.Observable

object HomeTask {

    /**
     * 1. Создайте Observable, который будет эмитить числа от 1 до 10
     * 2. Преобразуйте Observable так, чтобы он эмитил только четные числа
     * 3. Преобразуйте Observable так, чтобы он эмитил только числа, которые делятся на 3
     * 4. Преобразуйте Observable так, чтобы он эмитил только числа, которые делятся на 3 и 5
     */
    fun standardObservable(): Observable<Int> =
        Observable.range(1, 10)

    fun evenObservable(observable: Observable<Int>): Observable<Int> =
        observable.filter { it % 2 == 0 }

    fun divByThreeObservable(observable: Observable<Int>): Observable<Int> =
        observable.filter { it % 3 == 0 }

    fun divByThreeAndFiveObservable(observable: Observable<Int>): Observable<Int> =
        observable.filter { it % 15 == 0 }

    /**
     * 1. Создайте два Observable из соответсвующих последовательностей
     * 2. Объедините два Observable в один
     * 3. Преобразуйте Observable так, чтобы он эмитил только уникальные элементы
     * 4. Преобразуйте Observable так, чтобы он эмитил только хэш коды элементов
     */
    fun mergedObservable(items1: List<String>, items2: List<String>): Observable<String> =
        Observable.fromIterable(items1).mergeWith(Observable.fromIterable(items2))

    fun uniqueObservable(observable: Observable<String>): Observable<String> =
        observable.distinct()

    fun hashObservable(observable: Observable<String>): Observable<Int> =
        observable.map { it.hashCode() }
}