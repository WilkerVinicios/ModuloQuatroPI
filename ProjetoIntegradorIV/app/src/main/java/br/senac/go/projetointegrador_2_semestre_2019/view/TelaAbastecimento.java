package br.senac.go.projetointegrador_2_semestre_2019.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.senac.go.projetointegrador_2_semestre_2019.R;
import br.senac.go.projetointegrador_2_semestre_2019.model.Abastecimento;
import br.senac.go.projetointegrador_2_semestre_2019.model.Veiculos;
import br.senac.go.projetointegrador_2_semestre_2019.source.AbastecimentoAdapter;
import br.senac.go.projetointegrador_2_semestre_2019.source.ApiSource;
import br.senac.go.projetointegrador_2_semestre_2019.source.GerenciadorApi;
import br.senac.go.projetointegrador_2_semestre_2019.source.VeiculoAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaAbastecimento extends AppCompatActivity {

    private AbastecimentoAdapter abastecimentoAdapter;
    private RecyclerView myRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Abastecimentos");
        setContentView(R.layout.activity_tela_abastecimento);

        Button bnt = findViewById(R.id.bntRelatorio);
        bnt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), TelaRelatorio.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.btn_addAbastecimento);
        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), AddAbastecimento.class);
                startActivity(intent);

            }
        });

        ApiSource service = GerenciadorApi.getRetrofitInstance().create(ApiSource.class);
        Call<List<Abastecimento>> call = service.getAbastecimento();
        call.enqueue(new Callback<List<Abastecimento>>() {

            @Override
            public void onResponse(Call<List<Abastecimento>> call, Response<List<Abastecimento>> response) {
                dataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Abastecimento>> call, Throwable throwable) {
                Toast.makeText(TelaAbastecimento.this, "Não foi possível carregar os abastecimentos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dataList(List<Abastecimento> abastecimentoList) {

        myRecyclerView = findViewById(R.id.RecyclerViewAbastecimento);
        abastecimentoAdapter = new AbastecimentoAdapter(abastecimentoList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TelaAbastecimento.this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(abastecimentoAdapter);

    }

}
