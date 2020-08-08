package com.wilis.appmysql;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends Activity {
   
   EditText un,pw;
   TextView error;
   Button login,cancel,daftar;
   String i;
   
   
    /** Called when the activity is first created. */
   
   @Override
   
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
       
        un=(EditText)findViewById(R.id.et_un);
       
        pw=(EditText)findViewById(R.id.et_pw);
       
        login=(Button)findViewById(R.id.btn_login);
       
        error=(TextView)findViewById(R.id.tv_error);
       
        login.setOnClickListener(new View.OnClickListener() {
         
         @Override
         
         public void onClick(View v) {
            
            // TODO Auto-generated method stub
            
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            
            postParameters.add(new BasicNameValuePair("username", un.getText().toString()));
               
            postParameters.add(new BasicNameValuePair("password", pw.getText().toString()));
            
/*            String valid = "1";*/      
            
            String response = null;
            
            try {
               
               response = CustomHttpClient.executeHttpPost("http://10.0.2.2/appmysql/check.php", postParameters);
               
               String res = response.toString();
               
               res = res.trim();
               
               res = res.replaceAll("\\s+","");
               
               error.setText(res);
               
               if (res.equals("1")) 
               {
            	   error.setText("Correct Username or Password");
            	   berhasil(v);
            	   
            	   
            	   
               }
               else { 
            	    error.setText("Sorry!! Wrong Username or Password Entered");
            	    
                    }
            }
            
            catch (Exception e) {
               
               un.setText(e.toString());
               
            }
               
         }
            
            
      });
   }
   
    public void tambah_user (View theButton)
    {
    	// disini menampilkan menu utama atau hal setalah login berhasil
    	// dalam hal ini menu blum ada yg kembali aja ke tambah_user
    	
    	Intent i = new Intent(this,tambah_user.class);
    	startActivity(i);
    	
    	
    }
    
    // apabila user belum terdaftar.
    
    public void berhasil (View theButton)
    {
    	Intent s = new Intent (this, menulayanan.class);
    	startActivity(s);
    }
}

