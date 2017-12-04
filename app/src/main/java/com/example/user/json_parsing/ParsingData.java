package com.example.user.json_parsing;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.user.json_parsing.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.user.json_parsing.MainActivity.show;


/**
 * Created by User on 12/1/2017.
 */

public class ParsingData extends AsyncTask<Void, Void, Void> {

    String data="";
    String single="";
    String total="";
    Context context;

    public ParsingData(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        String str ="https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=943b374a7d8842f39f17e227947c5537";

        try {

            URL url =new URL(str);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";

            while (line!=null){
                line=bufferedReader.readLine();
                data+=line;

            }

            JSONObject object =new JSONObject(data);

           JSONArray jsonArray = object.getJSONArray("articles");

            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject= (JSONObject) jsonArray.get(i);
               // JSONObject o=jsonObject.getJSONObject("source");

                single="Author:"+ jsonObject.getString("author")+"\n\n"
                        +"Title :"+jsonObject.getString("title")+"\n\n"
                        +"Description :"+jsonObject.getString("description")+"\n\n"+
                        "Published At :"+jsonObject.getString("publishedAt")+"\n\n"+
                        "\n\n\n";

                total+=single;

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;



    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
       // show.setText(total);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(total);
        builder.show();

    }
}
