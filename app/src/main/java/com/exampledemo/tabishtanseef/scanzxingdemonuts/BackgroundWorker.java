package com.exampledemo.tabishtanseef.scanzxingdemonuts;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx){
        context = ctx;
    }

    String user_name, password, email;
    private ProgressDialog progressDialog;
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "https://digigoodluck.com/app_login.php";
        String signup_url = "https://digigoodluck.com/app_register.php";
        String insertBook_url = "https://digigoodluck.com/app_insertBook.php";
        String forgotPassword_url = "https://digigoodluck.com/app_forgotPassword.php";

        if(type.equals("login")){
            try {
                user_name = params[1];
                password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1" ));
                String result="0";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("signup")){
            try {
                user_name = params[1];
                password = params[2];
                String email = params[3];
                String num = params[4];
                URL url = new URL(signup_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("num","UTF-8")+"="+URLEncoder.encode(num,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1" ));
                String result="0";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("insertBook")){
            try {
                String id = params[1];
                String bookcode = params[2];
                URL url = new URL(insertBook_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+
                        URLEncoder.encode("book_code","UTF-8")+"="+URLEncoder.encode(bookcode,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1" ));
                String result="0";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("forgotpassword")){
            try {
                email = params[1];
                URL url = new URL(forgotPassword_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1" ));
                String result="0";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("User Status");
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String result) {
        if(result == null)
        {
            // do what you want to do
        }
        else if(result.contains("Done."))
        {
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent homeIntent = new Intent(context, Main2Activity.class);
                    context.startActivity(homeIntent);
                }
            },1000);
        }
        else if(result.contains("Please fill all the fields."))
        {
           /* Intent i = new Intent(context,LoginActivity.class);
            context.startActivity(i);*/
            alertDialog.setMessage("Please fill all the fields.");
            alertDialog.show();
        }
        else if(result.contains("This email id is already registered."))
        {
           /* Intent i = new Intent(context,LoginActivity.class);
            context.startActivity(i);*/
            alertDialog.setMessage("This Email is already registered.");
            alertDialog.show();
        }
        else if(result.contains("This number is already registered."))
        {
            alertDialog.setMessage("This Number is already registered.");
            alertDialog.show();
        }
        else if(result.contains("book inserted"))
        {
           /* Intent i = new Intent(context,LoginActivity.class);
            context.startActivity(i);*/
            Intent homeIntent = new Intent(context, Main2Activity.class);
            context.startActivity(homeIntent);
        }
        else if(result.contains("Registration Successful"))
        {
           /* Intent i = new Intent(context,LoginActivity.class);
            context.startActivity(i);*/
            alertDialog.setMessage("Registration Successful");
            alertDialog.show();
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent homeIntent = new Intent(context, LoginActivity.class);
                    context.startActivity(homeIntent);
                }
            },1000);
        }
        else if(result.contains("login success")) // msg you get from success like "Login Success"
        {
                /*session.setusename(user_name);
                session.setpassword(password);*/
            String user_id =  result.substring(15);
            //using the database of books to get the details of user and the books he had scanned
            SharedPreferences pref = context.getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("user_id", user_id);
            editor.putString("username", user_name);

            editor.commit();
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent homeIntent = new Intent(context, HomeActivity.class);
                    context.startActivity(homeIntent);
                }
            },1000);
        }
        else if(result.contains("login failed")) // msg you get from success like "Login Success"
        {
                /*session.setusename(user_name);
                session.setpassword(password);*/
            alertDialog.setMessage("Your Password is incorrect");
            alertDialog.show();
        }
        else if(result.contains("no account exists")) // msg you get from success like "Login Success"
        {
                /*session.setusename(user_name);
                session.setpassword(password);*/
            alertDialog.setMessage("No Such User Exist");
            alertDialog.show();
        }
        else if(result.contains("mail sent")) // msg you get from success like "Login Success"
        {
                /*session.setusename(user_name);
                session.setpassword(password);*/
            alertDialog.setMessage("Please check your email we have sent your password.");
            alertDialog.show();
        }
        else if(result.contains("mail not sent")) // msg you get from success like "Login Success"
        {
                /*session.setusename(user_name);
                session.setpassword(password);*/
            alertDialog.setMessage("Please try again.");
            alertDialog.show();
        }
        //progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}