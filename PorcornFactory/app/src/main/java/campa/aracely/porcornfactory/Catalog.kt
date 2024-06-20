package campa.aracely.porcornfactory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Catalog : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter? = null

    var peliculas: ArrayList<Pelicula> = ArrayList()
    var series: ArrayList<Pelicula> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        cargarPeliculas()

        adapter = PeliculaAdapter(this, peliculas)
        seriesAdapter = PeliculaAdapter(this, series)

        val gridPelis: GridView = findViewById(R.id.movies_catalog)
        gridPelis.adapter = adapter

        val gridSeries: GridView = findViewById(R.id.series_catalog)
        gridSeries.adapter = seriesAdapter
    }

    fun cargarPeliculas() {
        peliculas.add(Pelicula(
            "Big Hero 6",
            R.drawable.bighero6,
            R.drawable.headerbighero6,
            "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called ‘Big Hero 6.’"
        ))
        peliculas.add(Pelicula(
            "Inception",
            R.drawable.inception,
            R.drawable.inceptionheader,
            "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."
        ))
        peliculas.add(Pelicula(
            "Leap Year",
            R.drawable.leapyear,
            R.drawable.leapyearheader,
            "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."
        ))
        peliculas.add(Pelicula(
            "Toy Story",
            R.drawable.toystory,
            R.drawable.toystoryheader,
            "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentally Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home."
        ))
        peliculas.add(Pelicula(
            "1917",
            R.drawable.nineteensevent,
            R.drawable.nineteenseventheader,
            "sinopsis"
        ))

        series.add(Pelicula("Bones", R.drawable.bones, R.drawable.bonesheader, "Serie bones"))
        series.add(Pelicula("Drwho", R.drawable.drwho, R.drawable.drwhoheader, "Serie Drwho"))
        series.add(Pelicula(
            "Friends",
            R.drawable.friends,
            R.drawable.friendsheader,
            "Serie friends"
        ))
        series.add(Pelicula("Mib", R.drawable.mib, R.drawable.mibheader, "Serie Mib"))
        series.add(Pelicula("Small Ville", R.drawable.smallville, R.drawable.smallvilleheader, "smallville"))
    }

    class PeliculaAdapter : BaseAdapter {
        var context: Context? = null
        var peliculas = ArrayList<Pelicula>()

        constructor(context: Context, peliculas: ArrayList<Pelicula>) {
            this.context = context
            this.peliculas = peliculas
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val pelicula = peliculas[position]
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.cell_movie, null)
            val image: ImageView = view.findViewById(R.id.image_movie_cell)
            val title: TextView = view.findViewById(R.id.movie_title_cell)
            image.setImageResource(pelicula.image)
            title.text = pelicula.titulo
            image.setOnClickListener {
                val intent = Intent(context, MovieDetail::class.java).apply {
                    putExtra("titulo", pelicula.titulo)
                    putExtra("sinopsis", pelicula.sinopsis)
                    putExtra("header", pelicula.header)
                    putExtra("image", pelicula.image)
                }
                context!!.startActivity(intent)
            }
            return view
        }
    }
}

