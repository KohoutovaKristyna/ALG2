/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.StatisticResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kristyna kohoutova
 */
public abstract class Writer {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    /**
     * Method enables to write the results to the file
     * @param resultFilepath is the path to the file
     * @param sResult is the list of results, we need to write to the file
     * @throws IOException if the process did not succeed
     */
    public abstract void saveResults(String resultFilepath, ArrayList<StatisticResult> sResult) throws IOException;
}
