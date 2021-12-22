package planes;

import models.SecrecyLevelsOfPlanes;
import models.ExperimentalTypesOfPlanes;

public class ExperimentalPlane extends Plane {

    private final ExperimentalTypesOfPlanes typeOfPlane;
    private SecrecyLevelsOfPlanes secrecyLevel;

    public ExperimentalPlane(ExperimentalPlaneBuilder builder) {
        super(builder);
        this.typeOfPlane = builder.typeOfPlane;
        this.secrecyLevel = builder.secrecyLevel;
    }

    public SecrecyLevelsOfPlanes getSecrecyLevel() {
        return secrecyLevel;
    }

    public void setSecrecyLevel(SecrecyLevelsOfPlanes secrecyLevel) {
        this.secrecyLevel = secrecyLevel;
    }

    public static class ExperimentalPlaneBuilder extends PlaneBuilder<ExperimentalPlaneBuilder> {

        private SecrecyLevelsOfPlanes secrecyLevel;
        private ExperimentalTypesOfPlanes typeOfPlane;

        @Override
        public ExperimentalPlaneBuilder getSelf() {
            return this;
        }

        public ExperimentalPlaneBuilder setSecrecyLevel(SecrecyLevelsOfPlanes secrecyLevel) {
            this.secrecyLevel = secrecyLevel;
            return getSelf();
        }

        public ExperimentalPlaneBuilder setTypeOfPlane(ExperimentalTypesOfPlanes typeOfPlane) {
            this.typeOfPlane = typeOfPlane;
            return getSelf();
        }

        @Override
        public ExperimentalPlane build() {
            return new ExperimentalPlane(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "modelOfPlane='" + getModelOfPlane() + '\'' +
                ", typeOfPlane='" + typeOfPlane + '\'' +
                '}';
    }
}
