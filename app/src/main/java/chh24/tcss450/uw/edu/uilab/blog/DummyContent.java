package chh24.tcss450.uw.edu.uilab.blog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Student> STUDENTS = new ArrayList<Student>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Student> STUDENTS_MAP = new HashMap<String, Student>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createStudents(i));
        }
    }

    private static void addItem(Student item) {
        STUDENTS.add(item);
        STUDENTS_MAP.put(item.id, item);
    }

    private static Student createStudents(int position) {
        return new Student(String.valueOf(position), "Student Name" + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Student {
        public final String id;
        public final String name;
        public final String details;

        public Student(String id, String name, String details) {
            this.id = id;
            this.name = name;
            this.details = details;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
