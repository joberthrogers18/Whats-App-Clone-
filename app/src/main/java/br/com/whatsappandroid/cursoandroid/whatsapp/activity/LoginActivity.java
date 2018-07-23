package br.com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.com.whatsappandroid.cursoandroid.whatsapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText telefone;
    private EditText codigoPais;
    private EditText codigoArea;
    private EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nome = findViewById(R.id.editNome);
        telefone = findViewById(R.id.editTelefone);
        codigoPais = findViewById(R.id.editCodPais);
        codigoArea = findViewById(R.id.editCodArea);

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
    }
}
