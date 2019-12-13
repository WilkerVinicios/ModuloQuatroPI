package br.senac.go.projetointegrador_2_semestre_2019.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.senac.go.projetointegrador_2_semestre_2019.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");
        final EditText editLogin = (EditText) findViewById(R.id.editTextUsuario);


        final EditText editSenha = (EditText) findViewById(R.id.editTextSenha);

        Button btnLogar = (Button) findViewById(R.id.btn_logar);

        btnLogar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ((!editLogin.getText().toString().equals("")) && (!editSenha.getText().toString().equals(""))) {
                } else if ((!editLogin.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(),
                            "Campo da senha vazio", Toast.LENGTH_SHORT).show();
                } else if ((!editSenha.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(),
                            "Campo da usuario vazio", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Campo de usuario e senha vazio", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(), TelaVeiculo.class);
                startActivity(intent);
                finish();
            }

        });

       }}






