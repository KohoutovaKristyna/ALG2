/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kohoutova_hurricane;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author kristyna kohoutova
 */
public interface HurricaneInterface {
    public void load()throws FileNotFoundException, IOException;
    public String hurricanesInYears(int y1, int y2);
    public String hurricaneByName(String name);
    public String hurricaneInfoBySpeed();
}
