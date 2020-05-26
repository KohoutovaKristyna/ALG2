/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.StatisticResult;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author kristyna kohoutova
 */
public class ImportBinary extends Writer {
    /**
     *  Writes the results to the binary file
     * @param resultFilepath the path to the file
     * @param sResult is the list of results, we need to write to the file
     * @throws IOException if the process did not succeed
     */
    @Override
    public void saveResults(String resultFilepath, ArrayList<StatisticResult> sResult) throws IOException {
        
        if (sResult != null) {
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFilepath))) {
                for (int n = 0; n < sResult.size(); n++) {
                    int nCorrect = sResult.get(n).getCorrect(); 
                    dos.writeInt(nCorrect);
                    int nWrong = sResult.get(n).getWrong(); 
                    dos.writeInt(nWrong);

                    String elChars = sResult.get(n).getElapsedTime();
                    dos.writeUTF(elChars);
                }
            } catch (IOException ex ){
                throw new IOException("Nepodarilo se zapsat do bin souboru");
            }
        }
    }
    
    public ArrayList<StatisticResult> readResults(String resultFilepath) throws IOException {
        ArrayList<StatisticResult> sr = new ArrayList<StatisticResult>();
                
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"))) {
            while (dis.available() > 0) {

                    int nCorrect = dis.readInt(); 
                    int nWrong = dis.readInt();
                    String elapsedTime = dis.readUTF();
                    StatisticResult s = new StatisticResult(nCorrect, nWrong, elapsedTime);
                    sr.add(s);
            }
        } catch (IOException ex) {
            throw new IOException("Nepodarilo se precist z bin souboru");
        }
        return sr;
    }
}
