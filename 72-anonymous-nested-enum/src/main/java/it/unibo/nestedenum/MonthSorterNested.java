package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.List;
import it.unibo.functional.Transformers;
import it.unibo.functional.api.Function;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    enum Month{
        JANUARY(Month.LONG_DAYS),
        FEBRUARY(Month.SHORT_DAYS),
        MARCH(Month.LONG_DAYS),
        APRIL,
        MAY(Month.LONG_DAYS),
        JUNE,
        JULY(Month.LONG_DAYS),
        AUGUST(Month.LONG_DAYS),
        SEPTEMBER,
        OCTOBER(Month.LONG_DAYS),
        NOVEMBER,
        DECEMBER(Month.LONG_DAYS);

        public static final int DEFAULT_DAYS = 30;
        public static final int LONG_DAYS = 31;
        public static final int SHORT_DAYS = 28;

        private final int days;

        private Month(final int days) {
            this.days = days;
        }

        private Month() {
            this(DEFAULT_DAYS);
        }

        public int getDays() {
            return this.days;
        }

        public static Month fromString(final String monthName) throws IllegalArgumentException {
          final String monthNameUpper = monthName.toUpperCase();
          final List<Month> list = Transformers.select(
                List.of(Month.values()), 
                new Function<Month, Boolean>() {
                    @Override
                    public Boolean call(Month input) {
                        return input.toString().startsWith(monthNameUpper);
                    }
                    
                }
            ); 
          
          if (list.size() == 1){
            return list.get(0);
          }
          else {
            throw new IllegalArgumentException("Invalid month name");
          }
        }
    }

    private final class SortByDays implements Comparator<String>{

        @Override
        public int compare(String arg0, String arg1) {
            final Month month0 = Month.fromString(arg0);
            final Month month1 = Month.fromString(arg1);
            return month0.getDays() - month1.getDays();
        }

    }
    @Override
    public Comparator<String> sortByDays() {
        return new SortByDays();
    }

    private final class SortByOrder implements Comparator<String> {

        @Override
        public int compare(String arg0, String arg1) {
            final Month month0 = Month.fromString(arg0);
            final Month month1 = Month.fromString(arg1);
            return month0.compareTo(month1);
        }

    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByOrder();
    }
}
