package com.complains;

import camundajar.impl.scala.App;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named
public class AddEmailToEmailList implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");
        try{
        FileWriter fileWriter = new FileWriter("src/main/resources/emailList.txt",true);
        fileWriter.write(email+"\n");
        fileWriter.close();
        }
        catch (IOException e){
            System.err.println("IOException: " + e.getMessage());
        }

    }
}
