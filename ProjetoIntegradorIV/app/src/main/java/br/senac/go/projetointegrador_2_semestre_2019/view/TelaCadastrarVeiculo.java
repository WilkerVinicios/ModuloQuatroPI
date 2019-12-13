package br.senac.go.projetointegrador_2_semestre_2019.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import br.senac.go.projetointegrador_2_semestre_2019.R;
import br.senac.go.projetointegrador_2_semestre_2019.model.Veiculos;
import br.senac.go.projetointegrador_2_semestre_2019.source.ApiSource;
import br.senac.go.projetointegrador_2_semestre_2019.source.GerenciadorApi;
import br.senac.go.projetointegrador_2_semestre_2019.source.VeiculoRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static br.senac.go.projetointegrador_2_semestre_2019.source.VeiculoRepository.*;

public class TelaCadastrarVeiculo extends AppCompatActivity {

    private EditText edit_placa;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        apiManager = GerenciadorApi.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrat_veiculo);
        setTitle("Cadastro de veiculo");

        addListenerOnButton();


    }

    public void addListenerOnButton() {
        edit_placa = findViewById(R.id.editT_placa);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnSalvar = (Button) findViewById(R.id.bnt_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.bnt_salvar:

                        // seleciona o botão de opção radioGroup
                        int selectedId = radioGroup.getCheckedRadioButtonId();

                        // encontra o botão de opção pelo ID retornado
                        radioButton = (RadioButton) findViewById(selectedId);

                        //Veiculos veiculos = new Veiculos(edit_placa.getText().toString(), radioButton.getText());

                        Veiculos veiculos = new Veiculos();
                        veiculos.setPlaca(edit_placa.getText().toString());
                        veiculos.setTipo((String) radioButton.getText());

                        VeiculoRepository.apiManager.createVeiculo(veiculos, new Callback<Veiculos>() {

                            @Override
                            public void onResponse(Call<Veiculos> call, Response<Veiculos> response) {
                                Veiculos responseVeiculo = response.body();
                                if (response.isSuccessful() && responseVeiculo != null) {
                                    Toast.makeText(TelaCadastrarVeiculo.this,
                                            String.format("o Veiculo %s do tipo %s foi criando , com este id %s",
                                                    responseVeiculo.getPlaca(),
                                                    responseVeiculo.getTipo(),
                                                    responseVeiculo.getId()),
                                            Toast.LENGTH_LONG)
                                            .show();
                                    finish();
                                } else {
                                    Toast.makeText(TelaCadastrarVeiculo.this,
                                            String.format("Resposta %s", String.valueOf(response.code()))
                                            , Toast.LENGTH_LONG).show();

                                    Toast.makeText(TelaCadastrarVeiculo.this, "Veiculo cadastrado", Toast.LENGTH_SHORT).show();
                                }
                            }


                            @Override
                            public void onFailure(Call<Veiculos> call, Throwable t) {
                                Toast.makeText(TelaCadastrarVeiculo.this,
                                        "Error: " + t.getMessage()
                                        , Toast.LENGTH_LONG).show();
                            }
                        });

                        break;


                }

            }
        });
    }
}