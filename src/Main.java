import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//will create a map of heavenly bodies, then declare sets to perform the grouping
public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();


    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);


        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        //note how temp is redefined and tempMoon but new instances still created with same variable. mo

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        //only references for objeects stored in the sets. Europa for example appears in the solar system map
        // and the set of sateellitees for jupiteer but there is only onee instance of th heavenly bod class for Europa
        //can leead to a commo mistake with collections where the sets would contain the rferenes to the names of
        //the bodies instead of the refeereenes to them. If the actual object has lots of memory assocaited with it like
        // if we actually listed a whole bunch of stuff about Europa, its just more practical to use the refeernce to
        // the object through the String name in the sets. But referene to a String is the same size as a reefernce to
        // any other object? Getting a little lost here without a direect example

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

//        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
//        planets.add(pluto);
//
//        for(HeavenlyBody planet : planets) {
//            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
//        }
        // this would show that pluto is effectively added again. although pluto is already listed as a planet, the
        // orbital periods are different so the two objects do not compare equal. so the equals method has to be
        // overridden in HeavenlyBody class. The problem is that the Object base class from which all other classes are
        // derived performs referential equality where if both references point to the same object, they are equal
        // if they don't, then they are not.

        Object o = new Object();
        o.equals(o);
        //this Object self reference is just to display the below content pulled from the Object class, showing that the
        //method simply uses an '==' comparison format. 'referential equality'
        //  public boolean equals(Object obj) {
        //        return (this == obj);
        //    }
        "pluto".equals("");
        // this is written again just to display how equality for a String object is much more complex than referential equality

        //a danger of using a simple referential comparison is that if our class is subclassed that we compare a subclass
        //obeject to super class object it may return as equal when not
        // if two objects compare equal, theen their hashcodes should  be the same (but apparntly this is note innateley true) \
        // so we also need to overrride the hashcode method.
        // Wheen storing items as a hashset or hashmap, think of collection as having a numbre of buckets to store objects in
        // any objects that are equal should have the same hashcode, such that they will end up in the same bucket.
        // tim gets kinda confusing here, but if the two objects that are equal have different hashcodes, and as a result they
        // are in different buckets, it can lead to problems where java is looking in the wrong hashcode bucket and will
        // not find the old object that the new object is equivaleent to, and as a reesult will add the duplicatee object to
        // a different hashcode bucket within the collection. Even worse, if we iterrate through the collection, we may retrieve
        // the wrong object

        //tim doees state that things get tricky with people where duplicate names may exist such that a second step
        // in comparison will be required such as, if the name is the same, check their SSN or birthdate or something to ensuree
        // that we are working with thee correect pereson


    }
}
