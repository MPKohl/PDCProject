/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

import java.util.ArrayList;

/**
 *
 * @author MPKohl
 */
public class Challenge extends Tile {
    
    Question question;
    CorrectAnswer correctAsnwer;
    ArrayList<WrongAnswer> wrongAnswers = new ArrayList<>();
    
    public Challenge(){
        setType(TileType.CHALLENGE);
    }
    
    //Timer
}
