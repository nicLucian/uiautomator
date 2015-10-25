package com.lucian.test;

import com.lucian.util.CMDUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CMDUtilTest {
    @Test
    public void testExecCommand() {
        String testCommand = "cmd /c java -version";
        System.out.println(CMDUtil.execCMD(testCommand));
    }

    @Test
    public void testExec() throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("cmd /c start dir");
        InputStream is = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        p.waitFor();
        is.close();
        reader.close();
        p.destroy();
    }

}
