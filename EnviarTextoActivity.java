package com.victormagosso.ingleseingles.exercicios.writing;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.victormagosso.ingleseingles.R;

public class EnviarTextoActivity extends AppCompatActivity {
    TextView titulo;
    EditText editText;
    Button sendMail;
    WritingActivity writingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.enviar_texto );
        getSupportActionBar().hide();

        titulo = findViewById( R.id.titulo);
        editText = findViewById( R.id.editText );
        sendMail = findViewById( R.id.sendMail );
        writingActivity = new WritingActivity();

        //nao consegui fazer passar ainda
        Bundle bundle = new Bundle(  );
        final String tema = bundle.getString("tema");


        sendMail.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] TO_EMAIL = {"ingleseingles@gmail.com"};
                Intent intent =  new Intent( Intent.ACTION_SEND);
                intent.putExtra( Intent.EXTRA_EMAIL,TO_EMAIL);
                intent.putExtra( Intent.EXTRA_SUBJECT, "App Exercise: " + tema );
                intent.putExtra( Intent.EXTRA_TEXT, editText.getText().toString() );
                intent.setType("message/rfc822");
                try{
                    startActivity( Intent.createChooser( intent, "Enviar e-mail" ) );
                    Toast.makeText( EnviarTextoActivity.this, "Please, choose an app to send you e-mail", Toast.LENGTH_SHORT ).show();
                }catch (Exception e){
                    e.getMessage();
                    Toast.makeText( EnviarTextoActivity.this, "Erro ao enviar. Por favor, tente novamente!", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
}