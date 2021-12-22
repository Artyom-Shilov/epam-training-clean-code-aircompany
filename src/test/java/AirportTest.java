import airports.Airport;
import org.testng.annotations.BeforeSuite;
import planes.*;
import models.SecrecyLevelsOfPlanes;
import models.ExperimentalTypesOfPlanes;
import models.MilitaryTypesOfPlanes;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class AirportTest {

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
                    .setTypeOfPlane(MilitaryTypesOfPlanes.TRANSPORT).build(),
            new ExperimentalPlane.ExperimentalPlaneBuilder().setModelOfPlane("Bell X-14").setMaximumSpeed(277)
                    .setMaximumFlightDistance(482).setMaximumLoadCapacity(500)
                    .setTypeOfPlane(ExperimentalTypesOfPlanes.HIGH_ALTITUDE)
                    .setSecrecyLevel(SecrecyLevelsOfPlanes.SECRET).build(),
            new ExperimentalPlane.ExperimentalPlaneBuilder().setModelOfPlane("Ryan X-13 Vertijet").setMaximumSpeed(560)
                    .setMaximumFlightDistance(307).setMaximumLoadCapacity(500)
                    .setTypeOfPlane(ExperimentalTypesOfPlanes.VTOL)
                    .setSecrecyLevel(SecrecyLevelsOfPlanes.TOP_SECRET).build()
    );

    Airport airport;

    @BeforeSuite
    public void setUp() {
        airport = new Airport(planes);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        Assert.assertEquals(1, transportMilitaryPlanes.size());
        Assert.assertEquals(MilitaryTypesOfPlanes.TRANSPORT, transportMilitaryPlanes.get(0).getTypeOfPlane());
    }

    @Test
    public void testGetPassengerPlaneWithMaximumCapacity() {
        Assert.assertEquals(new PassengerPlane.PassengerPlaneBuilder().setModelOfPlane("Boeing-747")
                        .setMaximumSpeed(980).setMaximumFlightDistance(16100).setMaximumLoadCapacity(70500)
                        .setPassengerCapacity(242).build()
                , airport.getPassengerPlaneWithMaximumPassengersCapacity());
    }

    @Test
    public void testSortPlanesByMaximumLoadCapacity() {
        List<Plane> maquettePlanesForLoadCapacitySort = Arrays.asList(
                new MaquettePlane.MaquettePlaneBuilder().setMaximumLoadCapacity(10).build(),
                new MaquettePlane.MaquettePlaneBuilder().setMaximumLoadCapacity(4).build(),
                new MaquettePlane.MaquettePlaneBuilder().setMaximumLoadCapacity(500).build(),
                new MaquettePlane.MaquettePlaneBuilder().setMaximumLoadCapacity(1).build()
        );
        List<Plane> maquettePlanesForLoadCapacitySortInSortedOrder = Arrays.asList(
                new MaquettePlane.MaquettePlaneBuilder().setMaximumLoadCapacity(1).build(),
                new MaquettePlane.MaquettePlaneBuilder().setMaximumLoadCapacity(4).build(),
                new MaquettePlane.MaquettePlaneBuilder().setMaximumLoadCapacity(10).build(),
                new MaquettePlane.MaquettePlaneBuilder().setMaximumLoadCapacity(500).build()
        );
        Assert.assertEquals(maquettePlanesForLoadCapacitySortInSortedOrder,
                new Airport(maquettePlanesForLoadCapacitySort).sortPlanesByMaximumLoadCapacity().getPlanes());
    }

    @Test
    public void testGetBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertEquals(3, bomberMilitaryPlanes.size());
        Assert.assertEquals(MilitaryTypesOfPlanes.BOMBER, bomberMilitaryPlanes.get(0).getTypeOfPlane());
        Assert.assertEquals(MilitaryTypesOfPlanes.BOMBER, bomberMilitaryPlanes.get(1).getTypeOfPlane());
        Assert.assertEquals(MilitaryTypesOfPlanes.BOMBER, bomberMilitaryPlanes.get(2).getTypeOfPlane());
    }

    @Test
    public void testGetExperimentalPlanes() {
        Assert.assertEquals(2, airport.getExperimentalPlanes().size());
    }
}
