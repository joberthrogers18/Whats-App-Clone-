package br.com.whatsappandroid.cursoandroid.whatsapp.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class ConfiguracaoFirebase { // quando ha um final a classe não pode ser extendida

    //com static o valor sera o mesmo independente das instancias
    private static DatabaseReference referenciaFirebase;

    public static DatabaseReference getFirebase(){ // com estatico nao precisa instanciar a classe

        if (referenciaFirebase == null) {
            // instacia o Firebase e pega a referencia a ele
            referenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }

        return referenciaFirebase;
    }

}
