package tk.williamsouza.lerobrown

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var artist: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton = findViewById<Button>(R.id.generateButton)
        generateButton.setOnClickListener { generateLero() }

        artist = "Chorão"

        val spinner = findViewById<Spinner>(R.id.artists)
        ArrayAdapter.createFromResource(
                this,
                R.array.artists,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        artist = parent.getItemAtPosition(pos) as String
        val image = findViewById<ImageView>(R.id.artistImage)

        if (artist == "Chorão") {
            image.setImageResource(R.drawable.chorao)
        } else {
            image.setImageResource(R.drawable.renato)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        val image = findViewById<ImageView>(R.id.artistImage)
        if (artist == "Chorão") {
            image.setImageResource(R.drawable.chorao)
        } else {
            image.setImageResource(R.drawable.renato)
        }
    }

    fun generateLero() {
        var lyrics: List<String>
        if (artist == "Chorão") {
            lyrics = resources.getStringArray(R.array.brown).toList()

        } else {
            lyrics = resources.getStringArray(R.array.renato).toList()
        }

        val randomNumber = (0..lyrics.size).random()
        val lero = lyrics[randomNumber]
        val textLabel = findViewById<TextView>(R.id.lero)
        textLabel.text = lero.toString()

    }
}

