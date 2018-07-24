package br.com.whatsappandroid.cursoandroid.whatsapp.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class ConfiguracaoFirebase { // quando ha um final a classe não pode ser extendida

    //com static o valor sera o mesmo independente das instancias
    private static DatabaseReference referenciaFirebase;

    private static FirebaseAuth autenticacao;

    public static DatabaseReference getFirebase(){ // com estatico nao precisa instanciar a classe

        if (referenciaFirebase == null) {
            // instacia o Firebase e pega a referencia a ele
            referenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }

        return referenciaFirebase;
    }

    public static FirebaseAuth getFireBaseAuth(){
        if(autenticacao == null){
            autenticacao = FirebaseAuth.getInstance(); // Instancia a autenticação do firebase
        }

        return autenticacao;
    }

}
