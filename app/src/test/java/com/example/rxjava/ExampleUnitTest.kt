package com.example.rxjava

import io.reactivex.observers.TestObserver
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testStandardObservable() {
        val observable = HomeTask.standardObservable()
        val observer = TestObserver<Int>()
        observable.subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()

        observer.assertValueCount(10)
        observer.assertValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    @Test
    fun testEvenObservable() {
        val observable = HomeTask.evenObservable(HomeTask.standardObservable())
        val observer = TestObserver<Int>()
        observable.subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()

        observer.assertValueCount(5)
        observer.assertValues(2, 4, 6, 8, 10)
    }

    @Test
    fun testDivByThreeObservable() {
        val observable = HomeTask.divByThreeObservable(HomeTask.standardObservable())
        val observer = TestObserver<Int>()
        observable.subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()

        observer.assertValueCount(3)
        observer.assertValues(3, 6, 9)
    }

    @Test
    fun testDivByThreeAndFiveObservable() {
        val observable = HomeTask.divByThreeAndFiveObservable(HomeTask.standardObservable())
        val observer = TestObserver<Int>()
        observable.subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()

        observer.assertValueCount(0)
        observer.assertValues()
    }

    @Test
    fun testMergedObservable() {
        val items1 = listOf("Bob", "John")
        val items2 = listOf("Michael", "Anna", "Rick")
        val observable = HomeTask.mergedObservable(items1, items2)
        val observer = TestObserver<String>()
        observable.subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()

        observer.assertValueCount(5)
        observer.assertValues("Bob", "John", "Michael", "Anna", "Rick")
    }

    @Test
    fun testUniqueObservable() {
        val items1 = listOf("Bob", "John", "Bob")
        val items2 = listOf("Bob", "Michael", "Anna", "Rick")
        val observable = HomeTask.uniqueObservable(HomeTask.mergedObservable(items1, items2))
        val observer = TestObserver<String>()
        observable.subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()

        observer.assertValueCount(5)
        observer.assertValues("Bob", "John", "Michael", "Anna", "Rick")
    }

    @Test
    fun testHashObservable() {
        val items1 = listOf("Bob", "John")
        val items2 = listOf("Michael", "Anna", "Rick")
        val observable = HomeTask.hashObservable(HomeTask.mergedObservable(items1, items2))
        val observer = TestObserver<Int>()
        observable.subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()

        observer.assertValueCount(5)
        observer.assertValues("Bob".hashCode(), "John".hashCode(),
            "Michael".hashCode(), "Anna".hashCode(), "Rick".hashCode())
    }
}