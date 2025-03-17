class Main {
    public static void main(String[] args) {
        // Test para la clase Date
        Date date1 = new Date(2025, 3, 18);
        Date date2 = new Date(2025, 3, 19);

        System.out.println("Fecha 1: " + date1);
        System.out.println("Fecha 2: " + date2);
        System.out.println("¿Fecha 1 es igual a Fecha 2? " + date1.isDateEqual(date2));
        System.out.println("¿Fecha 1 es antes de Fecha 2? " + date1.isDateBefore(date2));
        System.out.println("¿Fecha 1 es después de Fecha 2? " + date1.isDateAfter(date2));

        date1.next();
        System.out.println("Fecha 1 después de next(): " + date1);

        date1.previus();
        System.out.println("Fecha 1 después de previus(): " + date1);

        // Test para la clase Time
        Time time1 = new Time(23, 59, 59);
        Time time2 = new Time(0, 0, 0);

        System.out.println("Hora 1: " + time1);
        System.out.println("Hora 2: " + time2);
        System.out.println("¿Hora 1 es igual a Hora 2? " + time1.isTimeEqual(time2));
        System.out.println("¿Hora 1 es antes de Hora 2? " + time1.isTimeBefore(time2));
        System.out.println("¿Hora 1 es después de Hora 2? " + time1.isTimeAfter(time2));

        time1.next();
        System.out.println("Hora 1 después de next(): " + time1);

        time1.previous();
        System.out.println("Hora 1 después de previous(): " + time1);

        Time time3 = time1.addTime(new Time(1, 30, 45));
        System.out.println("Hora 1 + 1:30:45 = " + time3);
    }
}