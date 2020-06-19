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

        sendMail.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] TO_EMAIL = {"seuemail@seuemail.com"}; //caso queira acrescentar mais destinatários, basta acrescentar ao array
                Intent intent =  new Intent( Intent.ACTION_SEND);
                intent.putExtra( Intent.EXTRA_EMAIL,TO_EMAIL);
                intent.putExtra( Intent.EXTRA_SUBJECT, "App Exercise: " + titulo.getText().toString() );
                intent.putExtra( Intent.EXTRA_TEXT, editText.getText().toString() );
                intent.setType("message/rfc822");
                try{
                    startActivity( Intent.createChooser( intent, "Enviar e-mail" ) );
                    Toast.makeText( EnviarTextoActivity.this, "Escolha um app para enviar o seu e-mail", Toast.LENGTH_SHORT ).show();
                }catch (Exception e){
                    e.getMessage();
                    Toast.makeText( EnviarTextoActivity.this, "Erro ao enviar. Por favor, tente novamente!", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
}
