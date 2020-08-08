package com.wilis.appmysql;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Help extends Activity
{
	@Override
	public void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		
		TextView h=(TextView) findViewById(R.id.help);
		h.setText ("ANDA MILIH MENU HELP");
		
	}
	
}