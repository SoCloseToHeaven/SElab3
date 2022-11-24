package stories;

import characters.*;
import locations.*;
import enums.*;
import planes.Plane;

public class MainStory {
    static Location base = new Location("База Дайера", 13.87, 44.55);
    static Location bayMcMerdo = new Location("Залив Мак-Мердо", 1.55, 78.35);
    static Location arkham = new Location("Бриг Архэм", 47.2532, 97.543);
    static Location lakesCamp = new Location("Лагерь Лейка", 84.236, 11.243);
    static Person dayer = new Geologist("Дайер", base); //MainCharacter
    static Person goonarson = new Sailor("Гунарсон", bayMcMerdo);
    static Person larsen = new Sailor("Ларсен", bayMcMerdo);
    static Person douglas = new Sailor("Дуглас", arkham);
    static Person sherman = new Physicist("Шерман", bayMcMerdo);
    static Person torfinsen = new Sailor("Торфинсен", arkham);
    static Person lake = new Biologist("Лейк", lakesCamp);
    static Plane fifthplane = new Plane(bayMcMerdo) {
        @Override
        public String describe() {
            return "Огромный пятый самолёт команды, сконструированный по специальному заказу " +
                    "для перевозки тяжелого оборудования и готовый к полёту стоит в локации " + this.getLocation();
        }
    };
    private MainStory() {}

    public static void start() {
        for (MainStoryTimeLines currentTime : MainStoryTimeLines.values()) {
            System.out.println(currentTime.describe());
            switch (currentTime) {
                case SIX_PM -> {
                    dayer.setAction(Action.TREMBLING_IN_FEAR);
                    douglas.setAction(Action.TREMBLING_IN_FEAR);
                    torfinsen.setAction(Action.TREMBLING_IN_FEAR);
                }
                case HALF_SEVEN_PM ->
                        dayer.callByRadio(douglas).callByRadio(torfinsen).setAction(Action.FEELING_DETERMINED);
                case SEVEN_PM -> {
                    System.out.println(fifthplane.describe());
                    dayer.callByRadio(sherman).setAction(Action.PREPARING_FOR_FLIGHT);
                    sherman.setAction(Action.PREPARING_FOR_FLIGHT);
                    goonarson.setAction(Action.PREPARING_FOR_FLIGHT);
                    larsen.setAction(Action.PREPARING_FOR_FLIGHT);
                    dayer.callByRadio(lake);
                }
                case HALF_EIGHT_PM ->
                    fifthplane.addPassenger(sherman).addPassenger(goonarson).addPassenger(larsen).fly(base);
                case EIGHT_PM, NINE_PM, TEN_PM, ELEVEN_PM -> sherman.callByRadio(dayer);
                case TWELVE_PM -> {
                    fifthplane.land();
                    dayer.setAction(Action.PARTICIPATING_IN_MEETING);
                    sherman.setAction(Action.PARTICIPATING_IN_MEETING);
                    goonarson.setAction(Action.PARTICIPATING_IN_MEETING);
                    larsen.setAction(Action.PARTICIPATING_IN_MEETING);
                }
                case ONE_AM, SIX_AM -> {
                    dayer.setAction(Action.PREPARING_FOR_FLIGHT);
                    sherman.setAction(Action.PREPARING_FOR_FLIGHT);
                    goonarson.setAction(Action.PREPARING_FOR_FLIGHT);
                    larsen.setAction(Action.PREPARING_FOR_FLIGHT);
                }
                case TWO_AM, THREE_AM, FOUR_AM, FIVE_AM -> {
                    dayer.setAction(Action.RESTING);
                    sherman.setAction(Action.RESTING);
                    goonarson.setAction(Action.RESTING);
                    larsen.setAction(Action.RESTING);
                }


            }
            System.out.println("\n");
        }
        System.out.println("История завершилась");
    }
    @Override
    public boolean equals(Object obj) { // не имеет смысла, тк создать объект класса невозможно
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass())
            return true;
        return false;
    }

    @Override
    public int hashCode() { // у объекта класса нет полей
        return 31;
    }

    @Override
    public String toString() { // тоже смысла не имеет
        return "";
    }
}
