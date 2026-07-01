interface SortingStrategy {
    void sort();
}

class BubbleSort implements SortingStrategy {

    @Override
    public void sort() {
        System.out.println("Sorting using Bubble Sort");
    }

}

class QuickSort implements SortingStrategy {

    @Override
    public void sort() {
        System.out.println("Sorting using Quick Sort");
    }

}

class Sorter {

    private SortingStrategy strategy;

    public Sorter(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void performSort() {
        strategy.sort();
    }

}

public class Strategy {

    public static void main(String[] args) {

        Sorter sorter = new Sorter(new BubbleSort());
        sorter.performSort();

        sorter = new Sorter(new QuickSort());
        sorter.performSort();

    }

}