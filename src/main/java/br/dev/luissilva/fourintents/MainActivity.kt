package br.dev.luissilva.fourintents

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener{
            var dashboard = Intent(applicationContext, Dashboard::class.java)
            startActivity(dashboard)
        }

        val CustomClickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                startActivity(Intent(this@MainActivity, RecoveryPassword::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = Color.GRAY
                ds.isUnderlineText = false
            }
        }

        val textView = findViewById<TextView>(R.id.textView)

        val ss = SpannableString("Esqueceu sua senha? CLIQUE AQUI")
        ss.setSpan(CustomClickableSpan, 19, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = ss
        textView.movementMethod = LinkMovementMethod.getInstance()

    }
}