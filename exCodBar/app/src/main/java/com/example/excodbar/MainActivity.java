package com.example.excodbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button btTiraFoto,btLeitura;
ImageView imgSuaImage;
EditText txLeitura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retiraFoto();
       lerCodigos();
    }

    private void lerCodigos() {
        btTiraFoto =(Button)findViewById(R.id.btnLeitura);
        txLeitura =(EditText)findViewById(R.id.edtLeitura);
        btLeitura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(abreCamera, 0);
            }
        });

    }

    private void retiraFoto(){
        btTiraFoto =  findViewById(R.id.btnTiraFoto);
        imgSuaImage = findViewById(R.id.suaImagem);

        btTiraFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(abreCamera, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){

        }
        Bundle bundle = data.getExtras();
        if (data!=null){
            Bitmap bitmap = (Bitmap)bundle.get("data");
            imgSuaImage.setImageBitmap(bitmap);
        }
    }


}