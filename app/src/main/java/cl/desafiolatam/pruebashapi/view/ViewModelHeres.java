package cl.desafiolatam.pruebashapi.view;


import android.util.Log;
import android.widget.Toast;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import cl.desafiolatam.pruebashapi.R;
import cl.desafiolatam.pruebashapi.cliente.ClienteRetrofit;
import cl.desafiolatam.pruebashapi.modelo.ResponseItem;
import cl.desafiolatam.pruebashapi.utilidad.ServicioRespuesta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelHeres extends ViewModel {

    private MutableLiveData<List<ResponseItem>> responseMutableLiveData =new MutableLiveData<>();
    private MutableLiveData<ResponseItem> responseMutableLiveDataItem =new MutableLiveData<>();

    private ServicioRespuesta servicio = ClienteRetrofit.getInstance(ClienteRetrofit.BASE_URL);



    public  void  llamarApi(){




        servicio.getSuperHero().enqueue(new Callback<List<ResponseItem>>() {

            @Override
            public void onResponse(Call<List<ResponseItem>> call, Response<List<ResponseItem>> response) {
                responseMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ResponseItem>> call, Throwable t) {
              Log.i("fail",t.getMessage());
              call.cancel();
            }
        });


    }
    public void viewHERES(ResponseItem responseItem){
        responseMutableLiveDataItem.setValue(responseItem);
    }


    public MutableLiveData<List<ResponseItem>> getResponseMutableLiveData() {
        return responseMutableLiveData;
    }

    public MutableLiveData<ResponseItem> getResponseMutableLiveDataItem() {
        return responseMutableLiveDataItem;
    }
}

