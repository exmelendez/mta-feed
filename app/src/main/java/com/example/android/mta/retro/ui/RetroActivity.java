package com.example.android.mta.retro.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.mta.R;
import com.example.android.mta.retro.api.model.GitHubRepo;
import com.example.android.mta.retro.api.service.GitHubClient;
import com.example.android.mta.retro.ui.adapter.GitHubRepoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroActivity extends AppCompatActivity {

    private ListView listView;
    private EditText usernameTextField;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retro_main);

        listView = (ListView) findViewById(R.id.pagination_list);
        usernameTextField = (EditText) findViewById(R.id.input_repo_name);
        button = (Button) findViewById(R.id.submit_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();

                GitHubClient client = retrofit.create(GitHubClient.class);
//        Call<List<GitHubRepo>> call = client.reposForUser("fs-opensource");
//        Call<List<GitHubRepo>> call = client.reposForUser("exmelendez");
                String username = usernameTextField.getText().toString();
                Call<List<GitHubRepo>> call = client.reposForUser(username);

                call.enqueue(new Callback<List<GitHubRepo>>() {
                    @Override
                    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                        List<GitHubRepo> repos = response.body();
                        listView.setAdapter(new GitHubRepoAdapter(RetroActivity.this, repos));
                    }

                    @Override
                    public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                        Toast.makeText(RetroActivity.this, "error :(", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}
