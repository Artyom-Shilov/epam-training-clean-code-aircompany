package planes;

public class MaquettePlane extends Plane {

    public MaquettePlane(MaquettePlaneBuilder maquettePlaneBuilder) {
        super(maquettePlaneBuilder);
    }

    public static class MaquettePlaneBuilder extends PlaneBuilder<MaquettePlaneBuilder> {
        @Override
        public MaquettePlaneBuilder getSelf() {
            return this;
        }

        @Override
        public MaquettePlane build() {
            return new MaquettePlane(this);
        }
    }
}
