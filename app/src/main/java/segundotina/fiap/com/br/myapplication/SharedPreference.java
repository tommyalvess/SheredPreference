package segundotina.fiap.com.br.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreference extends AppCompatActivity {

    EditText editT1;
    EditText editT2;
    CheckBox checkbox1;
    android.content.SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editT1 = (EditText)findViewById(R.id.editT1);
        editT2 = (EditText)findViewById(R.id.editT2);
        checkbox1 = (CheckBox)findViewById(R.id.checkbox1);

        //Inicializando o SharedPreference no modo privado

        sp = getPreferences(MODE_PRIVATE);

        editT1.setText(sp.getString("usuario", ""));
        editT2.setText(sp.getString("senha", ""));
    }


    public void logar(View view) {

        String usuario = editT1.getText().toString();
        String senha = editT2.getText().toString();

        if(usuario.trim().equals("fiap") && senha.trim().equals("123")){

            android.content.SharedPreferences.Editor e = sp.edit();


            if(checkbox1.isChecked()){

                e.putString("usuario", usuario);
                e.putString("senha", senha);

            }else {
                e.remove("usuario");
                e.remove("senha");
            }

            e.commit();

            Intent it = new Intent(this, DadosActivity.class);
            startActivity(it);

            return;
        }

        Toast.makeText(this, R.string.usuario_incorreto, Toast.LENGTH_SHORT).show();
    }
}
