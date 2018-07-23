package br.com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.HashMap;

import javax.xml.validation.Validator;

import br.com.whatsappandroid.cursoandroid.whatsapp.R;
import br.com.whatsappandroid.cursoandroid.whatsapp.helper.Preferencias;

public class ValidadorActivity extends AppCompatActivity {

    private Button botaoValidador;
    private EditText validador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        botaoValidador = findViewById(R.id.botaoValidar);
        validador = findViewById(R.id.editCodValida);

        SimpleMaskFormatter simpleMaskValidator = new SimpleMaskFormatter("NNNN"); // formatação
        MaskTextWatcher maskTextValidator = new MaskTextWatcher(validador,simpleMaskValidator);
        validador.addTextChangedListener(maskTextValidator);

        botaoValidador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Recuperar dados das preferencias do usuario

                Preferencias preferencias = new Preferencias(ValidadorActivity.this);
                HashMap<String, String> usuario = preferencias.getDadosUsuarios();

                String tokenGerado = usuario.get("token"); // recuperando o token
                String tokenDigitado = validador.getText().toString();


                if(tokenGerado.equals(tokenDigitado)){
                    Toast.makeText(ValidadorActivity.this, "Token VALIDADO!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ValidadorActivity.this,"Token não corresponde!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

