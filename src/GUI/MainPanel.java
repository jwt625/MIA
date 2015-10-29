package GUI;

import FileIO.*;
import Math.*;

/**
 * Created by IIIS on 10/28/2015.
 */
public class MainPanel {
    public static void main(String[] args){
        ReadFuncClass classReader = new ReadFuncClass();

        FuncClass[] AllFuncClass = new FuncClass[10];
        for(int i = 0; i < 10; i++){
            AllFuncClass[i]=new FuncClass();
        }
        classReader.readClass(AllFuncClass);
        AllFuncClass[0].print();
    }

}
