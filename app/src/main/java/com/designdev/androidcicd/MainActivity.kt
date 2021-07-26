package com.designdev.androidcicd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCenter.start(application, "e14df8ae-c125-4bc2-a819-33dfea0b250a", Analytics::class.java, Crashes::class.java)
        findViewById<Button>(R.id.testcrashbtn).setOnClickListener {
                var properties: HashMap<String, String> = HashMap<String, String>()
                properties.put("main_visit", "true")
                properties.put("crash_visit", "true")
                Analytics.trackEvent("visits", properties)
                startActivity(Intent(this, MainActivity2::class.java))
                finish()
        }
    }
}
