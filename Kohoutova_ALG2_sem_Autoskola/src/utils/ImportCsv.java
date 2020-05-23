/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author kristyna kohoutova
 */
public class ImportCsv {

    public static ArrayList<app.StatisticResult> readStatisticResultFromCsv(String fileName){
        
        ArrayList<app.StatisticResult> statistic = new ArrayList<>();
        String row;
        ArrayList<String> rows = new ArrayList<>();

        File csvFile = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            while ((row = br.readLine()) != null)
            {
                rows.add(row);
            }
        }
        catch (Exception e)
        {
       	     e.getMessage();
        }
        
        for (String toParse: rows) {
            app.StatisticResult result = getParsedStatisticRow(toParse);
            statistic.add(result);
        }
        return statistic;
    }
    
    public static app.QuestionList readQuestionsFromCsv(String fileName){
        app.QuestionList questions = new app.QuestionList(); 
        String row;
        ArrayList<String> rows = new ArrayList<>();

        File csvFile = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            while ((row = br.readLine()) != null)
            {
                rows.add(row);
            }
        }
        catch (Exception e)
        {
       	     e.getMessage();
        }
        
        for (String toParse: rows) {
            app.Question question = getParsedQuestionRow(toParse);
            questions.addQuestion(question);
        }
        return questions;
    }
    
    private static app.StatisticResult getParsedStatisticRow(String toParse) {
        app.StatisticResult result = new app.StatisticResult();
        String dataToParse;
        
        String delimiterChars = ";";
        String[] values = toParse.split(delimiterChars);
        for (int i = 0; i < values.length; i++) { 
            if (i == 0) { result.setCorrect(Integer.parseInt(values[i])); }
            if (i == 1) { result.setWrong(Integer.parseInt(values[i])); }
            if (i == 2) { result.setElapsedTime(values[i]); }
        }
        return result;
    }
    
        private static app.Question getParsedQuestionRow(String toParse) {
        app.Question question = new app.Question();
        String dataToParse;
        
        String delimiterChars = ";";
        String[] values = toParse.split(delimiterChars);
        for (int i = 0; i < values.length; i++) { 
            if (i == 0) { question.setqNumber(Integer.parseInt(values[i])); }
            if (i == 1) { question.setQuestion(values[i]); }
            if (i == 2 || i == 3 || i == 4) { 
                dataToParse = values[i]; 
                app.Answer answer = new app.Answer();
                if (dataToParse.contains("++")) {  
                    answer.setIsCorrect(Boolean.TRUE);
                    dataToParse = dataToParse.replace("++", "");  // odstrani se "++", aby to nematlo
                } else {
                    answer.setIsCorrect(Boolean.FALSE);
                }
                if (dataToParse.length() > 2) {
                    answer.setAnwerID(dataToParse.substring(0, 1));  // ulozi se a nebo b nebo c
                    dataToParse = dataToParse.substring(3);  // Od znaku 3 do konce
                }
                answer.setText(dataToParse);  // vlastni text odpovedi bez a) a bez "++"
                question.addToAnswers(answer);
            }
        }
        return question;
    }
}
