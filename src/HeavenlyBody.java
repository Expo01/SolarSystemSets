import java.util.HashSet;
import java.util.Set;

/**
 * Created by dev on 12/01/2016.
 */
public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }
    //nwe hashset created so can't make uniteended alternations to originnal hashset field

    public boolean equals(Object obj) {
        //make sure to over-ride the equal method not overload, if we try to restrict the parameter to a HeavenlyBody,
        // it wil overload. Instead it looks like we use casting later to clarify/restrict
        if(this == obj) { //this checks to see if an object equals itself
//            System.out.println(this);
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) { // if the object is null or the classes between the
            //two objects is different, it returns false
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName(); // casted obj to a heavenlyBody and retrieve its name
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() { //command o for overriding
//        return this.name.hashCode(); //while this works, its not good practice such as if a String 'Pluto' was compared
        // to a HeavenlyBody 'Pluto'
        //can overridee your hashcodes howeever you like as long as the same object always generaes the same hascode
        // and makee sure not all objects have same hashcode. while this would eliminate duplication easily, it would
        // severely reduce the efficiency of Hashsets and such that use the 'hashbuckets' to search

        return this.name.hashCode() + 57; //this solves the problem ensuring no 0 number is set as hashcode. 57 is arbitary int
        //String hashcode for name is returning its own hashcode and we are just anding to ensure non-0
    }
}
