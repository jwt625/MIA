package Math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IIIS on 10/28/2015.
 */
public class FuncClass {
    String FuncClassName;
    MathFunc[] AllMathFunc;
    public FuncClass(){
        FuncClassName="";
        AllMathFunc=new MathFunc[50];
        for(int i = 0; i < 10; i++){
            AllMathFunc[i]=new MathFunc();
        }
    }
    public void setFuncClassName(String classname){FuncClassName = classname;}
    public void print(){System.out.println(FuncClassName);}

    public void readFunc(String classname) {

        System.out.println(classname);

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
                AllMathFunc[line-1].readPara(classname, funcname);
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
