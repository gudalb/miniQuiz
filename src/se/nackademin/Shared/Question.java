package se.nackademin.Shared;


import java.io.Serializable;
import java.util.*;

public class Question implements Serializable {
    String question;
    String[] answers;
    String correctAnswer;
    String category;
    static final long serialVersionUID = 1L;


    public Question (String category, String question, String ans1, String ans2, String ans3, String ans4) {
        this.question = question;
        this.category = category;
        this.answers = new String [] {ans1,ans2,ans3,ans4};
        this.correctAnswer = ans1;

        shuffleAnswers(this.answers);

    }

    public String[] shuffleAnswers (String[] answers) {
        Random r = new Random();

        for(int i = 0; i < answers.length; i++) {
            int rInt = r.nextInt(answers.length);
            String temp = answers[i];
            answers[i] = answers[rInt];
            answers[rInt] = temp;
        }

        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer () {
        return correctAnswer;
    }

    public String[] getAnswers () {
        return answers;
    }
}
