package br.com.whatsappandroid.cursoandroid.whatsapp.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.whatsappandroid.cursoandroid.whatsapp.fragment.ContatoFragment;
import br.com.whatsappandroid.cursoandroid.whatsapp.fragment.ConversaFragment;

//tratar os conteudos fa view pager
public class TabAdapter extends FragmentStatePagerAdapter { //recomendado para listagem de dados não estaticos, melhor controle de memoria

    private String[] tituloAbas = {"CONVERSAS", "CONTATOS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    } //


    @Override
    public Fragment getItem(int i) {//retorna para o pager o fragmento

        Fragment fragment = null; // retorna um fragmento nulo

        switch (i){

            case 0:
                fragment = new ConversaFragment(); // retorna o fragmento conversa
                break;
            case 1:
                fragment = new ContatoFragment(); // retorna o fragmento contato
                break;
        }

        return null;
    }

    @Override
    public int getCount() { //quantidade de abas

        return tituloAbas.length; //retorna o tamanho do array
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { //recupera os titulos de cadas uma das abas

        return tituloAbas[position]; //retorna o titulo da posição de acordo com array
    }
}
