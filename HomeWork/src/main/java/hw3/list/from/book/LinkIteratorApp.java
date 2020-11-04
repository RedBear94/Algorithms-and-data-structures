package hw3.list.from.book;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedListM list = new LinkedListM();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Pavel", 30);
        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);

        list.display();

        System.out.println("---------");
        System.out.println("Current after insertBefore: " + itr.getCurrent().name);

        System.out.println("");
        itr.nextLink();
        System.out.println("nextLink: " + itr.getCurrent().name);
        System.out.println("---------");

        itr.reset();
        System.out.println("Current after reset: " + itr.getCurrent().name);
        System.out.println("---------");

        while (!itr.atEnd()){
            itr.nextLink();
        }
        System.out.println("Current after atEnd: " + itr.getCurrent().name);
        itr.deleteCurrent(); //
        list.display();
    }

}
