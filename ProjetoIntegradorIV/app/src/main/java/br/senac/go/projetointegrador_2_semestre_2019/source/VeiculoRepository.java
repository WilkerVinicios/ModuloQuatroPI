package br.senac.go.projetointegrador_2_semestre_2019.source;

import android.app.Application;

import br.senac.go.projetointegrador_2_semestre_2019.model.Veiculos;
import retrofit2.Callback;

public class VeiculoRepository extends Application {

    public static GerenciadorApi apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = GerenciadorApi.getInstance();
    }
}
