package cmu.edu.haoranc.movietab;


import cmu.edu.haoranc.movietab.fragment.MovieFragment;
import cmu.edu.haoranc.movietab.liked.LikedContainer;
import cmu.edu.haoranc.movietab.message.MessageContainer;
import cmu.edu.haoranc.movietab.movie.MovieContainer;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Movie", "Liked", "Messages" };
    
    
    private android.app.Fragment movieFragment;
    private android.app.Fragment likedFragment;
    private android.app.Fragment messageFragment;
    
    private android.app.Fragment likedContainer;
    private android.app.Fragment messageContainer;
    private android.app.Fragment movieContainer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
			
//	        actionBar = getActionBar();
	        
//	 
	        
//	        actionBar.setHomeButtonEnabled(true);
//	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
//	 
//	        // Adding Tabs
//	        for (String tab_name : tabs) {
//	            actionBar.addTab(actionBar.newTab().setText(tab_name)
//	                    .setTabListener(this));
//	        }
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		

        // create new tabs and set up the titles of the tabs
        ActionBar.Tab movieTab = actionBar.newTab().setText(tabs[0]);
        ActionBar.Tab likedTab = actionBar.newTab().setText(tabs[1]);
        ActionBar.Tab messageTab = actionBar.newTab().setText(tabs[2]);
        
        //movieFragment = new MovieFragment();
        likedContainer = new LikedContainer();
//        messageFragment = new MessageFragment();
        messageContainer = new MessageContainer();
        movieContainer = new MovieContainer();
        
        movieTab.setTabListener(this);
        likedTab.setTabListener(this);
        messageTab.setTabListener(this);
        
        actionBar.addTab(movieTab);
        actionBar.addTab(likedTab);
        actionBar.addTab(messageTab);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction ft) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		toastText("tab " + String.valueOf(tab.getPosition()) + " clicked");
		switch (tab.getPosition()) {
		case 0: ft.replace(R.id.fragment_container, movieContainer); break;
		case 1: ft.replace(R.id.fragment_container, likedContainer); break;
		case 2: ft.replace(R.id.fragment_container, messageContainer); break;
		}
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		switch (tab.getPosition()) {
		case 0: ft.remove(movieContainer); break;
		case 1: ft.remove(likedContainer); break;
		case 2: ft.remove(messageContainer); break;
		}
		
	}
	
	private void toastText(String message){
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}
}
