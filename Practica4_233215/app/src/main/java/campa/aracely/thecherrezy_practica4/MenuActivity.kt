package campa.aracely.thecherrezy_practica4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCold: Button = findViewById(R.id.button_coldDrinks)
        btnCold.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("CATEGORY", "coldDrinks")
            startActivity(intent)
        }

        val btnHot: Button = findViewById(R.id.button_hotDrinks)
        btnHot.setOnClickListener{
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("CATEGORY", "hotDrinks")
            startActivity(intent)
        }

        val btnSweets: Button = findViewById(R.id.button_sweets)
        btnSweets.setOnClickListener{
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("CATEGORY", "sweets")
            startActivity(intent)
        }

        val btnSalties: Button = findViewById(R.id.button_salties)
        btnSalties.setOnClickListener{
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("CATEGORY", "salties")
            startActivity(intent)
        }
    }
}
