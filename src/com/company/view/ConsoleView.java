package com.company.view;

import com.company.model.Student;
import com.company.repository.RegistrationSystemRepository;

import java.util.Scanner;

public class ConsoleView {

    public void run(){
        RegistrationSystemRepository registrationSystemRepository = new RegistrationSystemRepository();
        Scanner in = new Scanner(System.in);

        System.out.println("Name: ");
        String name = in.nextLine();
        System.out.println("Vorname: ");
        String vorname = in.nextLine();
        System.out.println("Studentausweis: ");
        String studentausweis = in.nextLine();
        Student student = new Student(name, vorname, Integer.parseInt(studentausweis), 0);
        registrationSystemRepository.addStudent(student);

        String s = "";

        while (!s.equals("9")) {
            System.out.println("1. An Kurs anmelden. \n" +
                    "2. Zeige die Kurse die freie Platze haben und ihre anzahl. \n" +
                    "3. Zeige Studenten die in einen Kurs angemeldet sind. \n" +
                    "4. Zeige alle Kurse \n" +
                    "5. Loschen einer Kurs. \n" +
                    "6. Zeige alle Studenten. \n" +
                    "7. Sortiere Studenten nach Credits. \n" +
                    "8. Filtriere die Studenten die weniger als 5 Credits haben. \n" +
                    "9. Exit. \n");
            s = in.nextLine();
            switch (s) {
                case "1":
                    System.out.println("Geben Sie den Name der Kurs: ");
                    name = in.nextLine();
                    try {
                        if(!registrationSystemRepository.register(registrationSystemRepository.getKursbyName(name), student)){
                            System.out.println("Keine freie platze an Kurs");
                        }
                    }
                    catch (IndexOutOfBoundsException ex){
                        System.out.println("Kurs existiert nicht");
                    }
                    break;
                case "2":
                    registrationSystemRepository.listKurs(registrationSystemRepository.retrieveCursesWithFreePlaces());
                    break;
                case "3":
                    System.out.println("Geben Sie den Name der Kurs: ");
                    name = in.nextLine();
                    try {
                        registrationSystemRepository.listStudent(registrationSystemRepository.retrieveStudentsEnrolledForACourse(registrationSystemRepository.getKursbyName(name)));
                    }
                    catch (IndexOutOfBoundsException ex){
                        System.out.println("Kurs existiert nicht");
                    }
                    break;
                case "4":
                    registrationSystemRepository.listKurs(registrationSystemRepository.getAllCurses());
                    break;
                case "5":
                    System.out.println("Geben Sie den Name der Kurs: ");
                    name = in.nextLine();
                    try{
                        //registrationSystemRepository.deleteKurs(registrationSystemRepository.getKursbyName(name));
                    }
                    catch (IndexOutOfBoundsException ex){
                        System.out.println("Kurs existiert nicht");
                    }
                    break;
                case "6":
                    registrationSystemRepository.listStudent(registrationSystemRepository.getAllStudents());
                    break;
                case "7":
                    registrationSystemRepository.listStudent(registrationSystemRepository.sortStudentsByCredits(registrationSystemRepository.getAllStudents()));
                    break;
                case "8":
                    registrationSystemRepository.listStudent(registrationSystemRepository.filterByCredit(registrationSystemRepository.getAllStudents(), 5));
                    break;
                case "9":
                    break;
            }
        }
    }
}
