package com.wilis.appmysql;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;

public class PascaBayar extends Activity {
	
	/**
	 * Method yang dipanggil pada saat applikaasi dijalankan
	 * */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.pascabayar);
		
	}

	/**
	 * Method untuk menutup activity dan kembali ke menu
	 * @param view
	 */
	public void backtoMenu(View view){
		finish();
	}
}