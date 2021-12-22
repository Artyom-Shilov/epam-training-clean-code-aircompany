package launch;

import airports.Airport;
import models.MilitaryTypesOfPlanes;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import java.util.Arrays;
import java.util.List;

public class Runner {

    private static Logger logger = Logger.getLogger(Runner.class);

    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Boeing-737").setMaximumSpeed(900)
                    .setMaximumFlightDistance(12000).setMaximumLoadCapacity(60500).setPassengerCapacity(164).build(),
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Boeing-737-800").setMaximumSpeed(940)
                    .setMaximumFlightDistance(12300).setMaximumLoadCapacity(63870).setPassengerCapacity(192).build(),
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Boeing-747").setMaximumSpeed(980)
                    .setMaximumFlightDistance(16100).setMaximumLoadCapacity(70500).setPassengerCapacity(242).build(),
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Airbus A320").setMaximumSpeed(930)
                    .setMaximumFlightDistance(11800).setMaximumLoadCapacity(65500).setPassengerCapacity(188).build(),
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Airbus A330").setMaximumSpeed(990)
                    .setMaximumFlightDistance(14800).setMaximumLoadCapacity(80500).setPassengerCapacity(222).build(),
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Embraer 190").setMaximumSpeed(870)
                    .setMaximumFlightDistance(8100).setMaximumLoadCapacity(30800).setPassengerCapacity(64).build(),
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Sukhoi Superjet 100").setMaximumSpeed(870)
                    .setMaximumFlightDistance(11500).setMaximumLoadCapacity(50500).setPassengerCapacity(140).build(),
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Sukhoi Superjet 100").setMaximumSpeed(870)
                    .setMaximumFlightDistance(11500).setMaximumLoadCapacity(50500).setPassengerCapacity(140).build(),
            new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Bombardier CS300").setMaximumSpeed(920)
                    .setMaximumFlightDistance(11000).setMaximumLoadCapacity(60700).setPassengerCapacity(196).build(),
           new MilitaryPlane.MilitaryPlaneBuilder().setModelOfPlane("B-1B Lancer").setMaximumSpeed(1050)
                   .setMaximumFlightDistance(21000).setMaximumLoadCapacity(80000)
                   .setTypeOfPlane(MilitaryTypesOfPlanes.BOMBER).build(),
            new MilitaryPlane.MilitaryPlaneBuilder().setModelOfPlane("B-2 Spirit").setMaximumSpeed(1030)
                    .setMaximumFlightDistance(22000).setMaximumLoadCapacity(70000)
                    .setTypeOfPlane(MilitaryTypesOfPlanes.BOMBER).build(),
            new MilitaryPlane.MilitaryPlaneBuilder().setModelOfPlane("B-52 Stratofortress").setMaximumSpeed(1000)
                    .setMaximumFlightDistance(20000).setMaximumLoadCapacity(80000)
                    .setTypeOfPlane(MilitaryTypesOfPlanes.BOMBER).build(),
            new MilitaryPlane.MilitaryPlaneBuilder().setModelOfPlane("F-15").setMaximumSpeed(1500)
                    .setMaximumFlightDistance(12000).setMaximumLoadCapacity(10000)
                    .setTypeOfPlane(MilitaryTypesOfPlanes.FIGHTER).build(),
            new MilitaryPlane.MilitaryPlaneBuilder().setModelOfPlane("F-22").setMaximumSpeed(1550)
                    .setMaximumFlightDistance(13000).setMaximumLoadCapacity(11000)
                    .setTypeOfPlane(MilitaryTypesOfPlanes.FIGHTER).build(),
            new MilitaryPlane.MilitaryPlaneBuilder().setModelOfPlane("C-130 Hercules").setMaximumSpeed(650)
                    .setMaximumFlightDistance(5000).setMaximumLoadCapacity(11000)
                    .setTypeOfPlane(MilitaryTypesOfPlanes.TRANSPORT).build()
    );

    public static void main(String[] args) {
        logger.log(Level.INFO, "Start of program");
        Airport airport = new Airport(planes);
        logger.log(Level.INFO, "All planes in airport: " + airport.getPlanes());
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        logger.log(Level.INFO, "Military planes in airport: " + militaryAirport.getPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        logger.log(Level.INFO, "Passenger planes in airport: " + passengerAirport.getPlanes());
        logger.log(Level.INFO,"Military planes sorted by maximum flight distance: " +  militaryAirport
                .sortPlanesByMaximumFlightDistance()
                .toString());
        logger.log(Level.INFO, "Passenger planes sorted by maximum speed: " + passengerAirport
                .sortPlanesByMaximumSpeed()
                .toString());
        logger.log(Level.INFO, "Passenger plane with maximum passenger capacity: "
                + passengerAirport.getPassengerPlaneWithMaximumPassengersCapacity());
    }
}
