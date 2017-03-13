package com.example.bpmlab.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    EditText edtAcceleationX, edtAcceleationY, edtAcceleationZ, edtLongitude, edtLatitude;
    Button btnInsert;
    TextView textView;
    ConnectDatabase connectDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAcceleationX = (EditText) findViewById(R.id.edtAcceleationX);
        edtAcceleationY = (EditText) findViewById(R.id.edtAcceleationY);
        edtAcceleationZ = (EditText) findViewById(R.id.edtAcceleationZ);
        edtLongitude = (EditText) findViewById(R.id.edtLongitude);
        edtLatitude = (EditText) findViewById(R.id.edtLatitude);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        textView = (TextView)findViewById(R.id.textView);
        connectDatabase = new ConnectDatabase();

        btnInsert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AddInformation objSend = new AddInformation();
                objSend.execute("");
                edtAcceleationY.setText("");
            }
        });
    }

    public class AddInformation extends AsyncTask<String, String, String> {


        String msg = "";
        String x = edtAcceleationX.getText().toString();
        String y = edtAcceleationY.getText().toString();
        String z = edtAcceleationZ.getText().toString();
        String m = edtLongitude.getText().toString();
        String n = edtLatitude.getText().toString();

        protected void onPreExecute() {
            textView.setText("Loading");
        }

        protected String doInBackground(String... strings) {

            try {
                Connection conn = connectDatabase.CONN();
                if (conn == null) {
                    msg = "not connect";
                } else {
                    String query = "insert into Userinformation (AccelerationX,AccelerationY,AccelerationZ,Longitude,Latitude) values ('" + x + "','" + y + "','" + z + "','" + m + "','" + n + "')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "insert success";
                }
                conn.close();
            } catch (Exception e) {
                msg = "not connect2";
                e.printStackTrace();
            }
            return msg;
        }

        protected void onPostExecute(String msg) {
            textView.setText(msg);
        }
    }
}
