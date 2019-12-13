package br.senac.go.projetointegrador_2_semestre_2019.source;

import java.util.List;

import br.senac.go.projetointegrador_2_semestre_2019.model.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuarioRepository implements UsuarioRepositoryInterface{

        private ApiSource api;

        public UsuarioRepository(ApiSource api) {
            this.api = api;
        }

        @Override
        public void getAll(final RepositoyCallBack<List<Usuario>> callBack) {
            api.getUsuario().enqueue(new Callback<List<Usuario>>() {

                @Override
                public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                    callBack.onResult(response.body());
                }

                @Override
                public void onFailure(Call<List<Usuario>> call, Throwable t) {
                    callBack.onEmpty();
                }
            });

        }

}
