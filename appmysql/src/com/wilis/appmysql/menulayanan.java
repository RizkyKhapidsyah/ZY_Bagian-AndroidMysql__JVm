package com.wilis.appmysql;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class menulayanan extends ListActivity {

	/** Called when the activity is first created. */

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Create an array of Strings, that will be put to our ListActivity
		String[] menulayanan = new String[] { "Pra Bayar", "Pasca Bayar", "Customer Service", "Help","Exit"};
		
		//Menset nilai array ke dalam list adapater sehingga data pada array akan dimunculkan dalam list
		this.setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,menulayanan));
	}

	@Override
	/**method ini akan mengoveride method onListItemClick yang ada pada class List Activity
	 * method ini akan dipanggil apabilai ada salah satu item dari list menu yang dipilih
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		// Menangkap nilai text yang dklik
		Object o = this.getListAdapter().getItem(position);
		String pilihan = o.toString();
		// Menampilkan hasil pilihan menu dalam bentuk Toast
		tampilkanPilihan(pilihan);
	}
	/**
	 * Tampilkan Activity sesuai dengan menu yang dipilih
	 *
	 */
	protected void tampilkanPilihan(String pilihan) {
		try {
			//Intent digunakan untuk sebagai pengenal suatu activity
			Intent i = null;
			if (pilihan.equals("Pra Bayar")) {
				i = new Intent(this, PraBayar.class);
			} else if (pilihan.equals("Pasca Bayar")) {
				i = new Intent(this, PascaBayar.class);
			} else if (pilihan.equals("Customer Service")) {
				i = new Intent(this, CustomerService.class);
			} else if (pilihan.equals("Help")) {
				i = new Intent(this, Help.class);
			} else if (pilihan.equals("Exit")) {
				finish();
			} else {
				Toast.makeText(this,"Anda Memilih: " + pilihan + " , Actionnya belum dibuat", Toast.LENGTH_LONG).show();
			}
			startActivity(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}