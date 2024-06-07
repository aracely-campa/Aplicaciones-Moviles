package mx.itson.edu.e1.campaaracely

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var txtOriginalPrice: EditText
    private lateinit var procentage: TextView
    private lateinit var procentageTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtOriginalPrice = findViewById(R.id.txtOriginalPrice)
        procentage = findViewById(R.id.procentage)
        procentageTotal = findViewById(R.id.procentageTotal)


        findViewById<Button>(R.id.diez_porciento).setOnClickListener {
            calculatePercentage(0.1)
        }
        findViewById<Button>(R.id.quince_porciento).setOnClickListener {
            calculatePercentage(0.15)
        }
        findViewById<Button>(R.id.veinte_porciento).setOnClickListener {
            calculatePercentage(0.2)
        }
        findViewById<Button>(R.id.veinticinco_porciento).setOnClickListener {
            calculatePercentage(0.25)
        }
        findViewById<Button>(R.id.treinta_porciento).setOnClickListener {
            calculatePercentage(0.3)
        }
        findViewById<Button>(R.id.cuarenta_porciento).setOnClickListener {
            calculatePercentage(0.4)
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            calculateTotal()
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            calculateDiscount()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun calculatePercentage(percentage: Double) {
        val originalPrice = txtOriginalPrice.text.toString().toDoubleOrNull() ?: return
        val tipAmount = originalPrice * percentage
        procentage.text = "%.2f".format(tipAmount)
    }

    private fun calculateTotal() {
        val originalPrice = txtOriginalPrice.text.toString().toDoubleOrNull() ?: return
        val tipAmount = procentage.text.toString().toDoubleOrNull() ?: return
        val totalPrice = originalPrice + tipAmount
        procentageTotal.text = "%.2f".format(totalPrice)
    }
    private fun calculateDiscount() {
        val originalPrice = txtOriginalPrice.text.toString().toDoubleOrNull() ?: return
        val tipAmount = procentage.text.toString().toDoubleOrNull() ?: return
        val discountedPrice = originalPrice - tipAmount
        procentageTotal.text = "%.2f".format(discountedPrice)
    }
}
