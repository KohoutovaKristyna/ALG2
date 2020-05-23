/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author kristyna kohoutova
 */
public class AutoskolaEditor implements AppInterface {

    File filePath = new File(System.getProperty("user.dir") + File.separator + "data");
    String fileN = "QuestionsAndAnswers.xml";
    String fileName = filePath.toString() + File.separator + fileN;
    QuestionList questionList = utils.ImportXML.readFromXML(fileName);
    ArrayList<Result> results = new ArrayList<>();
    QuestionList selectedList = new QuestionList();
    Instant starts, ends;

    @Override
    public void createTestPerson(String jmeno, String prijmeni) {
        TestPerson t = new TestPerson(jmeno, prijmeni);
        selectTestQuestions();
    }

    @Override
    public String showQuestion(int number) {
        StringBuilder sb = new StringBuilder();
        
            sb.append(number + 1 + ". " + selectedList.getQuestion(number).getQuestion() + "\n");
            sb.append("a) " + selectedList.getQuestion(number).getAnwerList().get(0).getText() + "\n");
            sb.append("b) " + selectedList.getQuestion(number).getAnwerList().get(1).getText() + "\n");
            sb.append("c) " + selectedList.getQuestion(number).getAnwerList().get(2).getText() + "\n");
       
        return sb.toString();
    }

    public QuestionList selectTestQuestions() {
        questionList.shuffleQuestions();

        for (int i = 0; i < 10; i++) {
            selectedList.addQuestion(questionList.getQuestion(i));
        }
        return selectedList;
    }

    @Override
    public boolean takeAnswer(int questionNo, String answer) {
        if (answer.toLowerCase().equals("a")) {
            results.add(new Result(questionNo, answerOption.a));
            return true;
        } else if (answer.toLowerCase().equals("b")) {
            results.add(new Result(questionNo, answerOption.b));
            return true;
        } else if (answer.toLowerCase().equals("c")) {
            results.add(new Result(questionNo, answerOption.c));
            return true;
        } else {
            return false;
        }
    }
    
    public void joinSelectedListAndResults(){
        for (int i = 0; i < 10; i++) {
            results.get(i).setCorrectAnswer(selectedList.getQuestion(i).getCorrectAnswer());
        }
    }
    
    @Override
    public String giveResults(){
        joinSelectedListAndResults();
        int correct = 0, wrong = 0;
        String elapsedTime = "";
        String resultOutput= "";
        for (int i = 0; i < 10; i++) {
            if(results.get(i).getAnswered().equals(results.get(i).getCorrectAnswer())){
                correct++;
            }
            else{
                wrong++;
            }
        }
        elapsedTime = Duration.between(starts, ends).toString();
        elapsedTime = elapsedTime.replace("PT", "").replace("S", " sec").replace("M"," min a ").replace(".", ",");
        return resultOutput = ("Spravne zodpovezenych : "+ correct + "\n" + "Spatne zodpovezenych: "+ wrong + "\nDelka trvani testu byla: "+ elapsedTime);
        
    }

    @Override
    public void showByAlphabet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showByCorrectness() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endTimer() {
        ends = Instant.now();
    }

    @Override
    public void startTimer() {
        starts = Instant.now();
    }

}
