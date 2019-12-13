package breakingnews.gamenews.net

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.facebook.applinks.AppLinkData
import android.widget.Toast
import com.facebook.FacebookSdk

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FacebookSdk.setAutoInitEnabled(true)
        FacebookSdk.fullyInitialize()

        AppLinkData.fetchDeferredAppLinkData(this) {
            if (it != null) {
                val handler = Handler(Looper.getMainLooper())
                handler.post {
                    Toast.makeText(this, "IN APP LINK NOT NULL", Toast.LENGTH_LONG).show()
                }
                val path = it.argumentBundle!!.getString("go")
                handler.post {
                    Toast.makeText(this, "LOCAL: " + path!!, Toast.LENGTH_LONG).show()
                }
            } else {
                val handler = Handler(Looper.getMainLooper())
                handler.post {
                    Toast.makeText(this, "IN APP LINK NULL", Toast.LENGTH_LONG).show()
                }
            }
        }


    }
}
