package br.senac.go.projetointegrador_2_semestre_2019.source;

public interface RepositoyCallBack <ResultType>{
    void onResult(ResultType resultType);
    void onError(Throwable e);
    void onEmpty();
}
