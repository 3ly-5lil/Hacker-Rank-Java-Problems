package solved;

import java.util.*;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class ComparatorProb
{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Comparator<Student> STUDENT_COMPARATOR = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int cgpa = Double.compare(o2.getCgpa(), o1.getCgpa());
                if (cgpa != 0) return cgpa;

                int fname = o1.getFname().compareTo(o2.getFname());
                if (fname != 0) return fname;

                return Integer.compare(o2.getId(), o1.getId());
            }
        };

        studentList.sort(STUDENT_COMPARATOR);

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}



