package br.com.whatsappandroid.cursoandroid.whatsapp.helper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Permissao {

    public static boolean validaPermissoes(int requestCode,Activity activity, String[] permissoes){

        if(Build.VERSION.SDK_INT >= 23){

            List<String> listaPermissoe = new ArrayList<String>();

            /*Percorrer as permissoes passadas, verificando uma a uma
            * se ja tem permissao liberada*/

            for(String permissao : permissoes){ // para cada uma das permissoes, vai ser guardada em permissao

                // checa se pra essa activity tem essas permissoes e ver se ta no mesmo nivel de onde o pacote esta instalado
                Boolean validaPermissao = ContextCompat.checkSelfPermission(activity,permissao) == PackageManager.PERMISSION_GRANTED;

                if(!validaPermissao){ //se nao tem essa permissao
                    listaPermissoe.add(permissao);
                }

            }

            /*Caso a lista esteja vazia, nao eh nescessario pedir permissao*/

            if(listaPermissoe.isEmpty()) return true;

            //covertendo em array de String

            String[] novasPermissoes = new String[listaPermissoe.size()];
            listaPermissoe.toArray(novasPermissoes); //passando a lista para o array novasPermissoes

            //Solicitar Permissoes
            ActivityCompat.requestPermissions(activity,novasPermissoes,requestCode); // request code eh o codigo da requisição que foi chamado essa solicitação de validação

        }

        return true;
    }
}
