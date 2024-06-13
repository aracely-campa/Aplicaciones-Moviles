package campa.aracely.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.button_in)


        button.setOnClickListener {

            val intent = Intent(this, catalogoActivity::class.java)
            startActivity(intent)
        }
    }
}