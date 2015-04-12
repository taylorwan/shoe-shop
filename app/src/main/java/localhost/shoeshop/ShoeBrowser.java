package localhost.shoeshop;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Shoe Browser screen
 */
public class ShoeBrowser extends Activity {

    // shoes & cart
    ArrayList<Shoe> shoes = new ArrayList<Shoe>();
    private int[] cart = { 0, 0, 0, 0, 0, 0 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe_browser);

        try {
            loadShoes();
            populateShoeGrid();

            //set a drag listener for the shopping cart drop zone
            findViewById(R.id.cartButton).setOnDragListener(new DragListener());

        } catch ( Exception e ) {
        }
    }


    /**
     * loadShoes - populates the shoes array
     */
    private void loadShoes() {
        shoes.add( new Shoe( 1, "Chelsea", 8, "Brown", 79, 11, "@drawable/shoe1.jpg", "UPPER 100% COW LEATHER // LINING 100% POLYURETHANE // SOLE 100% VULCANIZED RUBBER" ) );
        shoes.add( new Shoe( 2, "Annie", 7.5, "Light Blue", 69, 11, "@drawable/shoe2.jpg", "UPPER 100% GOAT LEATHER // LINING 100% POLYURETHANE // SOLE 100% VULCANIZED RUBBER" ) );
        shoes.add( new Shoe( 3, "Meredith" , 9, "Brown", 24, 1, "@drawable/shoe3.jpg", "Flat sandals.Straps at heel and instep.Contrast detail. // UPPER 100% COW LEATHER // LINING 100% POLYURETHANE // SOLE 100% VULCANIZED RUBBER" ) );
        shoes.add( new Shoe( 4, "Jenny", 7, "Pink", 79, 10, "@drawable/shoe4.jpg", "Pink embossed high-heeled sandals. Double buckle ankle strap fastening. // UPPER 100% POLYURETHANE // LINING 60% POLYESTER, 40% POLYURETHANE // SOLE 100% THERMOPLASTIC RUBBER" ) );
        shoes.add( new Shoe( 5, "Ayelet", 6.5, "Brown", 59, 13, "@drawable/shoe5.jpg", "Natural colored leather high-heeled sandals with platform.Track sole.Buckle closure on the heel. // UPPER 100% COW LEATHER // LINING 100% POLYURETHANE // SOLE 100% POLYURETHANE THERMOPLASTIC" ) );
        shoes.add( new Shoe( 6, "Selena", 8.5, "Brown", 69, 10, "@drawable/shoe6.jpg", "High-heeled cage sandals.Khaki.Peeptoe.Rear gold-toned zip closure. // UPPER 100% POLYESTER // LINING 80% POLYURETHANE, 20% POLYESTER // SOLE 100% STYRENE BUTADIENE RUBBER" ) );
    }

    /**
     * populateShoeGrid - dynamically populates grid with shoes
     */
    private void populateShoeGrid() {

        // the grid
        GridLayout grid = (GridLayout) findViewById( R.id.shoeGrid );

        // array storing image paths
        int[] imgPath = {
                R.drawable.shoe1, R.drawable.shoe2, R.drawable.shoe3,
                R.drawable.shoe4, R.drawable.shoe5, R.drawable.shoe6
        };

        for ( int i = 0; i < shoes.size(); i++ ) {

            Shoe shoe = shoes.get( i );

            // box container
            LinearLayout box = new LinearLayout( this );

            // detail elements
            ImageView photo = new ImageView( this );
            TextView name = new TextView( this );
            TextView price = new TextView( this );

            // box format
            box.setOrientation( LinearLayout.VERTICAL );
            box.setPadding( 10, 10, 10, 10 );

            // format image
            photo.setLayoutParams( new LinearLayout.LayoutParams( 192, 192 ) );
            photo.setImageResource( imgPath[i] );

            // draggable image
            photo.setOnTouchListener(new TouchListener(i));

            // format texts
            name.setGravity( Gravity.CENTER );
            name.setTypeface( Typeface.DEFAULT_BOLD );
            name.setLayoutParams( new LinearLayout.LayoutParams( GridLayout.LayoutParams.MATCH_PARENT,
                    GridLayout.LayoutParams.WRAP_CONTENT));
            name.setText( shoe.getName() );

            price.setGravity( Gravity.CENTER );
            price.setLayoutParams( new LinearLayout.LayoutParams( GridLayout.LayoutParams.MATCH_PARENT,
                    GridLayout.LayoutParams.WRAP_CONTENT));
            price.setText( Double.toString( shoe.getPrice() ) );

            // add detail elements to box
            box.addView( photo );
            box.addView( name );
            box.addView( price );

            // add box to grid
            grid.addView(box);
        }
    }

    /**
     * viewCart - takes us to Cart, the next activity
     * @param view
     */
    public void viewCart( View view ){

        // create new intent and navigate to the next screen
        Intent intent = new Intent( ShoeBrowser.this, Cart.class );
        intent.putExtra( "inCart", cart );
        startActivity(intent);
    }


    /**
     * TouchListener - class allowing an item to be draggable
     */
    public class TouchListener implements OnTouchListener {

        private int num;    // index of the shoe

        /**
         * TouchListener - explicit constructor
         * @param num - the index of the shoe
         */
        public TouchListener( int num ) {
            this.num = num;
        }

        /**
         * onTouch - copies num to clipboard
         * @param view
         * @param event
         */
        public boolean onTouch(View view, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText(null, Integer.toString( num ) );

                // shadow
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }


    /**
     * DragListener - class to define drop target
     */
    class DragListener implements OnDragListener {

        /**
         * onDrag - specifies actions for each stage of a dragged item
         * @param view
         * @param event
         */
        @Override
        public boolean onDrag( View view, DragEvent event ) {
            int action = event.getAction();

            Button cartBtn = (Button) findViewById( R.id.cartButton );

            switch ( event.getAction() ) {

                // do nothing
                case DragEvent.ACTION_DRAG_STARTED:
                    break;

                // update cartButton accordingly
                case DragEvent.ACTION_DRAG_ENTERED:
                    cartBtn.setBackgroundResource( R.drawable.cart_active );
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                case DragEvent.ACTION_DRAG_ENDED:
                    cartBtn.setBackgroundResource( R.drawable.cart );
                    break;

                // if an item is dropped in cart, increment its value on the array
                case DragEvent.ACTION_DROP:
                    String shoeIndex = (String) event.getClipData().getItemAt(0).getText();
                    int ind = Integer.parseInt(shoeIndex);
                    cart[ ind ]++;

                    Toast f = Toast.makeText(getApplicationContext(), "Successfully added to cart!", Toast.LENGTH_SHORT);
                    f.show();
                    break;

                // do nothing
                default:
                    break;
            }
            return true;
        }
    }


}
