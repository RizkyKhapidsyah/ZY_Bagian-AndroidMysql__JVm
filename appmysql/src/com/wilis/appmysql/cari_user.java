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
import android.widget.RadioGroup;
import android.widget.TextView;

public class cari_user extends Activity {
   
   EditText un,pw,rpw,nl,al,nt,nh;
   RadioGroup jk;
   TextView error;
   Button cari,keluar;
   
   
    /** Called when the activity is first created. */
   
   @Override
   
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_user);
       
        un=(EditText)findViewById(R.id.et_un);
        pw=(EditText)findViewById(R.id.et_pw);
        rpw=(EditText)findViewById(R.id.et_rpw);
        nl=(EditText) findViewById(R.id.et_nama);
        jk=(RadioGroup) findViewById(R.id.jekel);
        al=(EditText) findViewById(R.id.et_alamat);
        nt=(EditText) findViewById(R.id.et_notel);
        nh=(EditText) findViewById(R.id.et_nohp);
        
        
        cari=(Button)findViewById(R.id.btn_simpan);
        keluar=(Button)findViewById(R.id.btn_keluar);
        error=(TextView)findViewById(R.id.error);
        cari.setOnClickListener(new View.OnClickListener() {
         
         @Override
         
         public void onClick(View v) {
            
            // TODO Auto-generated method stub
        	 
        	
        	 
        	 
        	 
            
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("username", un.getText().toString()));
           
            
/*            String valid = "1";*/      
            
            String response = null;
            
            try {
               
               response = CustomHttpClient.executeHttpPost("http://10.0.2.2/hellomysql/simpan.php", postParameters);
               
               String res = response.toString();
               
               res = res.trim();
               
               res = res.replaceAll("\\s+","");
               
               error.setText(res);
               
               if (res.equals("1")) error.setText("Data Tersimpan");
               
               else error.setText("Data Tersimpan Ke server");
               
            }
            
            catch (Exception e) {
               
               un.setText(e.toString());
               
            }
               
         }
            
            
      });
    }
   
    public void keluar (View theButton)
    {
    	Intent a = new Intent (this,login.class);
    	startActivity(a);
    }
}


