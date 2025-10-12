package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        // 1)Creare 3 studenti a piacere
        Student luca = new Student(1, "Luca", "Moretti", "1111", 2023);
        Student giulia = new Student(2, "Giulia", "Rinaldi", "2222", 2024);
        Student marco = new Student(3, "Marco", "De Santis", "3333", 2024);
        // 2)Creare 2 docenti a piacere
        String[] coursesConti = {"Letteratura italiana" , "Storia dell’arte" , "Scrittura creativa" , "Educazione civica"};
        String[] coursesBianchi = {"Matematica" , "Fisica" , "Informatica" , "Logica e problem solving"};
        String[] coursesGallo = {"Biologia" , "Scienze della Terra" , "Chimica" , "Educazione ambientale"};
        Professor pConti = new Professor(001, "Sara", "Conti", "123", coursesConti);
        Professor pBianchi = new Professor(002, "Elena", "Bianchi", "456", coursesBianchi);
        Professor pGallo = new Professor(003, "Alessandro", "Gallo", "789", coursesGallo);
       
        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        ExamRoom roomA = new ExamRoom(100, null, false, false);
        ExamRoom roomB = new ExamRoom(80, null, false, false);

        // 4) Creare due esami, uno con nMaxStudents=10, l'altro con
        // nMaxStudents=2
        Exam physic = new Exam(1, 10, "Fisica", roomB, pBianchi);
        Exam chimic = new Exam(2, 2, "Chimica", roomA, pGallo);

        // 5) Iscrivere tutti e 3 gli studenti agli esami
        physic.registerStudent(marco);
        physic.registerStudent(giulia);
        physic.registerStudent(luca);

        chimic.registerStudent(marco);
        chimic.registerStudent(giulia);
        chimic.registerStudent(luca);
        
        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(physic.toString());
        System.out.println(chimic.toString());
    }
}
