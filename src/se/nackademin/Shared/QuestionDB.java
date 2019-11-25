package se.nackademin.Shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionDB {
    public List<Question> questionList = new ArrayList<>();
    final List<Question> categories = new ArrayList<>();

    final Question q1 = new Question("Star Wars","What vehicles did the Empire use in its assault on the rebels’ Hoth base? ", "AT-ATs","TIE Fighters ","Snowspeeders","TIE Bombers ");
    final Question q2 = new Question("Star Wars","Which one of these bounty hunters was a droid? ", "IG-88","Boba Fett","Jango Fett ","Bossk ");
    final Question q3 = new Question("Star Wars","Who infiltrated Jabba’s palace dressed as a bounty hunter named Boussh? ", "Princess Leia ","Lando Calrissian ","Chewbacca ","Luke Skywalker ");
    final Question q4 = new Question("Star Wars","Which creatures helped the rebels to destroy the Imperial shield generator at the forest moon of Endor? ", "Ewoks","Gungans ","Jawas","Wookiees ");
    final Question q5 = new Question("Star Wars","Who first discovered stormtroopers on Cloud City but couldn’t tell his friends? ", "C-3PO ","R2-D2","Chewbacca ","Han Solo ");
   // final Question q6 = new Question("Star Wars","Before Princess Leia is captured she hides the Death Star plans in the memory of R2-D2. To which planet did R2-D2 flees with fellow droid C-3PO? ", "Tatooine ","Dagobah ","Anoat","Bespin ");
    final Question q7 = new Question("Star Wars","How many forms of communication does C-3PO speak? ", "Over 6 million ","Over 6,000 ","Over 3 million ","Over 3,000 ");
    final Question q8 = new Question("Star Wars","What is the Rebel Alliance’s fastest starfighter? ", "A Wing ","X Wing ","B Wing ","Y Wing ");
    final Question q9 = new Question("Star Wars","What part of the pit droid did Jar Jar have to hit to get it to stop acting up? ", "Nose","Head ","Belly","Back");
    final Question q10 = new Question("Star Wars","What terrible creature attacks Luke Skywalker on Hoth? ", "Wampa ","Rancor","Tauntaun","Krayt dragon ");
    final Question q11 = new Question("Star Wars","Which Republic Senator was also the leader of the rebellion against the Empire? ", "Mon Mothma ","Padmé Amidala ","Toonbuck Toora ","Princess Leia ");
    final Question q12 = new Question("Star Wars","What did R2-D2 do that helped the Millennium Falcon escape from Darth Vader at Cloud City? ", "He fixed the hyperdrive ","He fixed the laser cannon ","He opened the door ","He repaired the shields ");
    final Question q13 = new Question("Computers","The acronym RAM stands for? ", "Random access memory","Random access microchips  ","Random access monitoring ","Random access machine ");
    final Question q14 = new Question("Computers","The acronym HDD stands for? ", "Hard disk drive","Hard disk display","High definition display","High definition data ");
    final Question q15 = new Question("Computers","The term hard copy refers to? ", "A physical paper print out","An email carbon copy","A copy saved on the hard drive","A copy saved to hard memory");
    final Question q16 = new Question("Computers","What is the main voltage that a standard power supply delivers? ", "12 volts","14 volts","120 volts ","10 volts");
    final Question q17 = new Question("Computers","The acronym USB stands for? ", "Universal serial bus","Universal segmented bus ","Unilateral semi binary","Uniform standard build ");
    final Question q18 = new Question("Computers","What AC voltage does a computer require from an outlet in the US? ", "120","240","60","12");
    final Question q19 = new Question("Computers","A computer's operating system is considered to be which of the following", "Software","Freeware","Hardware","Keyboard");
    final Question q20 = new Question("Computers","An example of computer hardware would be? ", "Video card","Web Browser","Operating system","Game ");
    final Question q21 = new Question("Computers","A floppy drive is considered a primitive form of? ", "Compact disk ","Flash drive","Hard drive","Tape drive ");
    final Question q22 = new Question("Computers"," An example of an I/O device is a? ", "Keyboard","Hard drive","Flash drive","Power supply ");

    public QuestionDB () {

        questionList.add(q1);
        questionList.add(q2);
        questionList.add(q3);
        questionList.add(q4);
        questionList.add(q5);
        //questionList.add(q6);
        questionList.add(q7);
        questionList.add(q8);
        questionList.add(q9);
        questionList.add(q10);
        questionList.add(q11);
        questionList.add(q12);
        questionList.add(q13);
        questionList.add(q14);
        questionList.add(q15);
        questionList.add(q16);
        questionList.add(q17);
        questionList.add(q18);
        questionList.add(q19);
        questionList.add(q20);
        questionList.add(q21);
        questionList.add(q22);

        Collections.shuffle(questionList);
    }


}
