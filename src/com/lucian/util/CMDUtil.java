package com.lucian.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMDUtil {
    public static CMDOutPutInfo execCMD(String command) {
        Process process = null;
        BufferedReader processSuccessReader = null;
        BufferedReader processErrorReader = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec(command);
            processSuccessReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            processErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String successOutputInfo = getProcessOutputInfo(processSuccessReader);
            String errorOutputInfo = getProcessOutputInfo(processErrorReader);
            return new CMDOutPutInfo(successOutputInfo, errorOutputInfo);
        } catch (IOException e) {
            return null;
        } finally {
            closeResource(process, processSuccessReader, processErrorReader);
        }
    }

    private static String getProcessOutputInfo(BufferedReader processSuccessReader) throws IOException {
        StringBuilder returnMsgBuilder = new StringBuilder();
        String line;
        while ((line = processSuccessReader.readLine()) != null) {
            returnMsgBuilder.append(line);
        }
        return returnMsgBuilder.toString();
    }

    private static void closeResource(Process process,
                                      BufferedReader processSuccessReader,
                                      BufferedReader processErrorReader) {
        if (null != process) {
            process.destroy();
        }
        if (null != processSuccessReader) {
            try {
                processSuccessReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (null != processErrorReader) {
            try {
                processErrorReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
