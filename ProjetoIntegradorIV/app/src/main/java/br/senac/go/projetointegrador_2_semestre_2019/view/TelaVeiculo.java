package br.senac.go.projetointegrador_2_semestre_2019.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.senac.go.projetointegrador_2_semestre_2019.R;
import br.senac.go.projetointegrador_2_semestre_2019.model.Abastecimento;
import br.senac.go.projetointegrador_2_semestre_2019.model.Veiculos;
import br.senac.go.projetointegrador_2_semestre_2019.source.ApiSource;
import br.senac.go.projetointegrador_2_semestre_2019.source.GerenciadorApi;
import br.senac.go.projetointegrador_2_semestre_2019.source.VeiculoAdapter;
import br.senac.go.projetointegrador_2_semestre_2019.source.VeiculoRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaVeiculo extends AppCompatActivity {

    private VeiculoAdapter veiculoAdapter;
    private RecyclerView myRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Veiculos");
        setContentView(R.layout.activity_tela_veiculo);



        FloatingActionButton fab = findViewById(R.id.float_bnt);
        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), TelaOpcao.class);
                startActivity(intent);

            }
        });


        ApiSource service = GerenciadorApi.getRetrofitInstance().create(ApiSource.class);
        Call<List<Veiculos>> call = service.getVeiculos();
        call.enqueue(new Callback<List<Veiculos>>() {

            @Override
            public void onResponse(Call<List<Veiculos>> call, Response<List<Veiculos>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Veiculos>> call, Throwable throwable) {
                Toast.makeText(TelaVeiculo.this, "Não foi possível carregar os veiculos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadDataList(List<Veiculos> carList) {

        myRecyclerView = findViewById(R.id.myRecyclerView);
        veiculoAdapter = new VeiculoAdapter(carList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TelaVeiculo.this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(veiculoAdapter);

    }

}
