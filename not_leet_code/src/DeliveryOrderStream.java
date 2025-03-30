import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeliveryOrderStream {
    private final static Comparator<DeliveryOrder> dateComparator = (o1, o2) -> {
        if (o1.getLocalDate().isAfter(o2.localDate)) {
            return 1;
        }
        if (o1.getLocalDate().isBefore(o2.localDate)) {
            return -1;
        }
        return 0;
    };

    // Метод find First Order принимает список заказов и должен возвращать первый / самый ранний заказ в списке в соответствии
    // со значением поля DeliveryDate. Если список пуст, метод должен возвращать порядок, созданный его конструктором по умолчанию ("пустой порядок").
    public static DeliveryOrder findFirstOrder(List<DeliveryOrder> orders) {
        return orders.stream()
                .min(dateComparator)
                .orElseGet(DeliveryOrder::new);
    }

    // Метод печати адресов для доставки также использует список заказов и должен печатать адреса, отсортированные по
    // дате доставки (от самой ранней до самой поздней), без дубликатов. Каждый адрес должен быть напечатан с новой строки.
    // Если список содержит дубликаты, следует распечатать только первый заказ, чтобы избежать повторного посещения одного и того же адреса.
    // Вернуть отсортированную коллекцию
    public static Collection<DeliveryOrder> printAddressesToDeliver(Collection<DeliveryOrder> orders) {
        return orders.stream().sorted(dateComparator).distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<DeliveryOrder> orders = List.of(
                new DeliveryOrder(1L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 9, 3)),
                new DeliveryOrder(2L, "369 Woodside Court, Troy, NY 12180", LocalDate.of(2021, 9, 5)),
                new DeliveryOrder(3L, "837 Bowman Street, Helena, MT 59601", LocalDate.of(2021, 9, 2)),
                new DeliveryOrder(4L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 9, 3)),
                new DeliveryOrder(5L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 10, 3)),
                new DeliveryOrder(6L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 8, 3))
        );

        System.out.println(findFirstOrder(orders));
        printAddressesToDeliver(orders).stream().map(DeliveryOrder::getString).forEach(System.out::println);
    }

    public static class DeliveryOrder {
        Long aLong;
        String string;
        LocalDate localDate;

        public DeliveryOrder() {
        }

        public DeliveryOrder(Long aLong, String string, LocalDate localDate) {
            this.aLong = aLong;
            this.string = string;
            this.localDate = localDate;
        }

        public String getString() {
            return string;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            DeliveryOrder that = (DeliveryOrder) o;
            return Objects.equals(string, that.string);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(string);
        }

        @Override
        public String toString() {
            return "DeliveryOrder{" +
                    "aLong=" + aLong +
                    ", string='" + string + '\'' +
                    ", localDate=" + localDate +
                    '}';
        }
    }
}
