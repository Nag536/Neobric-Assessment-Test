package com.neobric_assessment_test;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemsModelClass> sourceDataArray;
    private ItemsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        sourceDataArray = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ItemsAdapter(MainActivity.this,
                sourceDataArray);
        recyclerView.setAdapter(mAdapter);

        new fetchData().execute();
    }

    private class fetchData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            try {

                JSONArray responseArray = new JSONArray(UtilClass.responseString);
                for (int i = 0; i < 15; i++) {
                    responseArray.put(responseArray.getJSONObject(i));
                }
                for (int i = 0; i < responseArray.length(); i++) {
                    JSONObject resultsObject = responseArray.getJSONObject(i);
                    ItemsModelClass dataItem = new ItemsModelClass(
                            resultsObject.optString("firstName"),
                            resultsObject.optString("lastName"),
                            resultsObject.optString("content"),
                            resultsObject.optString("messageType"),
                            resultsObject.optInt("messageID"),
                            resultsObject.optInt("id")
                    );
                    sourceDataArray.add(dataItem);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            if (sourceDataArray != null) {
                mAdapter.notifyDataSetChanged();
            } else {
                UtilClass.ShowToastMessage(getApplicationContext(), "No data found!");
            }
            super.onPostExecute(s);
        }
    }

}
