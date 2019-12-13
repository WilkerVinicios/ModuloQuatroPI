package br.senac.go.projetointegrador_2_semestre_2019.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.senac.go.projetointegrador_2_semestre_2019.R;

public class TelaOpcao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opcao);

        setTitle("Opção");

        Button btnAddVeiculo = (Button) findViewById(R.id.AddVeiculo);

        btnAddVeiculo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TelaCadastrarVeiculo.class);
                startActivity(intent);

            }

        });

        Button btnAbastecimento = (Button) findViewById(R.id.bntAbastecimentos);

        btnAbastecimento .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TelaAbastecimento.class);
                startActivity(intent);
                finish();
            }

        });

    }
}
