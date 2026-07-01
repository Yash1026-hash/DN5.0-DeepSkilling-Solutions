interface IPrinter {
    void print();
}

class LegacyPrinter {

    void printLegacy() {
        System.out.println("Printing from Legacy Printer");
    }
}

class PrinterAdapter implements IPrinter {

    private LegacyPrinter printer;

    public PrinterAdapter(LegacyPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void print() {
        printer.printLegacy();
    }
}

public class Adapter {

    public static void main(String[] args) {

        LegacyPrinter legacyPrinter = new LegacyPrinter();

        IPrinter adapter = new PrinterAdapter(legacyPrinter);

        adapter.print();

    }
}
