package shared;

/**
 * You can add anything to this class, but not
 * remove it
 * rename it
 * move it to another package
 * change the public fields place, date, and time in any way
 */
public class PlaceAndMoment {
    public String place;
    public Moment moment;

    public PlaceAndMoment(String place, String date, String time) {
        this.place = place;
        this.moment = new Moment(date, time);
    }
}
