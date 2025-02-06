package entregas.grizoniManuela;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reto001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Generador de Escalas y Acordes ===");
        
        System.out.print("Ingrese la nota raíz (ej: Do, Do#, Re, Re#, Mi, Fa, Fa#, Sol, Sol#, La, La#, Si): ");
        String rootInput = sc.nextLine().trim();
        Note root;
        try {
            root = new Note(rootInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Nota inválida: " + rootInput);
            return;
        }
       
        System.out.print("Ingrese el tipo de escala (mayor/menor): ");
        String typeInput = sc.nextLine().trim().toLowerCase();
        ScaleType scaleType;
        if (typeInput.equals("mayor")) {
            scaleType = ScaleType.MAJOR;
        } else if (typeInput.equals("menor")) {
            scaleType = ScaleType.MINOR;
        } else {
            System.out.println("Tipo de escala inválido: " + typeInput);
            return;
        }
        
        Scale scale = new Scale(root, scaleType);
        List<Note> scaleNotes = scale.getNotes();
        System.out.println("\nLa escala " + root.getName() + " " + typeInput + " es:");
        for (Note n : scaleNotes) {
            System.out.print(n.getName() + " ");
        }
        System.out.println();
        
        List<Chord> chords = scale.getChords();
        System.out.println("\nAcordes en la escala:");
        for (int i = 0; i < chords.size(); i++) {
            Chord c = chords.get(i);
            System.out.println((i + 1) + ": " + c);
        }
    }
}

class MusicUtils {
    public static final String[] NOTES = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    public static int getNoteIndex(String note) {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equalsIgnoreCase(note)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Nota no encontrada: " + note);
    }
    
    public static String getNoteName(int index) {
        return NOTES[((index % NOTES.length) + NOTES.length) % NOTES.length];
    }
}

class Note {
    private int index;

    public Note(String name) {
        this.index = MusicUtils.getNoteIndex(name);
    }

    public Note(int index) {
        this.index = ((index % 12) + 12) % 12;
    }

    public String getName() {
        return MusicUtils.getNoteName(index);
    }

    public Note transpose(int semitones) {
        return new Note(this.index + semitones);
    }
    
    public int getIndex() {
        return index;
    }
}

enum ScaleType {
    MAJOR, MINOR;
}

class Scale {
    private Note root;
    private ScaleType type;
    private int[] intervals;
 
    public Scale(Note root, ScaleType type) {
        this.root = root;
        this.type = type;
        if (type == ScaleType.MAJOR) {
            this.intervals = new int[] {2, 2, 1, 2, 2, 2, 1};
        } else if (type == ScaleType.MINOR) {
            this.intervals = new int[] {2, 1, 2, 2, 1, 2, 2};
        } else {
            throw new IllegalArgumentException("Tipo de escala no soportado");
        }
    }
    
    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        notes.add(root);
        int currentSemitone = root.getIndex();
        for (int interval : intervals) {
            currentSemitone += interval;
            notes.add(new Note(currentSemitone));
        }
        notes.remove(notes.size() - 1);
        return notes;
    }

    public List<Chord> getChords() {
        List<Note> scaleNotes = getNotes();
        List<Chord> chords = new ArrayList<>();
        int size = scaleNotes.size();
        for (int i = 0; i < size; i++) {
            Note n1 = scaleNotes.get(i);
            Note n2 = scaleNotes.get((i + 2) % size);
            Note n3 = scaleNotes.get((i + 4) % size);
            chords.add(new Chord(n1, n2, n3));
        }
        return chords;
    }
}

class Chord {
    private Note root;
    private Note third;
    private Note fifth;
    
    public Chord(Note root, Note third, Note fifth) {
        this.root = root;
        this.third = third;
        this.fifth = fifth;
    }

    private int interval(Note a, Note b) {
        int diff = b.getIndex() - a.getIndex();
        if (diff < 0) diff += 12;
        return diff;
    }

    public String getQuality() {
        int firstInterval = interval(root, third);
        int secondInterval = interval(third, fifth);
        if (firstInterval == 4 && secondInterval == 3) return "Mayor";
        if (firstInterval == 3 && secondInterval == 4) return "Menor";
        if (firstInterval == 3 && secondInterval == 3) return "Disminuido";
        return "Desconocido";
    }
    
    @Override
    public String toString() {
        return root.getName() + " " + getQuality() +
               " (" + root.getName() + ", " + third.getName() + ", " + fifth.getName() + ")";
    }
}
