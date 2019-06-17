package com.example.tae.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tae.retrofit.model.ApIService;
import com.example.tae.retrofit.model.ApiClient;
import com.example.tae.retrofit.model.StarWarsCharacters;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    //6 Finally,
    Call<StarWarsCharacters> starWarsCharacterCall; //cReate call to character to use it
    StarWarsCharacters starWarsCharacter;

    @BindView(R.id.editName)
    TextView editName;
    @BindView(R.id.editMass)
    TextView editMass;
    @BindView(R.id.editHeight)
    TextView editHeight;
    @BindView(R.id.editBirthYear)
    TextView editBirthYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ApIService apIService = ApiClient.getClient(this).
                create(ApIService.class); //This is what is used to make calls!


      // for the assignment put the following code under a button click
        starWarsCharacterCall = apIService.getCharacter(3);//So starwars character 7 is printedT
        // end of btn click

        starWarsCharacterCall.enqueue(new Callback<StarWarsCharacters>() {
            @Override
            public void onResponse(Call<StarWarsCharacters> call, Response<StarWarsCharacters> response) {
                starWarsCharacter = response.body(); //Magic is done here
                editName.setText(starWarsCharacter.getName()); //Edit text in app to display name form online repos
                editMass.setText(starWarsCharacter.getMass() + "kg");
                editHeight.setText(starWarsCharacter.getHeight());
                editBirthYear.setText(starWarsCharacter.getBirthYear());

            }

            @Override
            public void onFailure(Call<StarWarsCharacters> call, Throwable t) {

            }
        });


    }
}
