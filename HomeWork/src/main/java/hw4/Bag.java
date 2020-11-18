package hw4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Bag {
    private static List<Bag> bags = new ArrayList<>();

    private List<Box> boxList;
    private int w;
    private int p;

    public Bag(){
        this.boxList = new ArrayList<>();
        this.w = 0;
        this.p = 0;
    }

    public void addP(int p) {
        this.p += p;
    }

    public Bag(int w) {
        this.w = w;
    }

    public void setBag(List<Box> boxList) {
        this.boxList = boxList;
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public int getW() {
        return w;
    }

    public int getP() {
        return p;
    }

    public void addW(int w) {
        this.w += w;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "boxList=" + boxList +
                ", w=" + w +
                ", p=" + p +
                '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bag)) return false;
        Bag bag = (Bag) o;
        return w == bag.w &&
                p == bag.p &&
                Objects.equals(boxList, bag.boxList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boxList, w, p);
    }

    public static Bag bag = new Bag(5);

    public static void main(String[] args) {
        List<Box> things = new ArrayList<>();
        things.add(new Box(1, 1));
        things.add(new Box(2, 2));
        things.add(new Box(3, 6));
        things.add(new Box(1, 4));

        List<Bag> bags = findAllThingsCombination(things);
        bag = findLimitedWeightAndMaxPrice(bags, bag.getW());
        System.out.println(bag);
    }

    private static Bag findLimitedWeightAndMaxPrice(List<Bag> bags, int limitWeight) {
        Iterator<Bag> iterator = bags.iterator();

        while(iterator.hasNext()) {
            Bag bag = iterator.next();
            if(bag.getW()  > limitWeight){
                iterator.remove();
            }
        }

        Bag maxPriceBag = new Bag();

        for (int i = 0; i < bags.size(); i++){
            if(maxPriceBag.getP() < bags.get(i).getP()){
                maxPriceBag = bags.get(i);
            }
        }

        iterator = bags.iterator();
        while(iterator.hasNext()) {
            Bag bag = iterator.next();
            if(bag.getP() < maxPriceBag.getP()){
                iterator.remove();
            }
        }

        return maxPriceBag;
    }

    private static List<Bag> findAllThingsCombination(List<Box> things) {
        bags.clear();
        processCombo(things, things.size());
        for (int i = 0; i < bags.size(); i++){
            for (int j = 0; j < bags.size(); j++){
                if(j!=i && bags.get(i).equals(bags.get(j))) {
                    bags.remove(i);
                }
            }
        }
        return bags;
    }

    private static void processCombo(List<Box> things, int size) {
        if(size < 1){
            return;
        }

        if (size == 1) {
            Bag bag = new Bag();
            bag.getBoxList().add(things.get(0));
            bag.addW(things.get(0).getW());
            bag.addP(things.get(0).getP());
            bags.add(bag);
            return;
        }

        Bag bag = new Bag();
        for (int i = 0; i < size; i++) {
            List<Box> things_r = new ArrayList<>(things);
            Iterator<Box> iterator = things_r.iterator();
            iterator.next();
            iterator.remove();

            processCombo(things_r, size - 1);
            bag.getBoxList().add(things.get(i));
            bag.addW(things.get(i).getW());
            bag.addP(things.get(i).getP());
        }
        bags.add(bag);
    }
}
