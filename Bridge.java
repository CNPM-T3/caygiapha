/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caygiapha;

/**
 *
 * @author ADT
 */
public class Bridge {
    static private String[] data;
    static private boolean gate;
    
    static public void setData(String[] data){
        Bridge.data=data;
        gate=true;
    }
    
    static public String[] getData(){
        gate=false;
        return data;
    }
    
    static public boolean isOpen(){
        return gate;
    }
}
