package pn.masterandroid.macrobenchmark

import android.content.Intent
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ListScrollBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = TARGET_PACKAGE,
        metrics = listOf(FrameTimingMetric()),
        iterations = 1,
        startupMode = StartupMode.WARM,
        setupBlock = {
            Intent().run {
                setPackage(TARGET_PACKAGE)
                action = "${TARGET_PACKAGE}.app.STARTUP_ACTIVITY"

                startActivityAndWait(this)
            }
        }
    ) { // this = MacrobenchmarkScope
        device.findObject(By.res(packageName, "button_first")).click()

        device.findObject(By.res(packageName, "complex_list_recycler_view")).run {
            setGestureMargin(device.displayWidth / 5)

            repeat(3) { fling(Direction.DOWN) }
        }
    }
}