package Math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IIIS on 10/28/2015.
 */
public class MathFunc {
    String FuncName;
    Para[] AllPara;
    int NumOfPara;
    int UseFreq;
    public MathFunc(){
        FuncName="";
        AllPara=new Para[100];
        for(int i = 0; i < 10; i++){
            AllPara[i]=new Para();
        }
        NumOfPara=0;UseFreq=0;}

    public void oneUse(){UseFreq++;}
    public void setFuncName(String funcname){FuncName=funcname;}
    public void setAllPara(Para[] NewParas){
        NumOfPara = NewParas.length;
        for(int i = 0; i < NumOfPara; i++){
            AllPara[i] = NewParas[i];
        }
    }
    public void addPara(Para NewPara){
        AllPara[NumOfPara] = NewPara;
        NumOfPara++;
    }

    public int getUseFreq(){return UseFreq;}
    public int getNumOfPara(){return NumOfPara;}
    public String getFuncName(){return FuncName;}
    public Para[] getAllPara(){return AllPara;}
    public void print(){System.out.println(FuncName);}

    public void readPara(String classname, String funcname) {

        System.out.println(funcname);

        FuncName=funcname;
        String FilePath = System.getProperty("user.dir")+"\\"+classname+"\\"+funcname+"\\"+funcname+".txt";
        File file = new File(FilePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String paraname = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((paraname = reader.readLine()) != null) {
                AllPara[line-1].loadPara(System.getProperty("user.dir")+"\\"+classname+"\\"+funcname, paraname);
                NumOfPara++;
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
