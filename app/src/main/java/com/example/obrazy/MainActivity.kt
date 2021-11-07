import android.R.attr.*
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.obrazy.R
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val CheckWidok: CheckBox =findViewById(R.id.CheckWidoczny)
        val Obrazek: ImageView =findViewById(R.id.Obrazek)

        val Obracacz: EditText =findViewById(R.id.Obrot)
        val SkalaX: EditText =findViewById(R.id.SkalaX)
        val SkalaY: EditText =findViewById(R.id.SkalaY)

        val ButtonNext: ImageButton =findViewById(R.id.ButtonNext)
        val ButtonPrev: ImageButton =findViewById(R.id.ButtonPrev)
        val ButtonClear: ImageButton =findViewById(R.id.ButtonClear)
        val ButtonCamera: ImageButton =findViewById(R.id.ButtonCamera)

        var KtoryObraz = 1

        fun ZmianaObrazu(){
            if(KtoryObraz>4){KtoryObraz=4}
            if(KtoryObraz<1){KtoryObraz=1}
            if(KtoryObraz==1){Obrazek.setImageResource(R.drawable.pies1)}
            if(KtoryObraz==2){Obrazek.setImageResource(R.drawable.pies2)}
            if(KtoryObraz==3){Obrazek.setImageResource(R.drawable.pies3)}
            if(KtoryObraz==4){Obrazek.setImageResource(R.drawable.pies4)}
        }

        ButtonNext.setOnClickListener(){
            KtoryObraz=KtoryObraz+1
            ZmianaObrazu()
        }
        ButtonPrev.setOnClickListener(){
            KtoryObraz=KtoryObraz-1
            ZmianaObrazu()
        }
        ButtonClear.setOnClickListener(){
            KtoryObraz=0
            Obrazek.setImageResource(R.drawable.ic_launcher_foreground)
        }

        ButtonCamera.isEnabled=false
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA )!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),111)
        }else{
            ButtonCamera.isEnabled=true
        }
        ButtonCamera.setOnClickListener(){
            var x = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(x,101)
        }

        CheckWidok.setOnClickListener(){
            if(CheckWidok.isChecked()){
                Obrazek.setVisibility(View.VISIBLE);
            }else{
                Obrazek.setVisibility(View.INVISIBLE);
            }
        }
        Obracacz.setOnClickListener(){
            if(Obracacz.text.toString()!="") {
                var kat = Obracacz.text.toString().toInt().toFloat();
                Obrazek.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
                Obrazek.setRotation(kat)
            }
        }
        SkalaY.setOnClickListener(){
            if(SkalaY.text.toString()!="") {
                var ScaleY = SkalaY.text.toString().toInt().toFloat();
                Obrazek.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
                Obrazek.setScaleY(ScaleY)
            }
        }
        SkalaX.setOnClickListener(){
            if(SkalaX.text.toString()!="") {
                var ScaleX = SkalaX.text.toString().toInt().toFloat();
                Obrazek.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
                Obrazek.setScaleX(ScaleX)
            }
        }

    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode ==111 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            findViewById<ImageView>(R.id.ButtonCamera).isEnabled=true
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data:Intent?){
        super.onActivityResult(requestCode,resultCode,data)
        if(requestCode==101)
        {
            var ObrazKamery  = data?.getParcelableExtra<Bitmap>("data")
            findViewById<ImageView>(R.id.Obrazek).setImageBitmap(ObrazKamery)
        }
    }
}
