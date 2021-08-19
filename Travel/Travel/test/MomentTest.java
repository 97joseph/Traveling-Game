import org.junit.jupiter.api.Test;
import shared.Moment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is completely optional.
 * You can ignore it.
 * You can extend it to write your own tests.
 * Or you can delete it.
 * Completely up to you.
 */
public class MomentTest {
    @Test
    void addNothing() {
        Moment m = Moment.getMomentAfter("01/09/2021", "08:00", "0:00");
        assertNotNull(m);
        assertEquals("01/09/2021", m.date);
        assertEquals("08:00", m.time);
    }

    @Test
    void add1Minute() {
        Moment m = Moment.getMomentAfter("01/09/2021", "08:00", "0:01");
        assertNotNull(m);
        assertEquals("01/09/2021", m.date);
        assertEquals("08:01", m.time);
    }

    @Test
    void add1Hour() {
        Moment m = Moment.getMomentAfter("01/09/2021", "08:00", "1:00");
        assertNotNull(m);
        assertEquals("01/09/2021", m.date);
        assertEquals("09:00", m.time);
    }

    @Test
    void add1Hour30Minutes() {
        Moment m = Moment.getMomentAfter("01/09/2021", "08:00", "1:30");
        assertNotNull(m);
        assertEquals("01/09/2021", m.date);
        assertEquals("09:30", m.time);
    }

    @Test
    void add1Day() {
        Moment m = Moment.getMomentAfter("01/09/2021", "08:00", "24:00");
        assertNotNull(m);
        assertEquals("02/09/2021", m.date);
        assertEquals("08:00", m.time);
    }

    @Test
    void add1Month() {
        Moment m = Moment.getMomentAfter("01/09/2021", "08:00", "744:20");
        assertNotNull(m);
        assertEquals("02/10/2021", m.date);
        assertEquals("08:20", m.time);
    }
}
