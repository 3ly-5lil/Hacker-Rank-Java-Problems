package solved;

import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Student1 implements Comparable<Student1> {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student1(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }


    @Override
    public int compareTo(Student1 o) {
        if (this.getCgpa() != o.getCgpa()) {
            return Double.compare(o.getCgpa(), this.getCgpa());
        }
        else if (!Objects.equals(this.getName(), o.getName())){
            return this.getName().compareTo(o.getName());
        }
        return Integer.compare(this.getId(), o.getId());
    }
}

class Priorities {
    public List<Student1> getStudents (List<String> events) {
        PriorityQueue<Student1> priorityQueue = new PriorityQueue<>();
        List<Student1> students = new LinkedList<>();

        for (String event: events) {
            if (Objects.equals(event, "SERVED")) {
                priorityQueue.poll();
            }
            else {
                String[] split = event.split(" ");
                priorityQueue.add(new Student1(Integer.parseInt(split[3]), split[1], Double.parseDouble(split[2])));
            }
        }
        while (!priorityQueue.isEmpty()) {
            students.add(priorityQueue.poll());

        }

        return students;
    }
}

public class PriorityQu {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student1> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student1 st: students) {
                System.out.println(st.getName());
            }
        }
    }
}