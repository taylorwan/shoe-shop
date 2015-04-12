
package localhost.shoeshop;

/**
 * Object representation of a shoe
 */
public class Shoe {

    // variables
    private int id;           // shoe's id
    private String name;      // shoe's name
    private double size;      // shoe's size
    private String color;     // shoe's color
    private double price;     // shoe's price
    private double height;    // shoe's height (heel)
    private String image;     // path to shoe's image
    private String details;   // shoe's details

    /**
     * Default constructor
     */
    public Shoe() {}

    /**
     * Parametrized constructor
     *
     * @param id - shoe's id
     * @param name - shoe's name
     * @param size - shoe's size
     * @param color - shoe's color
     * @param price - shoe's price
     * @param height - shoe's height (heel)
     * @param image - path to the shoe's image
     * @param details - shoe's details
     */
    public Shoe( int id, String name, double size, String color, double price, double height, String image, String details ) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.height = height;
        this.image = image;
        this.details = details;
    }

    /** getID - returns private member id
     * @return - id
     */
    public int getID() { return id; }

    /** setID - sets private member id
     * @param id
     */
    public void setID( int id ) { this.id = id; }

    /** getName - returns private member name
     * @return - name
     */
    public String getName() { return name; }

    /** setName - sets private member name
     * @param name
     */
    public void setName( String name ) { this.name = name; }

    /** getSize - returns private member size
     * @return - size
     */
    public double getSize() { return size; }

    /** setSize - sets private member size
     * @param size
     */
    public void setSize( double size ) { this.size = size; }

    /** getColor - returns private member color
     * @return - color
     */
    public String getColor() { return color; }

    /** setColor - sets private member color
     * @param color
     */
    public void setColor( String color ) { this.color = color; }

    /** getPrice - returns private member price
     * @return - price
     */
    public double getPrice() { return price; }

    /** setPrice - sets private member price
     * @param price
     */
    public void setPrice( double price ) { this.price = price; }

    /** getHeight - returns private member height
     * @return - height
     */
    public double getHeight() { return height; }

    /** setHeight - sets private member height
     * @param height
     */
    public void setHeight( double height ) { this.height = height; }

    /** getImage - returns private member image
     * @return - image
     */
    public String getImage() { return image; }

    /** setImage - sets private member image
     * @param image
     */
    public void setImage( String image ) { this.image = image; }

    /** getDetails - returns private member details
     * @return - details
     */
    public String getDetails() { return details; }

    /** setDetails - sets private member details
     * @param details
     */
    public void setDetails( String details ) { this.details = details; }

}
