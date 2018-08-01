package br.com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import br.com.whatsappandroid.cursoandroid.whatsapp.Adapter.TabAdapter;
import br.com.whatsappandroid.cursoandroid.whatsapp.R;
import br.com.whatsappandroid.cursoandroid.whatsapp.config.ConfiguracaoFirebase;
import br.com.whatsappandroid.cursoandroid.whatsapp.helper.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private Button botaoSair;
    private FirebaseAuth usuarioAutenticacao;
    private Toolbar toolbar;

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioAutenticacao = ConfiguracaoFirebase.getFireBaseAuth();

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


       slidingTabLayout = findViewById(R.id.stl_tabs);
       viewPager = findViewById(R.id.vp_pagina);

       //configurar o adapter
                                                                                //getSupportManager nada mais eh que uma habilitação dinamida para modificações de fragments
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager()); //passa para a tabAdapter para que a classe possa gerenciar os fragments quando apertar
        viewPager.setAdapter(tabAdapter); //adaptador para recuperar os itens, os fragmento, a quantidade de paginas e os titulos das abas

        slidingTabLayout.setViewPager(viewPager); //

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //metodo chamado para carregar o menu

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu); // parametros: menu_main e o menu padrão do metodo

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //chamado quando um item do menu eh selecionado

        switch (item.getItemId()){  // qual dos menus foi selecionado

            case R.id.item_sair:
                deslogarUsuario();
                return true;
            case R.id.item_configuracoes:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void deslogarUsuario(){

        usuarioAutenticacao.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
