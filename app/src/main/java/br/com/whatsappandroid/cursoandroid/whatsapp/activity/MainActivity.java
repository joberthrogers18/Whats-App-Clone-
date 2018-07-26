package br.com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import br.com.whatsappandroid.cursoandroid.whatsapp.R;
import br.com.whatsappandroid.cursoandroid.whatsapp.config.ConfiguracaoFirebase;

public class MainActivity extends AppCompatActivity {

    private Button botaoSair;
    private FirebaseAuth autenticacao;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toobar);
        toolbar.setTitle("WhatsApp");
        setSupportActionBar(toolbar); //metodo de suporte da actionbar, para funcionar corretamente

       /* botaoSair = findViewById(R.id.bt_sair);

        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autenticacao = ConfiguracaoFirebase.getFireBaseAuth();
                autenticacao.signOut(); //desloga o user

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent); //muda a activty

            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //metodo chamado para carregar o menu

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu); // parametros: menu_main e o menu padrão do metodo

        return true;
    }
}
