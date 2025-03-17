

class Main{
    public static void main(String[] args) {
        Date date1 = new Date(2025, 3, 17);
        Date date2 = new Date(2025, 3, 18);

        System.out.println(date1.isDayCorrect(31));
    }
}