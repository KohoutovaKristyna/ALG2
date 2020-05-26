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
import java.io.IOException;
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
import utils.ImportBinary;
import utils.Writer;

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
    ArrayList<StatisticResult> sResult;
    
    @Override
    public void createTestPerson(String jmeno, String prijmeni) {
        this.testPerson = new TestPerson(jmeno, prijmeni);
        resetInformations();
        selectTestQuestions();
    }

    @Override
    public String showQuestion(int number) {
        StringBuilder sb = new StringBuilder();
        
            sb.append(number + 1 + ". " + selectedList.getQuestion(number).getQuestion() + "\n");
            sb.append("a) " + selectedList.getQuestion(number).getAnswerList().get(0).getText() + "\n");
            sb.append("b) " + selectedList.getQuestion(number).getAnswerList().get(1).getText() + "\n");
            sb.append("c) " + selectedList.getQuestion(number).getAnswerList().get(2).getText() + "\n");
       
        return sb.toString();
    }
    /**
     * Method select the shuffled question list and gives the first 10 questions 
     * @return the selected question list
     */
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
            selectedList.getQuestionList().get(questionNo).getAnswerList().get(0).setYourAnswer(true);
            return true;
        } else if (answer.toLowerCase().equals("b")) {
            results.add(new Result(questionNo, answerOption.b));
            selectedList.getQuestionList().get(questionNo).getAnswerList().get(1).setYourAnswer(true);
            return true;
        } else if (answer.toLowerCase().equals("c")) {
            results.add(new Result(questionNo, answerOption.c));
            selectedList.getQuestionList().get(questionNo).getAnswerList().get(2).setYourAnswer(true);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Method join the selected list with the results to the new list 
     */
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
        selectedList.sortByQuestionText();
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
    public String callThePreviousTestResults(){
        String fileName = testPerson.getJmeno()+ "." + testPerson.getPrijmeni() + ".txt";
        try{return showAllTestResults(fileName, false);
        }catch(Exception e){
            throw new RuntimeException("Nepodarilo se zapsat do souboru");
        }
        
    }
    @Override
    public boolean writeResultToFile(String firstName, String surName, String fileContent)  {
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
            
            throw new RuntimeException("Nepodarilo se zapsat do souboru");
        }
        return true;
    }

    @Override
    public void resetInformations() {
        results.clear();
        selectedList.getQuestionList().clear();
    }

      /**
     * Method shows the final statistic of all the results the user have
     * @param fileName is the name of the user's file
     * @param wantBinary is if we want to generate binary file with results
     * @return the formated string of the user's results
     */
    public String showAllTestResults(String fileName, boolean wantBinary) throws IOException, IllegalFilenameException {

        sResult = utils.ImportCsv.readStatisticResultFromCsv(System.getProperty("user.dir") + File.separator + "data" + File.separator + fileName);
        StringBuilder sb = new StringBuilder("");
        if (!fileName.matches("^[a-z]+\\.[a-z]+\\.txt")) {
            throw new IllegalFilenameException("Spatny nazev souboru");
        } else {
            for (int i = 0; i < sResult.size(); i++) {
                sb.append(String.format("Spravne: %2d  ", sResult.get(i).getCorrect()));
                sb.append(String.format("Spatne: %2d  ", sResult.get(i).getWrong()));
                sb.append(String.format("Delka testu: %-25s \n", sResult.get(i).getElapsedTime()));
            }
        }

        if(wantBinary){

        String folderName = System.getProperty("user.dir") + File.separator + "data";
        
            Writer w = null;
            w = new ImportBinary();
            w.saveResults(folderName + File.separator + String.format("%s.%s.dat", testPerson.getJmeno(), testPerson.getPrijmeni()), sResult);
        }
        
        return sb.toString();
    }
     /**
     * Method returns formated final results it is called it the showAllTestResults
     * @return the results
     */
    public String showFinalResults() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i + 1 + ". " + selectedList.getQuestion(i).getQuestion() + "\n");
            sb.append("a) " + selectedList.getQuestion(i).getAnswerList().get(0).getText() + "\n");
            sb.append("b) " + selectedList.getQuestion(i).getAnswerList().get(1).getText() + "\n");
            sb.append("c) " + selectedList.getQuestion(i).getAnswerList().get(2).getText() + "\n");
            sb.append("Správná odpověď: "+ selectedList.getQuestion(i).getCorrectAnswer()+"\n");
            sb.append("Vaše odpověď: "+ selectedList.getQuestion(i).getYourAnswer()+"\n");           
        }
        return sb.toString();
    }
    
}
