package campa.aracely.popcornfactory

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)

        val titulo = intent.getStringExtra("titulo")
        val sinopsis = intent.getStringExtra("sinopsis")
        val header = intent.getIntExtra("header", 0)
        val image = intent.getIntExtra("image", 0)
        findViewById<ImageView>(R.id.image_movie_detail).setImageResource(image)
        findViewById<TextView>(R.id.title_movie_detail).text = titulo
        findViewById<TextView>(R.id.sinopsis_movie_detail).text = sinopsis
    }
}