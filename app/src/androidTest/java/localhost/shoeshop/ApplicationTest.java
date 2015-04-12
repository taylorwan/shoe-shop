package localhost.shoeshop;

import android.app.Application;
import android.content.Intent;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

/**
 * test classes for ShoeShop
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @MediumTest
    public void testMainActivity() {

        MainActivity main = new MainActivity();
        final Intent launch = new Intent( main, MainActivity.class );
        main.startActivity( launch );

        final Button next = (Button) main.findViewById(R.id.browseButton);
        next.performClick();


        assertNotNull("Intent was null", launch);
    }

    @MediumTest
    public void testBrowserActivity() {

        ShoeBrowser browser = new ShoeBrowser();
        final Intent launch = new Intent( browser, ShoeBrowser.class );
        browser.startActivity( launch );

        final Button next = (Button) browser.findViewById(R.id.cartButton);
        next.performClick();


        assertNotNull("Intent was null", launch);
    }

    @MediumTest
    public void testCartActivity() {

        Cart cart = new Cart();
        final Intent launch = new Intent( cart, Cart.class );
        cart.startActivity( launch );

        final Button next = (Button) cart.findViewById(R.id.doneButton);
        next.performClick();


        assertNotNull("Intent was null", launch);
    }
}