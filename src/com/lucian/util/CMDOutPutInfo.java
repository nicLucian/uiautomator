package com.lucian.util;

public class CMDOutPutInfo {
    private String successOutputInfo;
    private String errorOutputInfo;

    public CMDOutPutInfo() {
    }

    public CMDOutPutInfo(String successOutputInfo, String errorOutputInfo) {
        this.successOutputInfo = successOutputInfo;
        this.errorOutputInfo = errorOutputInfo;
    }

    public String getSuccessOutputInfo() {
        return successOutputInfo;
    }

    public void setSuccessOutputInfo(String successOutputInfo) {
        this.successOutputInfo = successOutputInfo;
    }

    public String getErrorOutputInfo() {
        return errorOutputInfo;
    }

    public void setErrorOutputInfo(String errorOutputInfo) {
        this.errorOutputInfo = errorOutputInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CMDOutPutInfo that = (CMDOutPutInfo) o;

        if (successOutputInfo != null ? !successOutputInfo.equals(that.successOutputInfo) : that.successOutputInfo != null)
            return false;
        return !(errorOutputInfo != null ? !errorOutputInfo.equals(that.errorOutputInfo) : that.errorOutputInfo != null);

    }

    @Override
    public int hashCode() {
        int result = successOutputInfo != null ? successOutputInfo.hashCode() : 0;
        result = 31 * result + (errorOutputInfo != null ? errorOutputInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CMDOutPutInfo{" +
                "successOutputInfo='" + successOutputInfo + '\'' +
                ", errorOutputInfo='" + errorOutputInfo + '\'' +
                '}';
    }
}
