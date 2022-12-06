package de.info3.uebung3_nicomichel;

import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.info3.uebung3_nicomichel.network.KvvService;
import de.info3.uebung3_nicomichel.network.Result;
import de.info3.uebung3_nicomichel.network.ServingLine;
import de.info3.uebung3_nicomichel.network.DateTime;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DepartureActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departure);
        ListView listView;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://projekte.kvv-efa.de/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KvvService service = retrofit.create(KvvService.class);
        Call<Result> resultCall = service.listDepartures();  //KvvService Interface usages

        listView=(ListView)findViewById(R.id.listview);
        ArrayList<String> arrayList=new ArrayList<>();

        //ArrayList<String> arrayList2 = new ArrayList<>();

        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                Log.d("DepartureActivity",String.valueOf(result.getDepartureList().size()));

                for (int i = 0; i<40; i++)
                {
                    //Log.d("Ausgabe", String.valueOf(result.getDepartureList().get(i)));
                    Log.d("Name"+' ' +i, result.getDepartureList().get(i).getServingLine().getName());
                    Log.d("Number"+' ' +i, result.getDepartureList().get(i).getServingLine().getNumber());
                    Log.d("Direction"+' ' +i, result.getDepartureList().get(i).getServingLine().getDirection());
                    //Log.d("Stunde"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour());
                    //Log.d("Minute"+' ' + i, result.getDepartureList().get(i).getDateTime().getMinute());
                    /*String minute = result.getDepartureList().get(i).getDateTime().getMinute();
                    if(minute == "0")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }
                    else if (minute == "1")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }
                    else if (minute == "2")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }
                    else if (minute == "3")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }
                    else if (minute == "4")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }
                    else if (minute == "5")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }
                    else if (minute == "6")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());

                    }else if (minute == "7")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }
                    else if (minute == "8")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }
                    else if (minute == "9")
                    {
                        Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+"0"+result.getDepartureList().get(i).getDateTime().getMinute());
                    }*/
                    //String hhmm = result.getDepartureList().get(i).getDateTime().getHour()+":"+minute;
                    Log.d("HH:mm"+' ' +i, result.getDepartureList().get(i).getDateTime().getHour()+":"+result.getDepartureList().get(i).getDateTime().getMinute());
                    Log.d("Leerzeile"," ");

                    arrayList.add(result.getDepartureList().get(i).getServingLine().getNumber()+" "+result.getDepartureList().get(i).getServingLine().getDirection()+"           "+result.getDepartureList().get(i).getDateTime().getHour()+":"+result.getDepartureList().get(i).getDateTime().getMinute());
                    //arrayList2.add(result.getDepartureList().get(i).getDateTime().getHour()+result.getDepartureList().get(i).getDateTime().getMinute());

                    ArrayAdapter arrayAdapter1 = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, arrayList);
                    listView.setAdapter(arrayAdapter1);

                    //ArrayAdapter arrayAdapter2 = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_2, arrayList2);
                    //listView.setAdapter(arrayAdapter2);
                }




            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("DepartureActivity","Anfragefehler");
            }
        });

    }
}