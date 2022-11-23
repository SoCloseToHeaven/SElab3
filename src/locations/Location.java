package locations;

import interfaces.Describable;

import java.util.Arrays;
import java.util.Objects;

abstract public class Location implements Describable {
    private double longtitude;
    private double width;

    private final String description;

    public Location(double longtitude, double width, String description) {
        this.longtitude = longtitude;
        this.width = width;
        this.description = description + ", расположенный по координатам: " + Arrays.toString(this.getCoordinates());

    }
    @Override
    public String describe() { return description; }
    public double[] getCoordinates() {
        return new double[]{this.longtitude, this.width};
    }

    @Override
    public boolean equals(Object location) {
        if (location == null)
            return false;
        if (this.getClass() == location.getClass())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longtitude, width);
    }
}
