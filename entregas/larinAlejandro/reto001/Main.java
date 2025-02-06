public class Main {
    public static void main(String[] args) {
        String[] arrayNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        int[] arrayIntervaleMajor = {0, 2, 4, 5, 7, 9, 11};
        String note = "C"; 
        String[] scale = getScale(arrayNotes, arrayIntervaleMajor, note);

        if (scale != null) {
            for (String s : scale) {
                System.out.println(s);
            }
        }
    }

    public static String[] getScale(String[] arrayNotes, int[] arrayIntervaleMajor, String note) {
        String[] arrayScale = new String[arrayIntervaleMajor.length];
        int startIndex = -1;
        
        for (int i = 0; i < arrayNotes.length; i++) {
            if (arrayNotes[i].equals(note)) {
                startIndex = i;
            }
        }

        if (startIndex == -1) {
            System.err.println("Note not found in arrayNotes.");
            return null;
        }

        for (int i = 0; i < arrayIntervaleMajor.length; i++) {
            int noteIndex = (startIndex + arrayIntervaleMajor[i]) % arrayNotes.length;
            arrayScale[i] = arrayNotes[noteIndex];
        }

        return arrayScale;
    }
}
