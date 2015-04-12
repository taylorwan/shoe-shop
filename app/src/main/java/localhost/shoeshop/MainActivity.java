//
// Project 3
// Name: Taylor Wan
// E-mail: tw476@georgetown.edu
// Instructor: Singh // COSC 150
//
// In accordance with the class policies and Georgetown's Honor Code,
// I certify that, with the exceptions of the lecture notes and those
// items noted below, I have neither given nor received any assistance
// on this project.
//
// Description: A shoe-buying app
//
// References:
// Android Developer Reference APIs
// http://stackoverflow.com/questions/12128331/how-to-change-fontfamily-of-textview-in-android
// http://stackoverflow.com/questions/11708539/android-error-in-r-java-class
// https://www.youtube.com/watch?v=NyyeDj-JiPc
// http://www.vogella.com/tutorials/AndroidDragAndDrop/article.html
//
// TA Help:
// Kyle
// Victoria
//



package localhost.shoeshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Splash screen
 */
public class MainActivity extends Activity {

    /**
     * onCreate - sets the view, and loads the title font
     * @param savedInstanceState
     */
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);
    }

    /**
     * browseShoes - takes us to ShoeBrowser, the next activity
     * @param view
     */
    public void browseShoes( View view ){

        // create new intent and navigate to the next screen
        Intent intent = new Intent( MainActivity.this, ShoeBrowser.class );
        startActivity( intent );
    }
}
