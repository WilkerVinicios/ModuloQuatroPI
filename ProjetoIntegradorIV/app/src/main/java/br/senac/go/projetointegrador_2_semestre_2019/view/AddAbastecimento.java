package br.senac.go.projetointegrador_2_semestre_2019.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.senac.go.projetointegrador_2_semestre_2019.R;
import br.senac.go.projetointegrador_2_semestre_2019.model.Abastecimento;
import br.senac.go.projetointegrador_2_semestre_2019.source.VeiculoRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAbastecimento extends AppCompatActivity {

    private EditText editT_placa;
    private EditText editT_posto;
    private EditText editT_odo;
    private EditText editT_total_litros;
    private EditText editT_total_pago;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button bnt_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abastecimento);
        setTitle("Adicionar abastecimento");

        addListenerOnButton();

    }

    public void addListenerOnButton() {
        editT_placa = findViewById(R.id.editT_placa);
        editT_posto = findViewById(R.id.editT_posto);
        editT_odo = findViewById(R.id.editT_odo);
        editT_total_litros = findViewById(R.id.editT_total_litros);
        editT_total_pago = findViewById(R.id.editT_total_pago);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        bnt_salvar = (Button) findViewById(R.id.bnt_salvar);
        bnt_salvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.bnt_salvar:

                        // seleciona o botão de opção radioGroup
                        int selectedId = radioGroup.getCheckedRadioButtonId();

                        // encontra o botão de opção pelo ID retornado
                        radioButton = (RadioButton) findViewById(selectedId);

                        Abastecimento abastecimento = new Abastecimento();

                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date hoje = new Date();

                        abastecimento.setData(df.format(hoje));
                        abastecimento.setPlacaVeiculo(editT_placa.getText().toString());
                        abastecimento.setNomePosto(editT_posto.getText().toString());
                        abastecimento.setOdo(Float.parseFloat(editT_odo.getText().toString()));
                        abastecimento.setLitros(Float.parseFloat(editT_total_litros.getText().toString()));
                        abastecimento.setTotalPago(Float.parseFloat(editT_total_pago.getText().toString()));

                        abastecimento.setTipoCombustivel((String) radioButton.getText());

                        VeiculoRepository.apiManager.createAbastecimento(abastecimento, new Callback<Abastecimento>() {

                            @Override
                            public void onResponse(Call<Abastecimento> call, Response<Abastecimento> response) {
                                Abastecimento responseAbastecimento = response.body();
                                if (response.isSuccessful() && responseAbastecimento != null) {
                                    Toast.makeText(AddAbastecimento.this, "Abastecimento cadastrado com sucesso",Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(AddAbastecimento.this,
                                            String.format("Resposta %s", String.valueOf(response.code()))
                                            , Toast.LENGTH_LONG).show();

                                    Toast.makeText(AddAbastecimento.this, "Consumo cadastrado", Toast.LENGTH_SHORT).show();
                                }
                            }


                            @Override
                            public void onFailure(Call<Abastecimento> call, Throwable t) {
                                Toast.makeText(AddAbastecimento.this,
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