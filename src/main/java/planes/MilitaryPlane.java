package planes;

import models.MilitaryTypesOfPlanes;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryTypesOfPlanes typeOfPlane;

    public MilitaryPlane(MilitaryPlaneBuilder militaryPlaneBuilder) {
        super(militaryPlaneBuilder);
        this.typeOfPlane = militaryPlaneBuilder.typeOfPlane;
    }

    public MilitaryTypesOfPlanes getTypeOfPlane() {
        return typeOfPlane;
    }

    public static class MilitaryPlaneBuilder extends PlaneBuilder<MilitaryPlaneBuilder> {

        private MilitaryTypesOfPlanes typeOfPlane;

        @Override
        public MilitaryPlaneBuilder getSelf() {
            return this;
        }

        public MilitaryPlaneBuilder setTypeOfPlane(MilitaryTypesOfPlanes typeOfPlane) {
            this.typeOfPlane = typeOfPlane;
            return getSelf();
        }

        @Override
        public MilitaryPlane build() {
            return new MilitaryPlane(this);
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", type=" + typeOfPlane + '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return typeOfPlane == that.typeOfPlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfPlane);
    }
}
