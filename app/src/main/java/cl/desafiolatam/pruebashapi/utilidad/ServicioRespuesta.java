package cl.desafiolatam.pruebashapi.utilidad;

import java.util.List;

import cl.desafiolatam.pruebashapi.modelo.ResponseItem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioRespuesta {

    @GET("api/all.json")
    Call<List<ResponseItem>> getSuperHero();
}