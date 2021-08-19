package data;

import app.Journey;
import shared.PlaceAndMoment;
import transport.*;

import java.util.List;

/**
 * You can add anything to this class, but not
 * remove it
 * rename it
 * move it to another package
 * modify the TEST_DATA or TEST_OUTPUT fields (unless temporarily for testing)
 */
public class TransportData {
    public static Object[][] TEST_DATA_BASIC = {
            { "plane", "Glasgow", "01/09/2021", "18:05", "London", "01/09/2021", "19:35", 27.0, 604 },
            { "bus", "Glasgow", "01/09/2021", "16:00", "Edinburgh", "01/09/2021", "17:15", 8.5, 74 },
            { "train", "Edinburgh", "01/09/2021", "17:30", "London", "01/09/2021", "22:09", 60.5, 633 },
    };

    public static String[] TEST_OUTPUT_BASIC = {
            "01/09/2021: plane from Glasgow (18:05) to London (19:35), 27.00GBP, 194.1328kg CO2",
            "01/09/2021: bus from Glasgow (16:00) to Edinburgh (17:15), 8.50GBP, 5.0039kg CO2",
            "01/09/2021: train from Edinburgh (17:30) to London (22:09), 60.50GBP, 55.9320kg CO2",
    };

    public static Object[][] TEST_DATA_INTERMEDIATE = {
            { "walk", "Glasgow", "London", "139:00", 673 },
            { "taxi", "Glasgow", "Edinburgh", "1:20", 62.0, 74 },
            { "walk", "St. Andrews", "Edinburgh", "17:03", 82 },
            { "taxi", "Glasgow", "Oban", "2:15", 136.7, 159 },
            { "train", "Edinburgh", "01/09/2021", "18:52", "London", "02/09/2021", "01:13", 33.9, 633 },
    };

    public static String[] TEST_OUTPUT_INTERMEDIATE = {
            "flexible (139:00): walk from Glasgow to London, 0.00GBP, 0.0000kg CO2",
            "flexible (1:20): taxi from Glasgow to Edinburgh, 62.00GBP, 9.6630kg CO2",
            "flexible (17:03): walk from St. Andrews to Edinburgh, 0.00GBP, 0.0000kg CO2",
            "flexible (2:15): taxi from Glasgow to Oban, 136.70GBP, 20.7624kg CO2",
            "01/09/2021-02/09/2021: train from Edinburgh (18:52) to London (01:13), 33.90GBP, 55.9320kg CO2"
    };

    public static Journey[] TEST_DATA_ADVANCED = {
            new Journey(List.of(
                    new Plane(
                            new PlaceAndMoment("Edinburgh", "03/09/2021", "19:15"),
                            new PlaceAndMoment("Southampton", "03/09/2021", "20:50"),
                            581, 68.0
                    )
            )),
            new Journey(List.of(
                    new Train(
                            new PlaceAndMoment("Edinburgh", "02/09/2021", "06:48"),
                            new PlaceAndMoment("Stirling", "02/09/2021", "07:30"),
                            59, 8.8
                    ),
                    new Train(
                            new PlaceAndMoment("Stirling", "02/09/2021", "07:36"),
                            new PlaceAndMoment("Aviemore", "02/09/2021", "09:48"),
                            187, 8.8
                    )
            )),
            new Journey(List.of(
                    new Train(
                            new PlaceAndMoment("Edinburgh", "02/09/2021", "08:35"),
                            new PlaceAndMoment("Aviemore", "02/09/2021", "11:30"),
                            227,45.60
                    )
            )),
            new Journey(List.of(
                    new Bus(
                            new PlaceAndMoment("Edinburgh", "02/09/2021", "08:00"),
                            new PlaceAndMoment("Aviemore", "02/09/2021", "11:05"),
                            143, 22
                    )
            )),
            new Journey(List.of(
                    new Bus(
                            new PlaceAndMoment("Perth", "02/09/2021", "09:10"),
                            new PlaceAndMoment("Aviemore", "02/09/2021", "11:05"),
                            93, 5
                    ),
                    new Walk(
                            new PlaceAndMoment("Edinburgh", "02/09/2021", "05:00"),
                            new PlaceAndMoment("Dalmeny", "02/09/2021", "08:02"),
                            15, "3:02"),
                    new Taxi(
                            new PlaceAndMoment("Dalmeny", "02/09/2021", "08:05"),
                            new PlaceAndMoment("Perth", "02/09/2021", "09:00"),
                            57, 70.40, "0:55")
            )),
            new Journey(List.of(
                    new Walk(
                            new PlaceAndMoment("Appleton Tower", "01/09/2021", "04:00"),
                            new PlaceAndMoment("Arthur's Seat", "01/09/2021", "04:33"),
                            2, "0:33"
                    )
            ))
    };

    public static String[] TEST_OUTPUT_ADVANCED = {
            "03/09/2021: plane from Edinburgh (19:15) to Southampton (20:50), with 0 changes and 0km walking, 68.00GBP, 186.7403kg CO2",
            "02/09/2021: train, train from Edinburgh (06:48) to Aviemore (09:48), with 1 changes and 0km walking, 17.60GBP, 21.7366kg CO2",
            "02/09/2021: train from Edinburgh (08:35) to Aviemore (11:30), with 0 changes and 0km walking, 45.60GBP, 20.0577kg CO2",
            "02/09/2021: bus from Edinburgh (08:00) to Aviemore (11:05), with 0 changes and 0km walking, 22.00GBP, 9.6697kg CO2",
            "02/09/2021: walk, taxi, bus from Edinburgh (05:00) to Aviemore (11:05), with 1 changes and 15km walking, 75.40GBP, 13.7318kg CO2",
            "01/09/2021: walk from Appleton Tower (04:00) to Arthur's Seat (04:33), with 0 changes and 2km walking, 0.00GBP, 0.0000kg CO2"
    };
}
