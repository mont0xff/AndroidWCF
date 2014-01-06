package com.example.bloodravens;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private static final String METHOD_NAME = "KupaFunc";
	private static final String NAMESPACE = "http://tempuri.org/";
	private static final String URL = "http://localhost:58706/Service1.svc?wsdl";
	final String SOAP_ACTION = "http://tempuri.org/KupaFunc";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 try {

		        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		        request.addProperty("Name", "Qing");

	            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	            envelope.dotNet = true;
	            envelope.setOutputSoapObject(request);


	            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	            Log.d("FF", "androidHttpTransport = new HttpTransportSE(URL); - ok ");
	            	
	            androidHttpTransport.call(SOAP_ACTION, envelope);
	            Log.d("FF", "androidHttpTransport.call(SOAP_ACTION, envelope); - ok");
	            	
	            
	            /*
	            SoapPrimitive result = (SoapPrimitive)envelope.getResponse();

	            //to get the data
	            String resultData = result.toString();*/
	            // 0 is the first object of data 
	            //Log.d("FF", "resultData: " + resultData);
		        Log.d("FF", "ok");
		 }
		 catch (Exception e) {
			 Log.d("FF", "Exception:");
			 Log.d("FF", e.getMessage().toString());
	      }
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
