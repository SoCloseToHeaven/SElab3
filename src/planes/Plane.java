package planes;

import characters.Person;
import enums.Action;
import interfaces.Describable;
import interfaces.Movable;
import locations.Location;

import java.util.HashSet;
import java.util.Objects;

abstract public class Plane implements Describable, Movable {
    private Location location;
    private Location flightDestination;
    private boolean inFlight = false;
    private HashSet<Person> passengers = new HashSet<Person>();
    public Plane(Location startLocation) {
        this.location = startLocation;
    }

    public Plane addPassenger(Person passenger) {
        if (passenger.getLocation().equals(this.location)) {
            passengers.add(passenger);
            System.out.println(passenger.getName() + " сел в самолёт");
        } else {
            System.out.println(passenger.getName() + " и самолёт находятся в разных локациях!");
        }
        return this;
    }

    public Plane fly(Location newLocation) {
        if (newLocation.equals(this.location)) {
            System.out.println("Самолёт и так находится в этой локации!");
            return this;
        }
        if (passengers.size() == 0) {
            System.out.println("Самолёт пуст!");
            return this;
        }
        inFlight = true;
        flightDestination = newLocation;
        for (Person iter : passengers)
            iter.setAction(Action.FLYING_IN_PLANE);
        System.out.println("Всё идёт хорошо");
        return this;

    }

    public Plane clearPassengers() {
        if (!inFlight) {
            for (Person iter : passengers) {
                System.out.println(iter.getName() + " высадился из самолёта");
                iter.setAction(Action.DOING_NOTHING).setLocation(this.location);
            }
            passengers = new HashSet<Person>();
        } else {
            System.out.println("Нельзя высадить пассажиров в полёте!");
        }
        return this;
    }

    public Plane land() {
        if (!inFlight) {
            System.out.println("Самолёт не находится в полёте");
            return this;
        }
        inFlight = false;
        return this.setLocation(this.flightDestination).clearPassengers();
    }

    @Override
    public Location getLocation() {return this.location;}

    @Override
    public Plane setLocation(Location newLocation) {
        this.location = newLocation;
        return this;
    }

    @Override
    public String toString() {
        return inFlight + location.toString() + passengers.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, flightDestination, inFlight, passengers);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        if (this.describe().intern() != ((Plane) obj).describe().intern()) return false;
        if (this.getLocation().equals(((Plane) obj).getLocation())) return false;
        return true;
    }
}
