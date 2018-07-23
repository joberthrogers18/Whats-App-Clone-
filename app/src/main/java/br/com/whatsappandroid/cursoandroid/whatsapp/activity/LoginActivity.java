package br.com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.Random;

import br.com.whatsappandroid.cursoandroid.whatsapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText telefone;
    private EditText codigoPais;
    private EditText codigoArea;
    private EditText nome;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nome = findViewById(R.id.editNome);
        telefone = findViewById(R.id.editTelefone);
        codigoPais = findViewById(R.id.editCodPais);
        codigoArea = findViewById(R.id.editCodArea);
        cadastrar = findViewById(R.id.btCadastrar);

        // Definir mascaras

        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("NNNNN-NNNN"); // criando a mascara do telefone
        MaskTextWatcher maskTelefone = new MaskTextWatcher(telefone, simpleMaskTelefone); // dizendo que a mascara deve ser aplicada no edit text
        telefone.addTextChangedListener(maskTelefone);  //joga a mascara no edit e ela eh executada

        SimpleMaskFormatter simpleCodPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher maskCodPais = new MaskTextWatcher(codigoPais, simpleCodPais);
        codigoPais.addTextChangedListener(maskCodPais);

        SimpleMaskFormatter simpleCodArea = new SimpleMaskFormatter("NN");
        MaskTextWatcher maskCodArea = new MaskTextWatcher(codigoArea, simpleCodArea);
        codigoArea.addTextChangedListener(maskCodArea);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomeUsuario = nome.getText().toString();
                String telefoneCompleto = codigoPais.getText().toString() +
                        codigoArea.getText().toString() +
                        telefone.getText().toString();

                String telefoneSemFormatacao = telefoneCompleto.replace("+","");
                telefoneSemFormatacao = telefoneSemFormatacao.replace("-","");

                Log.i("Telefone:", telefoneSemFormatacao);

                //Gerar Token

                Random randomico = new Random();
                int numeroRandomico = randomico.nextInt(9999 - 1000) + 1000; // tokens apenas com quatro digitos

                String token = String.valueOf(numeroRandomico);

                Log.i("TOKEN", token);


            }
        });
    }
}
