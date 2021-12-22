package planes;

import java.util.Objects;

public abstract class Plane {

    private String modelOfPlane;
    private int maximumSpeed;
    private int maximumFlightDistance;
    private int maximumLoadCapacity;

    public Plane(PlaneBuilder<?> builder) {
        this.modelOfPlane = builder.modelOfPlane;
        this.maximumSpeed = builder.maximumSpeed;
        this.maximumFlightDistance = builder.maximumFlightDistance;
        this.maximumLoadCapacity = builder.maximumLoadCapacity;
    }

    public String getModelOfPlane() {
        return modelOfPlane;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public int getMaximumFlightDistance() {
        return maximumFlightDistance;
    }

    public int getMaximumLoadCapacity() {
        return maximumLoadCapacity;
    }

    public abstract static class PlaneBuilder<T extends PlaneBuilder> {

        private String modelOfPlane;
        private int maximumSpeed;
        private int maximumFlightDistance;
        private int maximumLoadCapacity;

        public abstract T getSelf();

        public T setModelOfPlane(String modelOfPlane) {
            this.modelOfPlane = modelOfPlane;
            return getSelf();
        }

        public T setMaximumSpeed(int maximumSpeed) {
            this.maximumSpeed = maximumSpeed;
            return getSelf();
        }

        public T setMaximumFlightDistance(int maximumFlightDistance) {
            this.maximumFlightDistance = maximumFlightDistance;
            return getSelf();
        }

        public T setMaximumLoadCapacity(int maximumLoadCapacity) {
            this.maximumLoadCapacity = maximumLoadCapacity;
            return getSelf();
        }

        public abstract Plane build();

    }

    @Override
    public String toString() {
        return "Plane{" +
                "modelOfPlane='" + modelOfPlane + '\'' +
                ", maximumSpeed=" + maximumSpeed +
                ", maximumFlightDistance=" + maximumFlightDistance +
                ", maximumLoadCapacity=" + maximumLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return maximumSpeed == plane.maximumSpeed
                && maximumFlightDistance == plane.maximumFlightDistance
                && maximumLoadCapacity == plane.maximumLoadCapacity
                && Objects.equals(modelOfPlane, plane.modelOfPlane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelOfPlane, maximumSpeed, maximumFlightDistance, maximumLoadCapacity);
    }
}
