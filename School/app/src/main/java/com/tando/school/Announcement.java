package com.tando.school;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Announcement extends AppCompatActivity {
    //returns the simple name of the underlying class, easier to track in the Android monitor
    private String TAG = Announcement.class.getSimpleName();
    //Prpgress bar while retrieving data
    private ProgressDialog pDialog;
    //Declare ListView
    private ListView AnnouncementList;
    // URL to get calendar JSON
    private static String url ="https://schoolserver-tand089.c9users.io/announcement.php";
    //Declare an array to store the list of items
    ArrayList<HashMap<String, String>> announcList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        announcList = new ArrayList<>();

        AnnouncementList = (ListView) findViewById(R.id.announcList);

        //execute the GetEvents class
        new GetEvents().execute();
    }
    /**
     * Async task class to get json by making HTTP call
     */
    //Create a GetEvents class to make http calls on background thread
    private class GetEvents extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Announcement.this);
            pDialog.setMessage("Loading...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            //call the HttpHandler class
            HttpHandler httpHandler = new HttpHandler();
            // Making a request to url and getting response
            String jsonStr = httpHandler.makeServiceCall(url);
            //make a log to check for response or error
            Log.e(TAG, "Response from url: " + jsonStr);
            //Get JSON
            if (jsonStr != null) {
                JSONObject jsonObj = null;
                try {
                    jsonObj = new JSONObject(jsonStr);
                    /* Getting JSON Array node
                    * Note: the Annoucement is the object node in our JSON. Check the JSON */
                    JSONArray calendarList = jsonObj.getJSONArray("Annoucement");

                    // looping through All Events
                    for (int i = 0; i < calendarList.length(); i++) {
                        JSONObject c = calendarList.getJSONObject(i);
                        //get string from the json file
                        String Date = c.getString("Date");
                        String Event = c.getString("Event");


                        // tmp hash map for single event
                        HashMap<String, String> announcements = new HashMap<>();

                        // adding each child node to HashMap key => value
                        announcements.put("Date", Date);
                        announcements.put("Event", Event);


                        // adding contact to announcList
                        announcList.add(announcements);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            } //End If
            else {
                Log.e(TAG, "Couldn't get json objects from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }
            return null;
        } //End doing background

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter (
                Announcement.this, announcList, R.layout.announcement_listview, new String[]{"Date", "Event"}, new int[]{R.id.aDate,
                    R.id.aEvent});
            AnnouncementList.setAdapter(adapter);

        }
    } //End AsyncTask
}
