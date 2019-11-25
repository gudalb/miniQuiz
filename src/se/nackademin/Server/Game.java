package se.nackademin.Server;
import se.nackademin.Shared.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<PlayerServer> playerServerList = new ArrayList<>();
    QuestionDB qdb = new QuestionDB();
    public int questionCount = 0;
    Question currentQuestion = qdb.questionList.get(questionCount);
    public int playAgain = 0;
    public int answered = 0;
    public int loops = 0;


    public synchronized void processObj (PlayerServer playerServer, Object fromClient) throws IOException {

        if(fromClient instanceof Chat) {
            sendToPlayers(fromClient);
        }

        if(fromClient instanceof Answer) {
            String clientAnswer = ((Answer) fromClient).getAnswer();
            System.out.println(clientAnswer);
            answered++;
            loops++;
            if (currentQuestion.getCorrectAnswer().equals(clientAnswer)) {
                playerServer.score ++;
                System.out.println(playerServer.score);

            }
            System.out.println("antal svarat:"+answered);

            if (loops == (MainServer.questionsPerRound*MainServer.playersPerGame)) {
                sendPlayersScore();
                loops = 0;
            }

            if (answered/2 == MainServer.questionsPerRound*MainServer.rounds) {
                sendToPlayers(new Chat("Server", "End of game, play again?"));
                sendToPlayers(new Continue());
            }
             else if
                (answered % playerServerList.size() == 0) {
                questionCount++;
                resetList();
                //System.out.println("\tquestion count " + questionCount);
                currentQuestion = qdb.questionList.get(questionCount);
                sendToPlayers(currentQuestion);
                //answered = 0;
            }


        }

        if(fromClient instanceof Username) {
            playerServer.playerName = ((Username) fromClient).username;
        }

        if(fromClient instanceof PlayAgain) {
            PlayAgain temp = (PlayAgain) fromClient;
            if(temp.playAgain)
                playAgain++;
            if(!temp.playAgain)
                sendToPlayers(new Chat("Server", "Someone declined, stopping."));
            if (playAgain == MainServer.playersPerGame) {
                answered = 0;
                // temp
                resetList();
                questionCount++;
                currentQuestion = qdb.questionList.get(questionCount);
                sendToPlayers(currentQuestion);
                playAgain = 0;
                //answered = 0;
            }
        }

        if(fromClient instanceof Verify) {
            System.out.println("verify inkommit");
            System.out.println(playerServerList.size());
            if(playerServerList.size() == MainServer.playersPerGame) {
                sendToPlayers(currentQuestion);
                //questionCount++;
            }
        }
    }

    public synchronized void resetList () {
        if (questionCount == qdb.questionList.size()-1) {
            qdb = new QuestionDB();
            questionCount = 0;
        }
    }
    public synchronized void sendPlayersScore () throws IOException {
        sendToPlayers(new Chat("Server", "End of round. Printing score"));
            for (PlayerServer player: playerServerList) {
                sendToPlayers(new Chat("Server", player.playerName + " " + String.valueOf(player.score)));
            }
    }

    public synchronized void addToPlayerList (PlayerServer player) {
        playerServerList.add(player);
    }

    public synchronized void sendToPlayers (Object toClient) throws IOException {
        System.out.println(playerServerList.size());
        for(PlayerServer player: playerServerList) {
            player.sendToClient(toClient);
        }
    }
}
