package it.unibo.constructors;

class Student {

    String name;
    String surname;
    int id;
    int matriculationYear;

    Student(String name, String surname, int id, int matriculationYear) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        System.out.println("Student id: " + this.id);
        System.out.println("Student name: " + this.name);
        System.out.println("Student surname: " + this.surname);
        System.out.println("Student matriculationYear: " + this.matriculationYear + "\n");
    }

    /*public static void main(final String[] args) {
        final Student marioRossi = new Student("Mario", "Rossi", 1014,  2013);
        marioRossi.printStudentInfo();
 
        final Student luigiGentile = new Student("Luigi", "Gentile", 1015,  2012);
        luigiGentile.printStudentInfo();

        final Student simoneBianchi = new Student("Simone", "Bianchi", 1016,  2010);
        simoneBianchi.printStudentInfo();

        final Student andreaBracci = new Student("Andrea", "Bracci", 1017,  2012);
        andreaBracci.printStudentInfo();
    }*/
}
