package pn.masterandroid.macrobenchmark

import android.content.Intent
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//@LargeTest
//@RunWith(AndroidJUnit4::class)
//class StartupBenchmark {
//    @get:Rule
//    val benchmarkRule = MacrobenchmarkRule()
//
//    @Test
//    fun startup() = benchmarkRule.measureRepeated(
//        packageName = TARGET_PACKAGE,
//        metrics = listOf(StartupTimingMetric()),
//        iterations = 2,
//        startupMode = StartupMode.COLD,
//    ) { // this = MacrobenchmarkScope
//        pressHome()
//
//        Intent().run {
//            setPackage(TARGET_PACKAGE)
//            action = "${TARGET_PACKAGE}.app.STARTUP_ACTIVITY"
//
//            startActivityAndWait(this)
//        }
//    }
//}