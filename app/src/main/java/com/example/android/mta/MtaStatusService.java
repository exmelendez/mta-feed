package com.example.android.mta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MtaStatusService {

    @GET("http://web.mta.info/status/serviceStatus.txt")
    Call<LineStatus> getMtaStatus();

}
