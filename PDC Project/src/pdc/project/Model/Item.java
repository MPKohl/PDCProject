/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

/**
 *
 * @author MPKohl
 */
public abstract class Item {
    private String name;
    private int pointValue;
    private ItemType itemType;
    
    public Enum getItemType(){
        return itemType;
    }
    
    public void setName(){
        //Method to randomize the name with prefix and suffix
    }
    
}
