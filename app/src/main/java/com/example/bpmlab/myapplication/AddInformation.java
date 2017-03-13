package com.example.bpmlab.myapplication;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by bpmlab on 2017/3/14.
 */



//public class AddInformation extends AsyncTask<String, String, String> {
//
//    MainActivity main = new MainActivity();
//    String msg = "";
//    String x = main.edtAcceleationX.getText().toString();
//    String y = main.edtAcceleationY.getText().toString();
//    String z = main.edtAcceleationZ.getText().toString();
//    String m = main.edtLongitude.getText().toString();
//    String n = main.edtLatitude.getText().toString();
//
//    protected void onPreExecute(){
//        main.textView.setText("Loading");
//    }
//
//    protected String doInBackground(String... strings){
//
//        try{
//            Connection conn = (Connection) new ConnectDatabase();
//
//            if (conn == null){
//                msg = "not connect";
//            }else{
//                String query = "insert into Userinformation (AccelerationX,AccelerationY,AccelerationZ,Longitude,Latitude) values ('" + x + "','" + y + "','" + z + "','" + m + "','" + n + "')";
//                Statement stmt = conn.createStatement();
//                stmt.executeUpdate(query);
//                msg = "insert success";
//            }
//            conn.close();
//        }
//        catch (Exception e){
//            msg = "not connect2";
//            e.printStackTrace();
//        }
//        return  msg;
//    }
//
//    protected void onPostExecute(String msg){
//        main.textView.setText(msg);
//    }

//}

