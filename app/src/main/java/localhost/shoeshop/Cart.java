package localhost.shoeshop;

import android.content.Intent;
import android.graphics.Typeface;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Check out screen
 */
public class Cart extends Activity {

    ArrayList<Shoe> shoes = new ArrayList<Shoe>();
    int[] quantities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        quantities = intent.getIntArrayExtra( "inCart" );

        try {
            loadShoes();
            generateCart();
        } catch ( Exception e ) {
        }
    }


    /**
     * loadShoes - populates the shoes array
     */
    public boolean loadShoes() {

        shoes.add( new Shoe( 1, "Chelsea" , 8, "Brown", 79, 11, "@drawable/shoe1.jpg", "UPPER 100% COW LEATHER // LINING 100% POLYURETHANE // SOLE 100% VULCANIZED RUBBER" ) );
        shoes.add( new Shoe( 2, "Annie" , 7.5, "Light Blue", 69, 11, "@drawable/shoe2.jpg", "UPPER 100% GOAT LEATHER // LINING 100% POLYURETHANE // SOLE 100% VULCANIZED RUBBER" ) );
        shoes.add( new Shoe( 3, "Meredith" , 9, "Brown", 24, 1, "@drawable/shoe3.jpg", "Flat sandals.Straps at heel and instep.Contrast detail. // UPPER 100% COW LEATHER // LINING 100% POLYURETHANE // SOLE 100% VULCANIZED RUBBER" ) );
        shoes.add( new Shoe( 4, "Jenny" , 7, "Pink", 79, 10, "@drawable/shoe4.jpg", "Pink embossed high-heeled sandals. Double buckle ankle strap fastening. // UPPER 100% POLYURETHANE // LINING 60% POLYESTER, 40% POLYURETHANE // SOLE 100% THERMOPLASTIC RUBBER" ) );
        shoes.add( new Shoe( 5, "Ayelet" , 6.5, "Brown", 59, 13, "@drawable/shoe5.jpg", "Natural colored leather high-heeled sandals with platform.Track sole.Buckle closure on the heel. // UPPER 100% COW LEATHER // LINING 100% POLYURETHANE // SOLE 100% POLYURETHANE THERMOPLASTIC" ) );
        shoes.add( new Shoe( 6, "Selena", 8.5, "Brown", 69, 10, "@drawable/shoe6.jpg", "High-heeled cage sandals.Khaki.Peeptoe.Rear gold-toned zip closure. // UPPER 100% POLYESTER // LINING 80% POLYURETHANE, 20% POLYESTER // SOLE 100% STYRENE BUTADIENE RUBBER" ) );

        return true;
    }

    /**
     * generateCart - dynamically populates cartLayout
     */
    private void generateCart() {

        int totalItems = 0;
        double total = 0;

        LinearLayout cart = ( LinearLayout ) findViewById( R.id.cartLayout );
        cart.setOrientation( LinearLayout.VERTICAL );
        cart.setPadding( 16, 16, 16, 16  );

        TextView title = new TextView( this );
        title.setText( "Your Cart" );
        title.setTypeface( Typeface.DEFAULT_BOLD );
        title.setTextSize( 20 );
        cart.addView( title );


        for ( int i = 0; i < quantities.length; i++ ) {

            if ( quantities[i] > 0 ) {
                Shoe shoe = shoes.get(i);

                // shoe name
                TextView nameText = new TextView( this );
                nameText.setText( shoe.getName() );
                nameText.setTypeface( Typeface.DEFAULT_BOLD );
                nameText.setPadding( 0, 20, 0, 0 );
                cart.addView( nameText );

                // shoe price + qty
                int qty = quantities[i];
                double price = shoe.getPrice() * qty;
                TextView priceQty = new TextView( this );
                priceQty.setText( "Price: " + Double.toString( price ) + ", Quantity: " + qty );
                cart.addView( priceQty );

                // add price & qty of shoe to totals
                total += price;
                totalItems += qty;
            }

        }
        if ( totalItems > 0 ) {

            // total quantity
            TextView qtyText = new TextView( this );
            qtyText.setText( "Total Items: " + Integer.toString( totalItems ) );
            qtyText.setTypeface( Typeface.DEFAULT_BOLD );
            qtyText.setPadding( 0, 20, 0, 0 );
            cart.addView( qtyText );

            // total price
            TextView totalText = new TextView( this );
            totalText.setText( "Total Price: " + Double.toString( total ) );
            totalText.setTypeface( Typeface.DEFAULT_BOLD );
            cart.addView( totalText );

        } else {
            TextView empty = new TextView( this );
            empty.setText( "Cart Empty!" );
            cart.addView( empty );
        }

    }

    /**
     * browseShoes - takes us to ShoeBrowser, the previous activity
     * @param view
     */
    public void browseShoes( View view ){

        // create new intent and navigate to the next screen
        Intent intent = new Intent( Cart.this, ShoeBrowser.class );
        startActivity( intent );
    }

    /**
     * storeMap - takes us to Map, the next activity
     * @param view
     */
    public void storeMap( View view ){

        WebView map = new WebView( this );
        setContentView( map );
        map.loadUrl("https://www.google.com/maps/place/Georgetown+University");
    }

}
