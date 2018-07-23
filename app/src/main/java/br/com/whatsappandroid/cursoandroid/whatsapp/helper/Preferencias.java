package br.com.whatsappandroid.cursoandroid.whatsapp.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class Preferencias {

    private Context contexto;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "whatsapp.preferencias";
    private SharedPreferences.Editor editor;

    private final String CHAVE_NOME = "nome";
    private final String CHAVE_TELEFONE = "telefone";
    private final String CHAVE_TOKEN = "token";

    public Preferencias(Context contextoParametro){ // construtor

        contexto = contextoParametro;
        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE); // pega o contexto ou seja a activity e salva tudo gerado em um arquivo, apenas o app pode acessar
        editor = preferences.edit(); //possibilidade de edição do arquivo, inserindo e excluindo


    }

    public void salvarUsuarioPreferencias( String nome, String telefone, String token){

        editor.putString(CHAVE_NOME, nome); // parecido com a area stage do git
        editor.putString(CHAVE_TELEFONE, telefone);
        editor.putString(CHAVE_TOKEN, token);
        editor.commit(); // salva no arquivo de preferencias

    }

    public HashMap<String, String>  getDadosUsuarios() {// cria uma lista com indice e valor para recuperar do arquivo

        HashMap<String, String> dadosUsuario = new HashMap<>();

        dadosUsuario.put(CHAVE_NOME, preferences.getString(CHAVE_NOME, null)); // adiciona na lista o nome com a key adicionada
        dadosUsuario.put(CHAVE_TELEFONE, preferences.getString(CHAVE_TELEFONE, null)); // a key e depois um valor default caso nao tenha a chave
        dadosUsuario.put(CHAVE_TOKEN,preferences.getString(CHAVE_TOKEN, null));

        return dadosUsuario;

    }
}
