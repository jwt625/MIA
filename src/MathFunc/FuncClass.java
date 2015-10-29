package MathFunc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Others.*;
/**
 * Created by IIIS on 10/28/2015.
 */
public class FuncClass {
    String FuncClassName;
    MathFunc[] AllMathFunc;
    int NumOfFunc;

    public FuncClass(){
        FuncClassName="";
        NumOfFunc=0;
        AllMathFunc=new MathFunc[50];
        for(int i = 0; i < 50; i++){
            AllMathFunc[i]=new MathFunc();
        }
    }
    public void setFuncClassName(String classname){FuncClassName = classname;}
    public void print(){
        System.out.print("FuncClass name: ");
        System.out.println(FuncClassName);
        System.out.print("include functions:\n");
        for(int i = 0; i < NumOfFunc; i++){
            AllMathFunc[i].print();
        }
    }

    public void readFunc(String classname) {

        //System.out.println(classname);

        FuncClassName=classname;
        String FilePath = System.getProperty("user.dir")+"\\"+classname+"\\"+classname+".txt";
        File file = new File(FilePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String funcname = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((funcname = reader.readLine()) != null) {
                AllMathFunc[line-1].readPara(System.getProperty("user.dir")+"\\"+classname, funcname);
                AllMathFunc[line-1].readParaFreq(System.getProperty("user.dir")+"\\"+classname, funcname);
                NumOfFunc++;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    public void readFuncFreq(String classname){
        Others otherFuncs=new Others();
        String FilePath = System.getProperty("user.dir")+"\\"+classname+"\\"+classname+"freq.txt";
        File file = new File(FilePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String freq = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((freq = reader.readLine()) != null) {
                AllMathFunc[line-1].setUseFreq(otherFuncs.String2int(freq));
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

    }

}
