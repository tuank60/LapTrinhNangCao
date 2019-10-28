/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Duy.hv150601
 */
public class Common {
    public static boolean CheckSpace(String str){
        boolean hasSpace= false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                hasSpace= true;
                break;
            }
        }
        return hasSpace;
    }
}
