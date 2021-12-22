package planes;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private int passengersCapacity;

    public PassengerPlane(PassengerPlaneBuilder passengerPlaneBuilder) {
        super(passengerPlaneBuilder);
        this.passengersCapacity = passengerPlaneBuilder.passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public static class PassengerPlaneBuilder extends Plane.PlaneBuilder<PassengerPlaneBuilder> {

        private int passengersCapacity;

        @Override
        public PassengerPlaneBuilder getSelf() {
            return this;
        }

        public PassengerPlaneBuilder setPassengerCapacity(int passengerCapacity) {
            this.passengersCapacity = passengerCapacity;
            return getSelf();
        }

        @Override
        public PassengerPlane build() {
            return new PassengerPlane(this);
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
