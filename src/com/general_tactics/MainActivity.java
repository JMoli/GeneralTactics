package com.general_tactics;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	
	private GLSurfaceView glSurface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        float dense = getResources().getDisplayMetrics().density;
		// Sets up Window for game display
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//Instantiates OpenGL with GLRender class in global with active context


		glSurface = new MyGLSurface(this, dense);
		
		//Changes active view and starts GlRender thread
		setContentView(glSurface);


		
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		glSurface.onResume();
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		glSurface.onPause();
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

