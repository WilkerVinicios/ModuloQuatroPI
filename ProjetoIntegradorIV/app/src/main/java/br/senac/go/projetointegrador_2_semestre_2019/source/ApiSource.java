package br.senac.go.projetointegrador_2_semestre_2019.source;

import java.util.List;

import br.senac.go.projetointegrador_2_semestre_2019.model.Abastecimento;
import br.senac.go.projetointegrador_2_semestre_2019.model.Veiculos;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.Call;
import br.senac.go.projetointegrador_2_semestre_2019.model.Usuario;
import retrofit2.http.POST;

public interface ApiSource {
    @GET("usuario")
    Call<List<Usuario>> getUsuario();

    @POST("veiculos")
    Call<Veiculos> createVeiculo(@Body Veiculos veiculos);

    @GET("veiculos")
    Call<List<Veiculos>> getVeiculos();

    @GET("abastecimento")
    Call<List<Abastecimento>> getAbastecimento();

    @POST("abastecimento")
    Call<Abastecimento> createAbastecimento(@Body Abastecimento abastecimento);

}
