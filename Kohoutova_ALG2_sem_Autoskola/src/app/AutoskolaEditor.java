/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import utils.IllegalFilenameException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    TestPerson testPerson = null;
    ArrayList<StatisticResult> sResult = new ArrayList<>();
    
    @Override
    public void createTestPerson(String jmeno, String prijmeni) {
        this.testPerson = new TestPerson(jmeno, prijmeni);
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
            selectedList.getQuestionList().get(questionNo).getAnwerList().get(0).setYourAnswer(true);
            return true;
        } else if (answer.toLowerCase().equals("b")) {
            results.add(new Result(questionNo, answerOption.b));
            selectedList.getQuestionList().get(questionNo).getAnwerList().get(1).setYourAnswer(true);
            return true;
        } else if (answer.toLowerCase().equals("c")) {
            results.add(new Result(questionNo, answerOption.c));
            selectedList.getQuestionList().get(questionNo).getAnwerList().get(2).setYourAnswer(true);
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
        String fileContent = "";
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
        
        fileContent = String.format("%s;%s;%s%n", correct, wrong, elapsedTime);
        writeResultToFile(this.testPerson.getJmeno(), this.testPerson.getPrijmeni(), fileContent);
        resultOutput = ("Spravne zodpovezenych : "+ correct + "\n" + "Spatne zodpovezenych: "+ wrong + "\nDelka trvani testu byla: "+ elapsedTime);
        return resultOutput;
    }

    @Override
    public String showByAlphabet() {
        selectedList.sortByGNumber();
        return showFinalResults();
        
    }

    @Override
    public String showByCorrectness() {
        selectedList.sortByCorrectnes();
        return showFinalResults();
    }

    @Override
    public void endTimer() {
        ends = Instant.now();
    }

    @Override
    public void startTimer() {
        starts = Instant.now();
    }
    
    @Override
    public String callThePreviousTestResults() {
        String fileName = testPerson.getJmeno()+ "." + testPerson.getPrijmeni() + ".txt";
        return showAllTestResults(fileName);
    }

    @Override
    public boolean writeResultToFile(String firstName, String surName, String fileContent) {
        String folderName = System.getProperty("user.dir") + File.separator + "data";
        String fileName = folderName + File.separator + String.format("%s.%s.txt", firstName, surName);
                
        try {
            File f1 = new File(fileName);
            if (f1.exists()) {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
                bw.write(fileContent);
                bw.flush();
                bw.close();
            } else {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, false)));
                bw.write(fileContent);
                bw.flush();
                bw.close();
            }
        } catch (Exception e) {
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return true;
    }

    @Override
    public void resetInformations() {
        //??? asi
        ArrayList<Result> results = null;
        QuestionList selectedList = null;
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String showAllTestResults(String fileName) {
        StringBuilder sb = new StringBuilder("");
        if (!fileName.matches("^[a-z]+\\.[a-z]+\\.txt")) {
            throw new IllegalArgumentException("Spatny nazev souboru");
        } else {
            for (int i = 0; i < sResult.size(); i++) {
                sb.append("Spravne: " + sResult.get(i).getCorrect() + " ");
                sb.append("Spatne: " + sResult.get(i).getWrong() + " ");
                sb.append("Delka testu: " + sResult.get(i).getElapsedTime() + " \n");
            }
        }
        return sb.toString();
    }

    /* 
    
    regex - jako parametr do prikazove radky pro soubory odpovídající masce DUC.KEY.* "^DUC\.KEY.*$", ruzné od DUC.KEY.* je regex "^(?!DUC\.KEY).*$"  
    
    "^[a-z]+\.[a-z]+\.txt"
    pro kristyna.kohoutova.txt
       
    
     */
    public String showFinalResults() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i + 1 + ". " + selectedList.getQuestion(i).getQuestion() + "\n");
            sb.append("a) " + selectedList.getQuestion(i).getAnwerList().get(0).getText() + "\n");
            sb.append("b) " + selectedList.getQuestion(i).getAnwerList().get(1).getText() + "\n");
            sb.append("c) " + selectedList.getQuestion(i).getAnwerList().get(2).getText() + "\n");
            sb.append("Správná odpověď: "+ selectedList.getQuestion(i).getCorrectAnswer()+"\n");
            sb.append("Vaše odpověď: "+ selectedList.getQuestion(i).getYourAnswer()+"\n");
                    
        }

        return sb.toString();
    }

    
}
