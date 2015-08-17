/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

/**
 *
 * @author shanon
 */
public class DataHolderSingleton {
   private Board board;
   private Player player;
   private Challenge challenge;
   private GameTimer timer;
   //need to talk about what instance variables this needs.
   
   private static DataHolderSingleton dataHolder = new DataHolderSingleton( );
   
   private DataHolderSingleton(){ }  //private constructor so it can never be intitliased.

   public static DataHolderSingleton getInstance( ) {
      return dataHolder;
   }
   
   protected void setBoard(Board board ) {
      this.board = board;
   }
}    
